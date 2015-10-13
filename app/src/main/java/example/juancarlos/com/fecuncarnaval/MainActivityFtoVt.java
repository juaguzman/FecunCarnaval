package example.juancarlos.com.fecuncarnaval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

public class MainActivityFtoVt extends AppCompatActivity
{
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_fto_vt);
        addListenerOnRatingBar();

    }
    public void addListenerOnRatingBar()
    {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

         ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });
    }
}
