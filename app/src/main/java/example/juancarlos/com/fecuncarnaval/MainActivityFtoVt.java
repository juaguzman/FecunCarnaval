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

import java.io.File;

public class MainActivityFtoVt extends Activity {

    RatingBar ratingbar1;
    Button button;
    ImageButton cam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fto_vt);
        addListenerOnButtonClick();


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
                        Environment.getExternalStorageDirectory(), "Tutorialeshtml5");
                imagesFolder.mkdirs();
                //añadimos el nombre de la imagen
                File image = new File(imagesFolder, "foto.jpg");
                Uri uriSavedImage = Uri.fromFile(image);
                //Le decimos al Intent que queremos grabar la imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                //Lanzamos la aplicacion de la camara con retorno (forResult)
                startActivityForResult(cameraIntent, 1);
            }
        });

    }

    public void votar(View v)
    {


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Comprovamos que la foto se a realizado
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Creamos un bitmap con la imagen recientemente
            //almacenada en la memoria
            Bitmap bMap = BitmapFactory.decodeFile(
                    Environment.getExternalStorageDirectory() +
                            "/Tutorialeshtml5/" + "foto.jpg");
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
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivityFtoVt.this, R.string.fundido, Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, null);

                Dialog dialog = builder.create();
                dialog.show();
            }

        });
    }







}
