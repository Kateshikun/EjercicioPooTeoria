package Ejercicio5;

public class Sala {
    private static int contadorSalas = 1; // contador global para asignar números únicos
    private int numeroSala;               // número único de esta sala
    private int capacidad;
    private int numeroAsientosLibres;

    public Sala() {
        this.numeroSala = contadorSalas++;
    }

    public Sala(int capacidad, int numeroAsientosLibres) {
        this.numeroSala = contadorSalas++;
        this.capacidad = capacidad;
        this.numeroAsientosLibres = this.capacidad;
    }

    // Métodos get
    public int getNumeroSala() {
        return numeroSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getNumeroAsientosLibres() {
        return numeroAsientosLibres;
    }

    // Métodos set
    public void setCapacidad(int capacidad) {
        this.numeroAsientosLibres = this.capacidad;
        this.capacidad = capacidad;
    }

    public void setNumeroAsientosLibres(int numeroAsientosLibres) {
        this.numeroAsientosLibres = numeroAsientosLibres;
    }
}