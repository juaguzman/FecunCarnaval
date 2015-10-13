package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.app.DownloadManager;
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

import cz.msebera.android.httpclient.Header;

/**
 * Created by usuario on 12/10/2015.
 */
public class MainActivutyNoticias extends Activity
{
    ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        listado=(ListView) findViewById(R.id.listView2);
        ObtDatos();
    }
    public  void ObtDatos()
    {
        AsyncHttpClient client = new AsyncHttpClient();
        String url ="http://192.168.0.14/Festum/getNoticias.php";

        RequestParams parametros =new RequestParams();
        parametros.put("nombre", 1);

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200)
                {
                    CargarLista(obtDatosJSON(new String(responseBody)));

                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void CargarLista(ArrayList<String> datos)
    {
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adapter);
    }

    public ArrayList<String> obtDatosJSON(String response)
    {
        ArrayList<String> listado = new ArrayList<String>();
        try
        {
            JSONArray jsonArray =new JSONArray(response);
            String texto;
            for (int i=0; i<jsonArray.length(); i++)
            {
                texto=jsonArray.getJSONObject(i).getString("nombre")+ " " +
                        jsonArray.getJSONObject(i).getString("link")+ " " ;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
