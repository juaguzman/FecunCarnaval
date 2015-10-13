package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainAmActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgBtnA28;
    private ImageButton imgBtnA29;
    private ImageButton imgBtnA30;
    private ImageButton imgBtnA31;
    private ImageButton imgBtnA2;
    private ImageButton imgBtnA3;
    private ImageButton imgBtnA4;
    private ImageButton imgBtnA5;
    private ImageButton imgBtnA6;

    private ImageButton imgbtnVotA;
    private ImageButton imgbtnNA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityd_amigos);

        imgBtnA28 = (ImageButton) findViewById(R.id.imgBtna28);
        imgBtnA28.setOnClickListener(this);
        imgBtnA29 = (ImageButton) findViewById(R.id.imgBtna29);
        imgBtnA29.setOnClickListener(this);
        imgBtnA30 = (ImageButton) findViewById(R.id.imgBtna30);
        imgBtnA30.setOnClickListener(this);
        imgBtnA31 = (ImageButton) findViewById(R.id.imgBtna31);
        imgBtnA31.setOnClickListener(this);
        imgBtnA2 = (ImageButton) findViewById(R.id.imgBtna2);
        imgBtnA2.setOnClickListener(this);
        imgBtnA3 = (ImageButton) findViewById(R.id.imgBtna3);
        imgBtnA3.setOnClickListener(this);
        imgBtnA4 = (ImageButton) findViewById(R.id.imgBtna4);
        imgBtnA4.setOnClickListener(this);
        imgBtnA5 = (ImageButton) findViewById(R.id.imgBtna5);
        imgBtnA5.setOnClickListener(this);
        imgBtnA6 = (ImageButton) findViewById(R.id.imgBtna6);
        imgBtnA6.setOnClickListener(this);

        imgbtnVotA = (ImageButton) findViewById(R.id.imgBtnVot);
        imgbtnVotA.setOnClickListener(this);

        imgbtnNA = (ImageButton) findViewById(R.id.imgBtnN);
        imgbtnNA.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.imgBtna28:

                Intent i = new Intent(this, MainActivityAmigos.class);
                i.putExtra("fecha","2015-12-28");
                startActivity(i);

                break;

            case R.id.imgBtna30:

                Intent j = new Intent(this, MainActivityAmigos.class);
                j.putExtra("fecha", "2015-12-30");
                startActivity(j);
                break;
            case R.id.imgBtna31:

                Intent q = new Intent(this, MainActivityAmigos.class);
                q.putExtra("fecha", "2015-12-31");
                startActivity(q);
                break;
            case R.id.imgBtna2:

                Intent p = new Intent(this, MainActivityAmigos.class);
                p.putExtra("fecha", "2016-01-02");
                startActivity(p);
                break;
            case R.id.imgBtna3:

                Intent o = new Intent(this, MainActivityAmigos.class);
                o.putExtra("fecha", "2016-01-03");
                startActivity(o);
                break;
            case R.id.imgBtna4:

                Intent n = new Intent(this, MainActivityAmigos.class);
                n.putExtra("fecha", "2016-01-04");
                startActivity(n);
                break;
            case R.id.imgBtna5:

                Intent m = new Intent(this, MainActivityAmigos.class);
                m.putExtra("fecha", "2016-01-05");
                startActivity(m);
                break;
            case R.id.imgBtna6:

                Intent l = new Intent(this, MainActivityAmigos.class);
                l.putExtra("fecha", "2016-01-06");
                startActivity(l);
                break;
            case R.id.imgBtna29:

                Intent k = new Intent(this, MainActivityAmigos.class);
                k.putExtra("fecha", "2015-12-29");
                startActivity(k);
                break;

            case R.id.imgBtnN:

                Intent no = new Intent(this, MainActivityNoticias.class);
                startActivity(no);
                break;

            case R.id.imgBtnVot:

                Intent vo = new Intent(this, MainActivity_votacion.class);
                startActivity(vo);
                break;

        }
    }
}
