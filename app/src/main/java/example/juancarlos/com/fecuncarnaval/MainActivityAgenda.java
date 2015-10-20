package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by usuario on 13/10/2015.
 */
public class MainActivityAgenda extends Activity implements View.OnClickListener {
    ListView listViewA;
    String id;

    private ImageButton btnNag;
    private ImageButton btnAag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda);

        listViewA =(ListView) findViewById(R.id.listadoAgenda);
        obtDatos();

        btnNag = (ImageButton) findViewById(R.id.btnNag);
        btnNag.setOnClickListener(this);


        btnAag = (ImageButton) findViewById(R.id.btnAag);
        btnAag.setOnClickListener(this);

        registerForContextMenu(listViewA);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Ver descripcion");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        super.onContextItemSelected(item);
        if (item.getTitle()=="Ver descripcion")
        {
            Toast.makeText(this, "hola mundo", Toast.LENGTH_LONG).show();
        }

        return true;
    }

    public void obtDatos()
    {
       Bundle bundle=getIntent().getExtras();
        id = bundle.getString("id");
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://festum1.comule.com/getMiAgenda.php?id=";

        RequestParams params = new RequestParams();
        params.put("id", id.toString());

        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody)
            {
                if (statusCode ==200)
                {
                    CargarLista(obbDatosJSON(new String(responseBody)));


                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public void CargarLista(ArrayList<String> datos)
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        listViewA.setAdapter(adapter);
    }

    public ArrayList<String> obbDatosJSON(String response)
    {
        ArrayList<String> listado =new ArrayList<String>();
        try
        {
            JSONArray jsonArray = new JSONArray(response);
            String texto;

            for (int i=0; i<jsonArray.length();i++)
            {
                texto=jsonArray.getJSONObject(i).getString("evento") + "\n " +
                        jsonArray.getJSONObject(i).getString("horaInicio") + "-"+
                        jsonArray.getJSONObject(i).getString("horaFin") + " ";

                listado.add(texto);

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return listado;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case (R.id.btnAag):
                Intent k = new Intent(this, MainActivity_votacion.class);
                startActivity(k);

                break;
            case (R.id.btnNag):
                Intent kw = new Intent(this, MainActivityNoticias.class);
                startActivity(kw);

                break;
        }


    }
}
