package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.StringTokenizer;

import cz.msebera.android.httpclient.Header;

/**
 * Created by usuario on 12/10/2015.
 */
public class MainActivityFamilia extends Activity
{
    ListView listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia);
        listado=(ListView) findViewById(R.id.listView);
        obtDatos();
    }

    public void obtDatos()
    {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://192.168.1.143/mostrarPrograma.php";

        RequestParams parametros = new RequestParams();
        parametros.put("Evento",1);

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    //llamar a la funcion
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
        listado.setAdapter(adapter);
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
                texto=jsonArray.getJSONObject(i).getString("Evento") + " "+
                        jsonArray.getJSONObject(i).getString("Descripcion") + " "+
                        jsonArray.getJSONObject(i).getString("Lugar") + " "+
                        jsonArray.getJSONObject(i).getString("Hora inicio") + " "+
                        jsonArray.getJSONObject(i).getString("Hora Fin") + " ";
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
}
