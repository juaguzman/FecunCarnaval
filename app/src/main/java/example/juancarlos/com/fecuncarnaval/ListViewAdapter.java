package example.juancarlos.com.fecuncarnaval;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by usuario on 12/10/2015.
 */
public class ListViewAdapter extends BaseAdapter
{
    Context context;
    int[] fotos;
    LayoutInflater inflater;

    public ListViewAdapter(Context context,int[] fotos)
    {
        this.context = context;
        this.fotos = fotos;

    }


    @Override
    public int getCount() {
        return fotos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgImg;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row, parent,false);

        imgImg = (ImageView) itemView.findViewById(R.id.imageViewV);

        imgImg.setImageResource(fotos[position]);

        return itemView;
    }
}
