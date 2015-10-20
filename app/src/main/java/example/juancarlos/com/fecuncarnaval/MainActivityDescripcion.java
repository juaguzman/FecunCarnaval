package example.juancarlos.com.fecuncarnaval;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by usuario on 18/10/2015.
 */
public class MainActivityDescripcion extends Activity
{
    TextView txtEventoE;
    TextView txtFechaE;
    TextView txtLugarE;
    TextView txtHoInE;
    TextView txtHoFinE;
    TextView txtDesE;


    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_descripcion);

        txtEventoE = (TextView) findViewById(R.id.txtEventoE);
        txtFechaE = (TextView) findViewById(R.id.txtFechaE);
        txtLugarE = (TextView) findViewById(R.id.txtLugarE);
        txtHoInE = (TextView) findViewById(R.id.txtHoInE);
        txtHoFinE = (TextView) findViewById(R.id.txtFinE);
        txtDesE = (TextView) findViewById(R.id.txtDesE);
    }
    public  void obtDatos()
    {
        Bundle bundle=getIntent().getExtras();
        id = (bundle.getString("id"));
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://festum1.comule.com/getDescripcionId.php?id="+id;

        RequestParams params = new RequestParams();
        params.put("id", id.toString());

        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody)
            {
                if(statusCode ==200)
                {
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
        try
        {
            JSONArray jsonArray = new JSONArray(response);
            String texto;
             for ( int i=0; i<jsonArray.length(); i++)
             {
                 txtEventoE.setText(jsonArray.getJSONObject(i).getString("evento"));
                 txtFechaE.setText(jsonArray.getJSONObject(i).getString("fecha"));
                 txtLugarE.setText(jsonArray.getJSONObject(i).getString("lugar"));
                 txtHoInE.setText(jsonArray.getJSONObject(i).getString("horaIncio"));
                 txtHoFinE.setText(jsonArray.getJSONObject(i).getString("horaFin"));
                 txtDesE.setText(jsonArray.getJSONObject(i).getString("descripcion"));
             }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
