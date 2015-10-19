package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivityFtoVt extends Activity {

    RatingBar ratingbar1;
    Button button;
    ImageButton cam;
    String id;
    String id_carr;
    String nom, prueba;
    String rating;
    RequestQueue requestQueue;
    String insertUrl = "http://192.168.0.26/Festum/insertUsuario.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fto_vt);
        addListenerOnButtonClick();


        requestQueue = Volley.newRequestQueue(getApplicationContext());
        infoUsuario();
        cam = (ImageButton)this.findViewById(R.id.imgBtnCam);

        //Añadimos el Listener Boton
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent para llamar a la Camara
                Intent cameraIntent = new Intent(
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                //Creamos una carpeta en la memeria del terminal
                File imagesFolder = new File(
                        Environment.getExternalStorageDirectory(), "FestumCarnaval");
                imagesFolder.mkdirs();
                //añadimos el nombre de la imagen
                 nom = "Carnv" + new Random(999999) + ".jpg";
                File image = new File(imagesFolder, nom );
                Uri uriSavedImage = Uri.fromFile(image);
                //Le decimos al Intent que queremos grabar la imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                //Lanzamos la aplicacion de la camara con retorno (forResult)
                startActivityForResult(cameraIntent, 1);
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Comprovamos que la foto se a realizado
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Creamos un bitmap con la imagen recientemente
            //almacenada en la memoria
            Bitmap bMap = BitmapFactory.decodeFile
                    (
                    Environment.getExternalStorageDirectory() +
                            "/FestumCarnaval/" + nom.toString());
            //Añadimos el bitmap al imageView para
            //mostrarlo por pantalla
            cam.setImageBitmap(bMap);
        }
    }

    public void addListenerOnButtonClick()
    {
        ratingbar1=(RatingBar)findViewById(R.id.ratingBar1);
        button=(Button)findViewById(R.id.button1);
        //Performing action on Button Click
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0)
            {

                builder.setTitle(R.string.votacion);
                builder.setMessage(R.string.te_voto);
                builder.setPositiveButton(R.string.funde, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        votar();
                        Toast.makeText(MainActivityFtoVt.this, R.string.fundido, Toast.LENGTH_LONG).show();
                        salir();
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, null);

                Dialog dialog = builder.create();
                dialog.show();
            }

        });
    }


public void votar()
{
    Bundle bundle=getIntent().getExtras();
    id_carr = bundle.getString("ids");

   rating = String.valueOf(ratingbar1.getRating());


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
            parameters.put("valor", rating.toString());
            parameters.put("id_carrosa",prueba.toString());
            parameters.put("foto", nom.toString());
            parameters.put("id_usu", id.toString());

            return parameters;
        }
    };
    requestQueue.add(request);



}

    public void infoUsuario() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {

                            id = String.valueOf(object.get("id"));
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

    public void salir()
    {
        Intent j = new Intent(this, MainActivity_votacion.class);
        startActivity(j);
    }


}
