package example.juancarlos.com.fecuncarnaval;

/**
 * Created by JUANCARLOS on 19/10/2015.
 */
public class Programa
{
    private String id;
    private String evento;
    private String descripcion;
    private String lugar;
    private String horaIni;
    private String horaFin;
    private String categoria;
    private String idUsu;
    private String fecha;

    public Programa(String Nid, String Nfecha, String Nevento, String Ndescripcion, String Nlugar, String NhoraIni,
                    String NhoraFin, String Ncategoria, String NidUsu)
    {
        setId(Nid);
        setEvento(Nevento);
        setDescripcion(Ndescripcion);
        setLugar(Nlugar);
        setHoraIni(NhoraIni);
        setHoraFin(NhoraFin);
        setCategoria(Ncategoria);
        setIdUsu(NidUsu);
        setFecha(Nfecha);

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(String idUsu) {
        this.idUsu = idUsu;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
