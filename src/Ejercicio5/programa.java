package Ejercicio5;
import java.util.ArrayList;
import java.util.Scanner;

public class programa {
    public static ArrayList<Sala> salas = new ArrayList<Sala>(); /* Listas para guardar los objetos */
    public static ArrayList<Pelicula> peliculas = new ArrayList<>();
    public static ArrayList<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {
        salas.add(new Sala(12, 12));
        salas.add(new Sala(10, 10));
        salas.add(new Sala(15, 15));
        int opcion;
        boolean salir = false;
        do{
            opcion = menu();
            switch (opcion) {
                case 0:
                    System.out.println("Opcion invalida. Digite de nuevo...");
                    break;
                case 1:
                    agregarPeliculaYSala();
                    break;
                case 2:
                    realizarReserva();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                    case 4:
                    mostrarReservas();
                    break;
                    case 5:
                    salir = salir();
                    break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
            }
        } while (!salir);
        System.exit(0);
    }

    //Metodo para presentar el menu de opciones
public static int menu (){
        Scanner sc = new Scanner(System.in);
    System.out.println("Bienvenido al Cine Don Bosco");
    System.out.println("----------------------------------");
    System.out.println("1. Agregar pelicula y sala");
    System.out.println("2. Realizar reserva");
    System.out.println("3. Cancelar reserva");
    System.out.println("4. Mostrar reservas realizadas");
    System.out.println("5. Salir");
    System.out.print("Digite la opcion: ");
    try{
        return sc.nextInt();
    }catch (Exception e){
        return 0;
    }

}

public static boolean salir (){
        Scanner sc = new Scanner(System.in);
    System.out.print("Desea salir del sistema? (S/N): ");
    try{
         if (sc.nextLine().equalsIgnoreCase("s")){
             System.out.println("Gracias por visitarnos!"); return true;}
         else if (sc.nextLine().equalsIgnoreCase("n")){return false;}
         else {throw new Exception();}
    }catch (Exception e){
        System.out.println("Digite una opcion valida");
        return false;
    }

}

public static void agregarPeliculaYSala (){
        Scanner sc = new Scanner(System.in);
    System.out.println("\n-- AGREGAR PELICULA Y SALA --");
    Sala salacreada = new Sala();
    Pelicula peliculacreada = new Pelicula();
    boolean exito = false;
    while (!exito) {
        try {
            System.out.print("\nCodigo de la pelicula: ");
            peliculacreada.setCodigo(sc.nextLine());
            System.out.print("\nTitulo de la pelicula: ");
            peliculacreada.setTitulo(sc.nextLine());
            System.out.print("\nGenero de la pelicula: ");
            peliculacreada.setGenero(sc.nextLine());
            System.out.print("\nDuracion de la pelicula [minutos]: ");
            peliculacreada.setDuracion(sc.nextInt());
            System.out.println("\nSalas disponibles: ");
            for(var s2 : salas){
                System.out.println(s2.getNumeroSala() + ". capacidad: " + s2.getCapacidad()); //No se verifica si ya se selecciono la sala, porque, en una sala pueden haber varias peliculas (depende la hora)
            }
            System.out.print("\nEn que sala desea que este la pelicula? #");
            int sala = sc.nextInt();
            for(var s : salas){
                if(s.getNumeroSala() == sala){
                    peliculacreada.setSala(s);
                    break;
                }

            }
            peliculas.add(peliculacreada);
            System.out.println("Pelicula agregada correctamente...");
            exito = true;
        } catch (Exception e) {
            System.out.println("Ingrese valores adecuados...");
        }
    }
}

    public static void realizarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-- REALIZAR RESERVA --");
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();

        if (peliculas.isEmpty()) {
            System.out.println("No hay películas disponibles.");
            return;
        }

        System.out.println("\nPelículas disponibles:");
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula p = peliculas.get(i);
            System.out.println(i + ". " + p.getTitulo() + " (Sala " + p.getSala().getNumeroSala() + ", Asientos libres: " + p.getSala().getNumeroAsientosLibres() + ")");
        }

        System.out.print("Seleccione el número de la película: ");
        int indice = sc.nextInt();
        if (indice < 0 || indice >= peliculas.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Pelicula seleccionada = peliculas.get(indice);
        Sala sala = seleccionada.getSala();

        System.out.print("Número de asientos a reservar: ");
        int cantidad = sc.nextInt();

        if (cantidad <= sala.getNumeroAsientosLibres()) {
            sala.setNumeroAsientosLibres(sala.getNumeroAsientosLibres() - cantidad);
            Reserva r = new Reserva();
            r.setNombre(nombre);
            r.setPelicula(seleccionada.getTitulo());
            r.setNumeroAsientos(cantidad);
            reservas.add(r);
            System.out.println("Reserva realizada con éxito.");
        } else {
            System.out.println("No hay suficientes asientos disponibles.");
        }
    }


    public static void cancelarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-- CANCELAR RESERVA --");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();

        boolean encontrada = false;
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                for (Pelicula p : peliculas) {
                    if (p.getTitulo().equalsIgnoreCase(r.getPelicula())) {
                        p.getSala().setNumeroAsientosLibres(p.getSala().getNumeroAsientosLibres() + r.getNumeroAsientos());
                        break;
                    }
                }
                reservas.remove(i);
                System.out.println("Reserva cancelada exitosamente.");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontró una reserva con ese nombre.");
        }
    }

    public static void mostrarReservas() {
        System.out.println("\n-- RESERVAS REALIZADAS --");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            for (Reserva r : reservas) {
                System.out.println("Cliente: " + r.getNombre() + " | Película: " + r.getPelicula() + " | Asientos: " + r.getNumeroAsientos());
            }
        }
    }


}