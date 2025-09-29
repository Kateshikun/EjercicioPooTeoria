package Ejercicio1;

import java.util.ArrayList;

public class Programa {
    public static void main(String[] args) {
        ArrayList <Estudiante> estudiantes = new ArrayList<>(); //Lista para guardar estudiantes
        estudiantes.add(
                new Estudiante("Daniel Adrian Castillo Garcia", "CG250400", "Tecnico en Ing. Computacion",
                        10.0, 8.5, 9.2 ));
        estudiantes.add(
                new Estudiante("Ludy Mauricio Gonzales Pineda", "GP250210","Licenciatura en Idiomas",
                        2.3, 1.9, 8.9)
        );
        estudiantes.add(
                new Estudiante("Ernesto Benjamin Lopez Perez", "LP250876","Ing. Quimica",
                        6.7, 7.4, 5.8)
        );

        System.out.println("-- Estudiantes Registrados --");
        for (var est : estudiantes){
        System.out.printf("Nombre Completo: %s | Carnet: %s | Carrera: %s" +
                "\nNota de Poo: %.2f | Nota de Dsp: %.2f | Nota de Daw: %.2f | Promedio: %.2f \n\033[0;1m%s\033[0m \n\n", //Para ponerlo en negrita (Se ve chivo)
                est.getNombreCompleto(), est.getCarnet(), est.getCarrera(), est.getNotaPoo(), est.getNotaDsp(), est.getNotaDaw(), est.calcularPromedio(), est.aprobo());
        }
    }
}
