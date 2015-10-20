package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView info;
    private LoginButton loginButton;
    private TextView txtFbStatus;
    private CallbackManager callbackManager;
    RequestQueue requestQueue;
    private String id;
    private String nombre;
    private String fecha;
    String insertUrl = "http://festum1.comule.com/insertUsuario.php";
    private AccessToken accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        info = (TextView) findViewById(R.id.info);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Collections.singletonList("public_profile, email, user_birthday, user_friends"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult)
            {

                loginResult.getAccessToken().getUserId();
               accessToken = loginResult.getAccessToken();
                infoUsuario();
                ejecutar();


            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
            }


        }

        );

        txtFbStatus = (TextView) this.findViewById(R.id.txtFbStatus);

        if (AccessToken.getCurrentAccessToken() != null) {
            txtFbStatus.setText("Session iniciada");
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);


    }

    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
        //ejecutar();

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
       // ejecutar();

    }

    public void ejecutar() {
        if (AccessToken.getCurrentAccessToken() != null) {
            txtFbStatus.setText("Session iniciada");
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);
        }
    }




    public void infoUsuario() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {
                            txtFbStatus.setText("Id usuario" + object.get("id") + "\n" + "Nombre " + object.get("name") + "\n " + " nacimiento " + object.get("birthday"));
                            nombre = (String) object.get("name");
                            id = String.valueOf(object.get("id"));
                            fecha = (String) object.get("birthday");
                            Usuario usuario = new Usuario(nombre,id,fecha);
                            agregarUsusario();
                            // String email = (String) object.get("email");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender, birthday");
        request.setParameters(parameters);
        request.executeAsync();
    }

    public void agregarUsusario()
    {
        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();
                parameters.put("nombre", nombre.toString());
                parameters.put("id",id.toString());
                parameters.put("fechaN",fecha.toString());

                return parameters;
            }
        };
        requestQueue.add(request);
    }



}
