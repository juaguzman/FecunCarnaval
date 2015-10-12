package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainFamActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgBtn28;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fam);

        imgBtn28 = (ImageButton) findViewById(R.id.imgBtn28);
        imgBtn28.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.imgBtn28:

                Intent i = new Intent(this, MainActivityFamilia.class);
                i.putExtra("fecha","2015-01-28");
                startActivity(i);

                break;
        }
    }
}
