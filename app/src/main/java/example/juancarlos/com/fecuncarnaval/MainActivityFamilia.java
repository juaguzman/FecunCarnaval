package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
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
public class MainActivityFamilia extends Activity implements View.OnClickListener {

    private ImageButton imageButton;

    private ImageButton imgBtnVot;
    ListView listado;
    String fechass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia);
        imgBtnVot = (ImageButton) findViewById(R.id.imgBtnVot);
        imgBtnVot.setOnClickListener(this);
        listado=(ListView) findViewById(R.id.listView);
        obtDatos();

        imageButton = (ImageButton) findViewById(R.id.imageButtonN);
        imageButton.setOnClickListener(this);
    }

    public void obtDatos()
    {
        Bundle bundle=getIntent().getExtras();
        fechass = bundle.getString("fecha");
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://festum1.comule.com/getProgramad.php?fecha="+fechass;

        RequestParams parametros = new RequestParams();
        parametros.put("fecha",fechass.toString());

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
            case (R.id.imgBtnVot):
                Intent k = new Intent(this, MainActivity_votacion.class);
                startActivity(k);

                break;
        }



    }
}
