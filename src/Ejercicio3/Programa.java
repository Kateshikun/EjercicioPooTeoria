package Ejercicio3;

import javax.swing.*;
import java.util.ArrayList;

public class Programa {

    // Lista global donde guardaremos los empleados
    private static ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    public static void main(String[] args) {
        listaEmpleados.add(new Empleado(1, "Adrian Castillo", "Gerente", 9999)); //Solo para probar

        // Menú principal
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú Don Bosco\n" +
                            "1. Agregar empleado\n" +
                            "2. Listar empleados\n" +
                            "3. Buscar empleado por ID\n" +
                            "4. Eliminar empleado\n" +
                            "5. Salir\n\n" +
                            "Elige una opción:");

            if (opcion == null) break; // Si el usuario cierra el cuadro, salir

            switch (opcion) {
                case "1":
                    agregarEmpleado();
                    break;
                case "2":
                    listarEmpleados();
                    break;
                case "3":
                    buscarEmpleado();
                    break;
                case "4":
                    eliminarEmpleado();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "⚠️ Opción no válida, intenta de nuevo.");
            }
        }
    }

    // Método para agregar un empleado
    private static void agregarEmpleado() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del empleado:"));

            // Validar que el ID no se repita
            if (existeId(id)) {
                JOptionPane.showMessageDialog(null, "⚠️ El ID ya existe, no se puede repetir.");
                return;
            }

            String nombre = JOptionPane.showInputDialog("Ingresa el nombre del empleado:");
            String puesto = JOptionPane.showInputDialog("Ingresa el puesto del empleado:");
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el salario del empleado:"));

            Empleado nuevoEmpleado = new Empleado(id, nombre, puesto, salario);
            listaEmpleados.add(nuevoEmpleado);

            JOptionPane.showMessageDialog(null, "Empleado agregado con éxito!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "⚠️ Error en los datos ingresados.");
        }
    }

    // Método para listar empleados
    private static void listarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        } else {
            StringBuilder lista = new StringBuilder("Lista de empleados:\n");
            for (Empleado e : listaEmpleados) {
                lista.append("ID: ").append(e.getId())
                        .append(", Nombre: ").append(e.getNombre())
                        .append(", Puesto: ").append(e.getPuesto())
                        .append(", Salario: $").append(e.getSalario())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    // Método para buscar un empleado por ID
    private static void buscarEmpleado() {
        try {
            int idBuscado = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID a buscar:"));
            Empleado encontrado = obtenerEmpleadoPorId(idBuscado);

            if (encontrado != null) {
                JOptionPane.showMessageDialog(null,
                        "Empleado encontrado:\n" +
                                "ID: " + encontrado.getId() +
                                ", Nombre: " + encontrado.getNombre() +
                                ", Puesto: " + encontrado.getPuesto() +
                                ", Salario: $" + encontrado.getSalario());
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "⚠️ ID inválido.");
        }
    }

    // Método para eliminar empleado
    private static void eliminarEmpleado() {
        try {
            int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del empleado a eliminar:"));
            Empleado eliminar = obtenerEmpleadoPorId(idEliminar);

            if (eliminar != null) {
                listaEmpleados.remove(eliminar);
                JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "⚠️ ID inválido.");
        }
    }

    // Método auxiliar: verificar si un ID ya existe
    private static boolean existeId(int id) {
        for (Empleado e : listaEmpleados) {
            if (e.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar: obtener empleado por ID
    private static Empleado obtenerEmpleadoPorId(int id) {
        for (Empleado e : listaEmpleados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
