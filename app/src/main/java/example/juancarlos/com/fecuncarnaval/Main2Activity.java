package example.juancarlos.com.fecuncarnaval;




import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.facebook.FacebookSdk;



public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


private ImageButton imgBtnF;
private ImageButton imgBtnA;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgBtnF = (ImageButton) findViewById(R.id.imgBtnF);
        imgBtnF.setOnClickListener(this);

        imgBtnA = (ImageButton) findViewById(R.id.imgBtnA);
        imgBtnA.setOnClickListener(this);


    }



    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case (R.id.imgBtnF):
                Intent i = new Intent(this, MainFamActivity.class);
                startActivity(i);
            break;
            case (R.id.imgBtnA):
                Intent j = new Intent(this, MainAmActivity.class);
                startActivity(j);
            break;

        }
    }


}
