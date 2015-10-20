package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by usuario on 13/10/2015.
 */
public class MainActivityNoticias extends Activity implements View.OnClickListener {
    ImageButton imgN1;
    ImageButton imgN2;
    ImageButton imgN3;
    ImageButton imgN4;
    ImageButton imgN5;

    private String link1 = "https://www.youtube.com/watch?v=_62U3qpClLU" ;
    Intent intent1 = null;

    private String link2 = "https://www.facebook.com/parquesoftpasto/videos/10153714768101388/?__mref=message_bubble" ;
    Intent intent2 = null;

    private String link3 = "http://www.carnavaldepasto.org/?q=descargas" ;
    Intent intent3 = null;

    private String link5 = "https://www.facebook.com/carnavaldenegrosyblancospasto/posts/1201523903207599?__mref=message_bubble" ;
    Intent intent5 = null;

    private String link4 = "http://www.carnavaldepasto.org/?q=descargas " ;
    Intent intent4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        imgN1 = (ImageButton)findViewById(R.id.imgN1);
        imgN1.setOnClickListener(this);

        imgN2 = (ImageButton)findViewById(R.id.imgN2);
        imgN2.setOnClickListener(this);

        imgN3 = (ImageButton)findViewById(R.id.imgN3);
        imgN3.setOnClickListener(this);

        imgN4 = (ImageButton)findViewById(R.id.imgN4);
        imgN4.setOnClickListener(this);

        imgN5 = (ImageButton)findViewById(R.id.imgN5);
        imgN5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case (R.id.imgN1):
                intent1 = new Intent(intent1.ACTION_VIEW, Uri.parse(link1));
                startActivity(intent1);
            break;
            case (R.id.imgN2):
                intent2 = new Intent(intent1.ACTION_VIEW, Uri.parse(link2));
                startActivity(intent2);
                break;
            case (R.id.imgN3):
                intent3 = new Intent(intent1.ACTION_VIEW, Uri.parse(link3));
                startActivity(intent3);
                break;

            case (R.id.imgN5):
                intent5 = new Intent(intent1.ACTION_VIEW, Uri.parse(link5));
                startActivity(intent5);
                break;

            case (R.id.imgN4):
                intent4 = new Intent(intent1.ACTION_VIEW, Uri.parse(link4));
                startActivity(intent4);
                break;

        }

    }
}
