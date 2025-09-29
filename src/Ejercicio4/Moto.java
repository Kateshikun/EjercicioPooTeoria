package Ejercicio4;

public class Moto extends Vehiculo{
    private int cilindraje; //Medidos en Centimetros Cubicos

    public Moto(String marca, String modelo, int anio, int cilindraje){
        super (marca, modelo, anio);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
