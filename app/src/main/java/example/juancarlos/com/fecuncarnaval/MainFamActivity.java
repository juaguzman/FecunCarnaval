package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainFamActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton
            imgBtn28;
    private ImageButton imgBtn29;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fam);

        imgBtn28 = (ImageButton) findViewById(R.id.imgBtn28);
        imgBtn28.setOnClickListener(this);
        imgBtn29 = (ImageButton) findViewById(R.id.imgBtn29);
        imgBtn29.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.imgBtn28:

                Intent i = new Intent(this, MainActivityFamilia.class);
                i.putExtra("fecha","2015-12-28");
                startActivity(i);

                break;

            case R.id.imgBtn30:

                Intent j = new Intent(this, MainActivityFamilia.class);
                j.putExtra("fecha", "2015-12-30");
                startActivity(j);
                break;
            case R.id.imgBtn31:

                Intent q = new Intent(this, MainActivityFamilia.class);
                q.putExtra("fecha", "2015-12-31");
                startActivity(q);
                break;
            case R.id.imgBtn2:

                Intent p = new Intent(this, MainActivityFamilia.class);
                p.putExtra("fecha", "201-01-02");
                startActivity(p);
                break;
            case R.id.imgBtn3:

                Intent o = new Intent(this, MainActivityFamilia.class);
                o.putExtra("fecha", "2016-01-03");
                startActivity(o);
                break;
            case R.id.imgBtn4:

                Intent n = new Intent(this, MainActivityFamilia.class);
                n.putExtra("fecha", "2016-01-04");
                startActivity(n);
                break;
            case R.id.imgBtn5:

                Intent m = new Intent(this, MainActivityFamilia.class);
                m.putExtra("fecha", "2016-01-05");
                startActivity(m);
                break;
            case R.id.imgBtn6:

                Intent l = new Intent(this, MainActivityFamilia.class);
                l.putExtra("fecha", "2016-01-06");
                startActivity(l);
                break;
            case R.id.imgBtn29:

                Intent k = new Intent(this, MainActivityFamilia.class);
                k.putExtra("fecha", "2015-12-29");
                startActivity(k);
                break;
        }
    }
}
