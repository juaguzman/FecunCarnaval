package example.juancarlos.com.fecuncarnaval;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

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

        libro = new Libro(2,getResources().getDrawable(R.drawable.cr2));
        listLibros.add(libro);

        libro = new Libro(3,getResources().getDrawable(R.drawable.cr3));
        listLibros.add(libro);

        libro = new Libro(4,getResources().getDrawable(R.drawable.cr4));
        listLibros.add(libro);

        libro = new Libro(5,getResources().getDrawable(R.drawable.cr5));
        listLibros.add(libro);

        libro = new Libro(6,getResources().getDrawable(R.drawable.cr6));
        listLibros.add(libro);


//Ahora rellenamos el ListView
        adapter = new ItemListAdapter(this, listLibros);
        list.setAdapter(adapter);
//Posteriormente podemos añadir más items a nuestro listview de la siguiente forma

//primero añadimos más objetos a nuestra lista
      //  libro = new Libro(2,getResources().getDrawable(R.drawable.cr2));
        //listLibros.add(libro);



//y luego le decimos a nuestro adapter que notifique los cambios correspondientes y que actualice los items del ListView
        adapter.notifyDataSetChanged();

    }

    public void votar()
    {
        switch (ids)
        {
            case 1:

            Intent a = new Intent(this, MainActivityFtoVt.class);
            a.putExtra("id", ids);
            startActivity(a);
            break;

            case 2:

                Intent b = new Intent(this, MainActivityFtoVt.class);
                b.putExtra("id", ids);
                startActivity(b);
                break;
            case 3:

                Intent c = new Intent(this, MainActivityFtoVt.class);
                c.putExtra("id", ids);
                startActivity(c);
                break;

            case 4:

                Intent d = new Intent(this, MainActivityFtoVt.class);
                d.putExtra("id", ids);
                startActivity(d);
                break;
            case 5:

                Intent e = new Intent(this, MainActivityFtoVt.class);
                e.putExtra("id", ids);
                startActivity(e);
                break;
            case 6:

                Intent f = new Intent(this, MainActivityFtoVt.class);
                f.putExtra("id", ids);
                startActivity(f);
                break;
        }
    }


}

