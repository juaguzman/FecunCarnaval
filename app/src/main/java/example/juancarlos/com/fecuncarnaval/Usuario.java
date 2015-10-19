package example.juancarlos.com.fecuncarnaval;

/**
 * Created by JUANCARLOS on 18/10/2015.
 */
public class Usuario
{
    private String nombre;
    private String id;
    private String fechan;

    public Usuario(String Nnombre, String Nid, String Nfecha)
    {
       nombre = Nnombre;
        id = Nfecha;
        fechan = Nfecha;
    }



    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getFechan()
    {
        return fechan;
    }

    public void setFechan(String fechan)
    {
        this.fechan = fechan;
    }
}
