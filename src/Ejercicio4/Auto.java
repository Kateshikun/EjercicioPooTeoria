package Ejercicio4;

public class Auto extends Vehiculo{
    private int numPuertas;

    public Auto(String marca, String modelo, int anio, int numPuertas){
        super(marca, modelo, anio);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}
