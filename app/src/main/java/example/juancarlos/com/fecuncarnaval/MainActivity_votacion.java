package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_votacion extends AppCompatActivity {

    private ListView list;
    private ItemListAdapter adapter;
    private List<Libro> listLibros;
    private int ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_votacion);

        list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Libro entry = (Libro) parent.getItemAtPosition(position);
                ids = entry.getId();
                votar();
            }
        });
        listLibros = new ArrayList<Libro>();
        Libro libro;
//Aqui rellenamos solo con un libro, pero se puede descargar una lista de internet o leyendo de base de datos por ejemplo.
        libro = new Libro(1,getResources().getDrawable(R.drawable.cr1));
        listLibros.add(libro);

//Ahora rellenamos el ListView
        adapter = new ItemListAdapter(this, listLibros);
        list.setAdapter(adapter);
//Posteriormente podemos añadir más items a nuestro listview de la siguiente forma

//primero añadimos más objetos a nuestra lista
        libro = new Libro(2,getResources().getDrawable(R.drawable.cr1));
        listLibros.add(libro);

//y luego le decimos a nuestro adapter que notifique los cambios correspondientes y que actualice los items del ListView
        adapter.notifyDataSetChanged();

    }

    public void votar()
    {
        switch (ids)
        {
            case 1:

            Intent a = new Intent(this, MainActivity.class);
            a.putExtra("id", ids);
            startActivity(a);
            break;
        }
    }


}

