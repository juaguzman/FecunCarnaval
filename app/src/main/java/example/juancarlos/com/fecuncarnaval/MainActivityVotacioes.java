package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

/**
 * Created by usuario on 12/10/2015.
 */
public class MainActivityVotacioes extends Activity
{
    ListView listado;

    int [] fotos =
            {
                    R.drawable.da6,
                    R.drawable.da6,
                    R.drawable.da6,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listado=(ListView) findViewById(R.id.listViewVotaciones);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
