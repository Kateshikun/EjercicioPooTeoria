package Ejercicio2;

public class Programa {
    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(5.0, 7.9);
        Rectangulo cuadrado = new Rectangulo(10.0);

        System.out.println("-- Programa Geometrico --");
        System.out.println("Rectangulo\n Area:" + rectangulo.calcularArea() + " | Perimetro:" + rectangulo.calcularPerimetro());
        System.out.println("Cuadrado\n Area: " + cuadrado.calcularArea() + " | Perimetro:" + cuadrado.calcularPerimetro());
    }
}
