package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.servicios.Habitacion;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;

public class AsignarHabitacion {
    static Scanner sc = new Scanner(System.in);

    public static Habitacion disponibilidadHabitacion(ArrayList<Habitacion> habitaciones, Paciente paciente) {
        if (habitaciones != null) {
            int eleccion;
            System.out.println("Las habitacionnes disponibles para la categoría " + paciente.getCategoriaHabitacion() + " son:");
            for (int i = 1; i <= habitaciones.size(); i++) {
                System.out.println(i + ". ID habitación: " + habitaciones.get(i - 1).getNumero());
            }

            System.out.println("Escoja la habitación de su preferencia:");

            eleccion = sc.nextInt();

            //Casos de error:
            while (eleccion < 1 || eleccion > habitaciones.size()) {
                System.out.println("Opción no válida. Intente de nuevo");
                eleccion = sc.nextInt();
            }

            //Quitar la habitacion elegida de la lista de habitaciones disponibles:
            habitaciones.remove(eleccion - 1);

            //Devolvemos la opción elegida:
            return habitaciones.get(eleccion - 1);
        }
        return null;
    }

    public static void asignarHabitacion(Hospital hospital) {
        //Buscar paciente
        System.out.println("Por favor, ingrese el número de identificación del paciente: ");

        int nIdentificacion = sc.nextInt();
        sc.nextLine();

        Paciente paciente = hospital.buscarPaciente(nIdentificacion);

        //El paciente no puede tener una habitación asignada previamente.
        if (paciente != null) {
            if (paciente.getHabitacionAsignada() == null) {
                //Algunos atributos que se usarán
                Habitacion habitacion;
                Habitacion otraHabitacion;
                ArrayList<Habitacion> hDisponibles;
                ArrayList<Habitacion> otraHabitacionDisponibles;

                //Revisión del tipo de EPS del paciente para mostrar habitaciones disponibles
                if (paciente.getTipoEps().equals("Subsidiado")) {
                    int eleccion;

                    do {
                        System.out.println("Seleccione la habitación que necesite. Recuerde que el precio a pagar se determina por el tipo de la habitación.");
                        System.out.println("1. CAMILLA.\n2. OBSERVACION.\n3. UCI");

                        eleccion = sc.nextInt();
                        sc.nextLine();

                        switch (eleccion) {
                            case 1:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.CAMILLA);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles, paciente);
                                break;

                            case 2:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.OBSERVACION);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles, paciente);

                            case 3:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.UCI);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles, paciente);

                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                        }
                    } while (eleccion != 1 && eleccion != 2 && eleccion != 3);
                }
            }
        }
    }
}
