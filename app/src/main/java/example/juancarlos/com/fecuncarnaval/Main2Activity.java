package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = (Button)findViewById(R.id.imageButton2);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(Main2Activity.this,MainActivityFamilia.class);
        startActivity(intent);

    }
}
