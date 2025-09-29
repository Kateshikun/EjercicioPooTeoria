package Ejercicio2;

public class Rectangulo {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo (double lado){
        this.base = lado;
        this.altura = lado;
    }

    public double calcularArea(){
        return this.base * this.altura;
    }

    public double calcularPerimetro(){
        return 2 * (this.base + this.altura);
    }
}
