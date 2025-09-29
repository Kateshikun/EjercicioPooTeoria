package Ejercicio1;

public class Estudiante {
    private String nombreCompleto;
    private String carnet;
    private String carrera;
    private double notaPoo;
    private double notaDsp;
    private double notaDaw;

    public Estudiante(String nombreCompleto, String carnet, String carrera, double notaPoo, double notaDsp, double notaDaw) {
        this.nombreCompleto = nombreCompleto;
        this.carnet = carnet;
        this.carrera = carrera;
        this.notaPoo = notaPoo; //Notas del 0-10
        this.notaDsp = notaDsp;
        this.notaDaw = notaDaw;
    }

    //Constructor extra; Solo por si se quiere hacer un objeto que no se les de la notas de un solo.
    public Estudiante(String nombreCompleto, String carnet, String carrera) {
        this.nombreCompleto = nombreCompleto;
        this.carnet = carnet;
        this.carrera = carrera;
    }

    //Metodos adicionales
    public double calcularPromedio(){
        return (this.notaDaw + this.notaDsp + this.notaPoo)/3;
    }

    public String aprobo(){
        return calcularPromedio() >= 6.0 ? "Aprobo :)" : "No Aprobo >:(";
    }

//METODOS GET Y SET
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getNotaPoo() {
        return notaPoo;
    }

    public void setNotaPoo(double notaPoo) {
        this.notaPoo = notaPoo;
    }

    public double getNotaDsp() {
        return notaDsp;
    }

    public void setNotaDsp(double notaDsp) {
        this.notaDsp = notaDsp;
    }

    public double getNotaDaw() {
        return notaDaw;
    }

    public void setNotaDaw(double notaDaw) {
        this.notaDaw = notaDaw;
    }
}
