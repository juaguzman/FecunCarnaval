package example.juancarlos.com.fecuncarnaval;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainVotacion extends AppCompatActivity {

    private ListView listView;
    private WebView webView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_votacion);


        this.listView = (ListView) findViewById(R.id.listView);
        this.webView = (WebView) findViewById(R.id.webView);

        List items = new ArrayList();
        items.add(new Item(R.drawable.cr1, "Following",
                "http://www.imdb.com/title/tt0154506/"));
        items.add(new Item(R.drawable.cr2, "Memento",
                "http://www.imdb.com/title/tt0209144/"));
        items.add(new Item(R.drawable.cr3, "Batman Begins",
                "http://www.imdb.com/title/tt0372784/"));
        items.add(new Item(R.drawable.cr4, "The Prestige",
                "http://www.imdb.com/title/tt0482571/"));
        items.add(new Item(R.drawable.cr5, "The Dark Knight",
                "http://www.imdb.com/title/tt0468569/"));
        items.add(new Item(R.drawable.cr6, "Inception",
                "http://www.imdb.com/title/tt1375666/"));


        // Display a indeterminate progress bar on title bar
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        this.setContentView(R.layout.activity_main_votacion);

        final AdapterView[] listView = new AdapterView[1];
        listView[0].setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapter, View view, int position, long arg) {

                // Sets the visibility of the indeterminate progress bar in the
                // title
                setProgressBarIndeterminateVisibility(true);

                // Show progress dialog
                 progressDialog = ProgressDialog.show(MainVotacion.this, "ProgressDialog", "Loading!");

                // Tells JavaScript to open windows automatically.

                webView = (WebView) findViewById(R.id.webView);
                webView.getSettings().setJavaScriptEnabled(true);

                // Sets our custom WebViewClient.
                webView.setWebViewClient(new myWebClient());


                listView[0] = (ListView) findViewById(R.id.listView);
                // Loads the given URL
                Item item = (Item) listView[0].getAdapter().getItem(position);
                webView.loadUrl(item.getUrl());
            }
        });
    }

    private class myWebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Load the given URL on our WebView.
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            // When the page has finished loading, hide progress dialog and
            // progress bar in the title.
            super.onPageFinished(view, url);
            setProgressBarIndeterminateVisibility(false);
            progressDialog.dismiss();

        }
    }
}
