package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by usuario on 12/10/2015.
 */
public class MainActivityFamilia extends Activity implements View.OnClickListener, OnItemClickListener {

   private ImageButton imgbtnNf;
    private ImageButton imgbtnAf;
    private ImageButton imgbtnCf;
    private int pos;
    private String id,evento,descripcion,lugar,horaIni,horaFin,categoria,idUsu,fecha;
    RequestQueue requestQueue;

    String insertUrl = "http://festum1.comule.com/getProgramad.php?fecha="+fecha;

    private ItemListAdapterProg adapter;
    private List<Programa> listprog;

    ListView listado;
    String fechass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia);
        imgbtnAf = (ImageButton) findViewById(R.id.imgbtnAf);
        imgbtnAf.setOnClickListener(this);


        imgbtnNf = (ImageButton) findViewById(R.id.imgbtnNf);
        imgbtnNf.setOnClickListener(this);
        imgbtnCf = (ImageButton) findViewById(R.id.imgbtnCf);
        imgbtnCf.setOnClickListener(this);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        listado=(ListView) findViewById(R.id.listView);
        listado.setOnItemClickListener(this);
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
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo info =  (AdapterView.AdapterContextMenuInfo) item . getMenuInfo ();

        super.onContextItemSelected(item);
        if (item.getTitle()=="Ver descripcion")
        {
            pos = info.position;
                prueba(pos);

        }
        else if (item.getTitle()=="Agregar a mi agenda")
        {
            AgregarEvento(pos);
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
        parametros.put("fecha", fechass.toString());

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
            case (R.id.imgbtnAf):
                Intent k = new Intent(this, MainActivityAgenda.class);
                k.putExtra("id",String.valueOf(idUsu));
                startActivity(k);

                break;
            case (R.id.imgbtnNf):
                Intent kw = new Intent(this, MainActivityNoticias.class);
                startActivity(kw);

                break;
            case (R.id.imgbtnCf):
                Intent kq = new Intent(this, MainActivity_votacion.class);
                startActivity(kq);

                break;
        }



    }



//Metdo para Obtenr el id del usuario se puede usar en cualuier view

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


    public void AgregarEvento(int pos)
    {
        final Programa prog = (Programa)listado.getItemAtPosition(pos);

        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                System.out.println(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters  = new HashMap<String, String>();
                parameters.put("id_prog", prog.getId().toString());
                parameters.put("fecha", prog.getFecha().toString());
                parameters.put("evento",prog.getEvento().toString());
                parameters.put("descripcion",prog.getDescripcion().toString());
                parameters.put("lugar",prog.getLugar().toString());
                parameters.put("horaInicio",prog.getHoraIni().toString());
                parameters.put("horaFin",prog.getHoraFin().toString());
                parameters.put("categoria",prog.getCategoria().toString());
                parameters.put("usuario_id",idUsu.toString());

                return parameters;
            }
        };
        requestQueue.add(request);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this, "Mantenga presionado para ver las opciones", Toast.LENGTH_LONG).show();

    }

    public void prueba(int pos)
    {
        Programa prog = (Programa)listado.getItemAtPosition(pos);
        String ide = prog.getId();
        Intent ne = new Intent(this, MainActivityDescripcion.class);
        ne.putExtra("id",ide);
        startActivity(ne);
        Toast.makeText(this, "Descripcion", Toast.LENGTH_LONG).show();
    }
}
