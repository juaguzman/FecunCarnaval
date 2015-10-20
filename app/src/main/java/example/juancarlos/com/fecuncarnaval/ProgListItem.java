package example.juancarlos.com.fecuncarnaval;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by JUANCARLOS on 19/10/2015.
 */
public class ProgListItem  extends LinearLayout
{
    private TextView lblEvento, lblhora;
    private Programa programa;

    public ProgListItem(Context context, Programa programa)
    {
        super(context);
        this.programa = programa;
        inicializar();
    }

    public void inicializar()
    {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.progitem_list, this, true);

        lblEvento = (TextView) findViewById(R.id.lblEvento);
        lblEvento.setText(programa.getEvento());

        lblhora = (TextView) findViewById(R.id.lblhora);
        lblhora.setText(programa.getHoraIni()+" - "+programa.getHoraFin());
    }
}
