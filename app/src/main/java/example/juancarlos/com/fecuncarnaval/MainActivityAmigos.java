package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivityAmigos extends AppCompatActivity implements View.OnClickListener {


    ListView listado;
    String fechass;

    private int pos;
    private String id,evento,descripcion,lugar,horaIni,horaFin,categoria,idUsu,fecha;
    RequestQueue requestQueue;

    String insertUrl = "http://festum1.comule.com/insertMiProg.php";

    private ImageButton imgbtnNa;
    private ImageButton imgbtnAa;
    private ImageButton imgbtnCa;

    private ItemListAdapterProg adapter;
    private List<Programa> listprog;

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
        obtDatos();

        registerForContextMenu(listado);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Ver descripcion");
        menu.add("Agregar a mi agenda");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        super.onContextItemSelected(item);

        if (item.getTitle()=="Ver descripcion")
        {
            pos = info.position;
            //prueba(pos);

        }
        else if (item.getTitle()=="Agregar a mi agenda")
        {
            //AgregarEvento(pos);
            Toast.makeText(this, "Evento agregado", Toast.LENGTH_LONG).show();
        }

        return true;
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
                    obbDatosJSON(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    public void obbDatosJSON(String response)
    {
        obtenerIdusu();

        try
        {
            JSONArray jsonArray = new JSONArray(response);

            listprog = new ArrayList<Programa>();
            Programa act;

            for (int i=0; i<jsonArray.length();i++)
            {
                id = jsonArray.getJSONObject(i).getString("id");
                fecha = jsonArray.getJSONObject(i).getString("fecha");
                evento = jsonArray.getJSONObject(i).getString("evento");
                descripcion = jsonArray.getJSONObject(i).getString("descripcion");
                lugar = jsonArray.getJSONObject(i).getString("lugar");
                horaIni = jsonArray.getJSONObject(i).getString("horaInicio");
                horaFin = jsonArray.getJSONObject(i).getString("horaFin");
                categoria = jsonArray.getJSONObject(i).getString("categoria");
                act = new Programa(id,fecha,evento,descripcion,lugar,horaIni,horaFin,categoria,idUsu);
                listprog.add(act);

            }
            adapter = new ItemListAdapterProg(this, listprog);
            listado.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }


    public void obtenerIdusu()
    {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {

                            idUsu = String.valueOf(object.get("id"));


                            // String email = (String) object.get("email");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender, birthday");
        request.setParameters(parameters);
        request.executeAsync();    }

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
