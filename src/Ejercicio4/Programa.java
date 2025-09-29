package Ejercicio4;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        //Creacion de objetos
        Auto auto1 = new Auto("Toyota","Corolla", 2019, 4 );
        Auto auto2 = new Auto("Honda","Civic", 2018, 2 );
        Moto moto1 = new Moto("Yamaha","MT-03", 2023, 321);
        Moto moto2 = new Moto("Honda","CBR", 2019, 123);
        ArrayList<Object> vehiculos = new ArrayList<>();
        //Las agregamos en la lista
        vehiculos.add(auto1);
        vehiculos.add(auto2);
        vehiculos.add(moto1);
        vehiculos.add(moto2);

        System.out.println("-- Vehiculos WoW --");
        // Recorremos la lista de vehículos usando un for-each
        for (Object v : vehiculos) {

            // Verificamos si el objeto actual es una instancia de Auto
            if (v instanceof Auto) {
                // Realizamos un casting para acceder a los métodos específicos de Auto
                Auto a = (Auto) v;

                // Mostramos la información del auto usando saltos de línea \n
                System.out.println("Marca: " + a.getMarca() +
                        "\nModelo: " + a.getModelo() +
                        "\nAño: " + a.getAnio() +
                        "\nPuertas: " + a.getNumPuertas() + "\n");

                // Si no es un Auto, verificamos si es una instancia de Moto
            } else if (v instanceof Moto) {
                // Realizamos un casting para acceder a los métodos específicos de Moto
                Moto m = (Moto) v;

                // Mostramos la información de la moto con formato simplificado
                System.out.println("Marca: " + m.getMarca() +
                        "\nModelo: " + m.getModelo() +
                        "\nAño: " + m.getAnio() +
                        "\nCilindraje: " + m.getCilindraje() + " cc\n");
            }
        }


    }
}
