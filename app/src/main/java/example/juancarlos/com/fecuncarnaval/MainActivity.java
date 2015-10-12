package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private TextView info;
    private LoginButton loginButton;
    private TextView txtFbStatus;
    private CallbackManager callbackManager;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);
        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions(Collections.singletonList("public_profile, email, user_birthday, user_friends"));
        loginButton.setReadPermissions("public_profile");
        loginButton.setReadPermissions("user_friends");
        loginButton.setReadPermissions("public_profile");
        loginButton.setReadPermissions(Collections.singletonList("email"));
        loginButton.setReadPermissions("user_birthday");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult)
            {
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
        });

        txtFbStatus = (TextView) this.findViewById(R.id.txtFbStatus);

        if(AccessToken.getCurrentAccessToken()!=null)
        {
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
    protected void onResume()
    {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
        ejecutar();

    }

    @Override
    protected void onPause()
    {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
        ejecutar();

    }

    public void ejecutar()
    {
        if(AccessToken.getCurrentAccessToken()!=null)
        {
            txtFbStatus.setText("Session iniciada");
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);
        }
    }




}
