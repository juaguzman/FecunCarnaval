package example.juancarlos.com.fecuncarnaval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;

public class MainActivityFtoVt extends AppCompatActivity implements View.OnClickListener {
    private RatingBar ratingBar;
    private ImageButton imgBtnVot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fto_vt);
        imgBtnVot = (ImageButton) findViewById(R.id.imgBtnVot);
        imgBtnVot.setOnClickListener(this);
        addListenerOnRatingBar();

    }
    public void addListenerOnRatingBar()
    {

        ratingBar = (RatingBar) findViewById(R.id.rtgBar);

         ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });
    }

    @Override
    public void onClick(View v)
    {
        String.valueOf(ratingBar.getRating());

    }
}
