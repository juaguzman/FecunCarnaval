package example.juancarlos.com.fecuncarnaval;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

public class UsuarioPost extends AppCompatActivity
{

    private String nombre;
    private String id;
    private String fecha_nas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
        setContentView(R.layout.activity_familia);



    }


    public  boolean insertar(String nom, String id, String fech)
    {


        HttpClient httpClient;
        List<NameValuePair> nameValuePairs = null;
        HttpPost httpPost;
        httpClient = new DefaultHttpClient();
        httpPost = new HttpPost("http://festum1.comule.com/insertUsuario.php");
        nameValuePairs.add(new BasicNameValuePair("nombre", nombre));
        nameValuePairs.add(new BasicNameValuePair("id",id));
        nameValuePairs.add(new BasicNameValuePair("fecha_nas",fecha_nas));

        try
        {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httpClient.execute(httpPost);
            return true;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  false;
    }

}
