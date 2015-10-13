package example.juancarlos.com.fecuncarnaval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityFtoVt extends AppCompatActivity {
    private RatingBar ratingBar;
    private ImageButton imgBtnVot;
    private TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fto_vt);

        addListenerOnRatingBar();
        //addListenerOnButton();

    }

    //private void addListenerOnButton()
    //{
      //  imgBtnVot = (ImageButton) findViewById(R.id.imgBtnVot);
       // imgBtnVot.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {

            //}
       /// });


//    }


    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.rtgBar);
        tView = (TextView) findViewById(R.id.tView);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                tView.setText(String.valueOf(rating));

            }
        });
    }



}
