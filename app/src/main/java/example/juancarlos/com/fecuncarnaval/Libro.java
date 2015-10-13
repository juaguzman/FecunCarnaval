package example.juancarlos.com.fecuncarnaval;

import android.graphics.drawable.Drawable;

/**
 * Created by JUANCARLOS on 13/10/2015.
 */
public class Libro
{

    private int id;
    private Drawable img;

    public  Libro(int Nid,Drawable im)
    {
        this.id = Nid;
        this.img = im;
    }


    public Drawable getImg()
    {
        return img;
    }

    public void setFoto(Drawable foto)
    {
        this.img = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




   public void setImg (Drawable im)
   {
       this.img = im;
   }
}
