package Ejercicio5;

public class Pelicula {
    private String codigo;
    private String titulo;
    private String genero;
    private int duracion; //Duracion en minutos
    private Sala sala;

    public Pelicula() {
        this.codigo = "...";
        this.titulo = "...";
        this.genero = "...";
        this.duracion = 0;
        setSala(new Sala());
    }


    //Metodos get y set
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {this.duracion = duracion;}

    public Sala getSala() { //Metodos para poder acceder a este objeto
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
