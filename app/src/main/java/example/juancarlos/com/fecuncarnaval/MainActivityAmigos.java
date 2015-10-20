package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivityAmigos extends AppCompatActivity implements View.OnClickListener {


    ListView listado;
    String fechass;
    private int pos;
    private String id,evento,descripcion,lugar,horaIni,horaFin,categoria,idUsu,fecha;
    RequestQueue requestQueue;

    private ImageButton imgbtnNa;
    private ImageButton imgbtnAa;
    private ImageButton imgbtnCa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_amigos);

        listado=(ListView) findViewById(R.id.lstVwA);
        obtDatos();

        imgbtnAa = (ImageButton) findViewById(R.id.imgbtnAa);
        imgbtnAa.setOnClickListener(this);

        imgbtnNa = (ImageButton) findViewById(R.id.imgbtnNa);
        imgbtnNa.setOnClickListener(this);
        imgbtnCa = (ImageButton) findViewById(R.id.imgbtnCa);
        imgbtnCa.setOnClickListener(this);

    }

    public void obtDatos()
    {
        Bundle bundle=getIntent().getExtras();
        fechass = bundle.getString("fecha");
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://festum1.comule.com/getProgramad.php?fecha="+fechass;

        RequestParams parametros = new RequestParams();
        parametros.put("fecha",fechass);


        client.post(url, parametros, new AsyncHttpResponseHandler()
        {
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
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case (R.id.imgbtnAa):
                Intent k = new Intent(this, MainActivityAgenda.class);
                startActivity(k);

                break;
            case (R.id.imgbtnNa):
                Intent kw = new Intent(this, MainActivityNoticias.class);
                startActivity(kw);

                break;
            case (R.id.imgbtnCa):
                Intent kq = new Intent(this, MainActivity_votacion.class);
                startActivity(kq);

                break;
        }

    }
}
