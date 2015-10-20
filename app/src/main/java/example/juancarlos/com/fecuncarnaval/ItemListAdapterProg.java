package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by JUANCARLOS on 19/10/2015.
 */
public class ItemListAdapterProg extends BaseAdapter
{
    private Activity activity;
    private List<Programa> listProg;

    public ItemListAdapterProg(Activity activity, List<Programa> listProg)
    {
        this.activity = activity;
        this.listProg = listProg;
    }

    @Override
    public int getCount() { return listProg.size();
    }

    @Override
    public Object getItem(int position) { return listProg.get(position);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ProgListItem progListItem = new ProgListItem(activity, listProg.get(position));

        return progListItem;
    }
}
