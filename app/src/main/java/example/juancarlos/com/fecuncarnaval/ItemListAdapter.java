package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by JUANCARLOS on 13/10/2015.
 */
public class ItemListAdapter extends BaseAdapter
{

    private Activity activity;
    private List<Libro> listLibros;


    public ItemListAdapter(Activity activity, List<Libro> listLibros)
    {
        this.activity = activity;
        this.listLibros = listLibros;
    }

    public int getCount() {
        return listLibros.size();
    }

    public Object getItem(int position) {
        return listLibros.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ListItem lstItem = new ListItem(activity, listLibros.get(position) );

        return lstItem;
    }

}

