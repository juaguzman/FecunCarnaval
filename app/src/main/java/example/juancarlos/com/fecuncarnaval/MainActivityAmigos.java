package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivityAmigos extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgBtnVA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_amigos);
        imgBtnVA = (ImageButton) findViewById(R.id.imageButtonVA);
        imgBtnVA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageButtonVA:
                Intent intent = new Intent(this, MainActivityVotacioes.class);
                startActivity(intent);
        }
    }
}
