package example.juancarlos.com.fecuncarnaval;




import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import com.facebook.FacebookSdk;



public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


private ImageButton imgBtn2;
private ImageButton imgBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgBtn2 = (ImageButton) findViewById(R.id.imgBtn2);
        imgBtn2.setOnClickListener(this);

        imgBtn1 = (ImageButton) findViewById(R.id.imgBtn1);
        imgBtn1.setOnClickListener(this);


    }



    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case (R.id.imgBtn2):
                Intent i = new Intent(this, MainFamActivity.class);
                startActivity(i);
            break;
            case (R.id.imgBtn1):
                Intent j = new Intent(this, MainActivitydAmigos.class);
                startActivity(j);
            break;

        }
    }


}
