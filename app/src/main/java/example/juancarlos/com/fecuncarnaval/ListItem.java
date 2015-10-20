package example.juancarlos.com.fecuncarnaval;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by JUANCARLOS on 13/10/2015.
 */
public class ListItem extends LinearLayout {

    private TextView lblTitulo, lblDescripcion;
    private ImageView img;
    private Libro libro;

    public ListItem(Context context, Libro libro) {
        super(context);
        this.libro = libro;
        inicializar();
    }

    private void inicializar(){
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.item_list, this, true);


       img = (ImageView) findViewById(R.id.imgVi);
        img.setImageDrawable(libro.getImg());
    }
}