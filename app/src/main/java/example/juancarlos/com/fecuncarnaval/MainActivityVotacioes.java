package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by usuario on 12/10/2015.
 */
public class MainActivityVotacioes extends Activity
{
    ListView listado;

    int [] fotos =
            {
                    R.drawable.cr1,
                    R.drawable.cr2,
                    R.drawable.cr3,
                    R.drawable.cr4,
                    R.drawable.cr5,
                    R.drawable.cr6,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listado=(ListView) findViewById(R.id.listViewVotaciones);
        Adapter adapter = new ListViewAdapter(this, fotos);

        listado.setAdapter((ListAdapter) adapter);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "position" + position, Toast.LENGTH_SHORT).show();
            }
        });

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
