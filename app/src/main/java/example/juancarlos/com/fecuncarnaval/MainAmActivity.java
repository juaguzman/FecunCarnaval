package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainAmActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityd_amigos);

        ImageButton imgBtn28 = (ImageButton) findViewById(R.id.imgBtna28);
        imgBtn28.setOnClickListener(this);
        btnva = (ImageButton)findViewById(R.id.imageButtonVA);
        btnva.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {
     switch (v.getId())
     {
         case (R.id.imgBtna28):
             Intent j = new Intent(this, MainActivityAmigos.class);
             j.putExtra("fecha", "2015-12-30");
             startActivity(j);
             break;
         case R.id.imageButtonVA:
             Intent h = new Intent(this, MainActivityVotacioes.class);
             h.putExtra("fecha", "2015-12-29");
             startActivity(h);
             break;

     }
    }
}
