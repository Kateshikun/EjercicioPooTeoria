package Ejercicio3;

public class Empleado {
    private int Id;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(int Id, String nombre, String puesto, double salario){
        this.setId(Id);
        this.setNombre(nombre);
        this.setPuesto(puesto);
        this.setSalario(salario);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
