package uiMain.funcionalidades;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Habitacion;

import java.util.ArrayList;
import java.util.Scanner;

public class AsignarHabitacion {
    static Scanner sc = new Scanner(System.in);

    public static Habitacion disponibilidadHabitacion(ArrayList<Habitacion> habitaciones, Paciente paciente) {
        if (habitaciones != null) {
            int eleccion;
            System.out.println("Las habitacionnes disponibles para la categoría " + paciente.getCategoriaHabitacion() + " son:");
            for (int i = 1; i <= habitaciones.size(); i++) {
                System.out.println(i + ". ID habitación: " + habitaciones.get(i - 1).getNumero());
            }

            System.out.println("Escoja la habitación de su preferencia: ");

            eleccion = sc.nextInt();
            sc.nextLine();

            //Casos de error:
            while (eleccion < 1 || eleccion > habitaciones.size()) {
                System.out.println("Opción no válida. Intente de nuevo ");
                eleccion = sc.nextInt();
                sc.nextLine();
            }

            Habitacion auxiliarHabitaciones = habitaciones.get(eleccion-1);

            //Quitar la habitacion elegida de la lista de habitaciones disponibles:
            habitaciones.remove(eleccion - 1);

            //Devolvemos la opción elegida:
            return auxiliarHabitaciones;
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
                Habitacion habitacion = null;
                Habitacion otraHabitacion;
                ArrayList<Habitacion> hDisponibles;
                ArrayList<Habitacion> otraHabitacionDisponibles;

                //Revisión del tipo de EPS del paciente para mostrar habitaciones disponibles
                if (paciente.getTipoEps().equals("Subsidiado")) {
                    int eleccion;

                    do {
                        System.out.println("Seleccione el tipo de habitación que necesite. Recuerde que el precio a pagar se determina por el tipo de la habitación.");
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
                                break;

                            case 3:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.UCI);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles, paciente);
                                break;

                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                                break;
                        }
                    } while (eleccion != 1 && eleccion != 2 && eleccion != 3);
                } else if (paciente.getTipoEps().equals("Contributivo")) {
                    int eleccion;
                    do {
                        System.out.println("Seleccione el tipo de habitación que necesite. Recuerde que el precio a pagar se determina por el tipo de la habitación.");
                        System.out.println("1. INDIVIDUAL.\n2. DOBLE.\n3. OBSERVACION.\n4. UCI.\n5. UCC.");
                        eleccion = sc.nextInt();
                        sc.nextLine();

                        switch (eleccion) {
                            case 1:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.INDIVIDUAL);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles, paciente);
                                break;

                            case 2:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.DOBLE);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles,paciente);
                                break;

                            case 3:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.OBSERVACION);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles,paciente);
                                break;

                            case 4:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.UCI);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles,paciente);
                                break;

                            case 5:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.UCC);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles,paciente);
                                break;

                            default:
                                System.out.print("Opción no válida. Intente de nuevo.");
                                break;
                        }
                    } while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4 && eleccion != 5);
                } else {
                    int eleccion;

                    do {
                        System.out.println("Seleccione el tipo de habitación que necesite. Recuerde que el precio a pagar se determina por el tipo de la habitación.");
                        System.out.println("1. CAMILLA.\n2. UCI");

                        eleccion = sc.nextInt();
                        sc.nextLine();

                        switch (eleccion) {
                            case 1:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.CAMILLA);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles, paciente);
                                break;

                            case 2:
                                paciente.setCategoriaHabitacion(CategoriaHabitacion.UCI);
                                hDisponibles = Habitacion.BuscarHabitacionDisponible(paciente.getCategoriaHabitacion());
                                habitacion = disponibilidadHabitacion(hDisponibles, paciente);
                                break;

                            default:
                                System.out.println("Opción no válida. Intente de nuevo");
                                break;
                        }
                    } while (eleccion != 1 && eleccion != 2);
                }
                if (habitacion != null) {
                    //La habitación ahora está ocupada:
                    habitacion.setOcupada(true);

                    //Asignar habitación al paciente y viceversa:
                    habitacion.setPaciente(paciente);
                    paciente.setHabitacionAsignada(habitacion);

                    //Dias estimados de uso:
                    System.out.println("¿Cuántos días estima que hará uso de la habitación?");
                    int dias = sc.nextInt();
                    sc.nextLine();
                    paciente.getHabitacionAsignada().setDias(dias);

                    //Información de la habitación asignada:
                    System.out.println("\nSe le ha asignado una habitación! A continuación está la infomación de su reserva: ");
                    System.out.println("Cedula del Paciente: " + paciente.getCedula());
                    System.out.println("Nombre del Paciente: " + paciente.getNombre());
                    System.out.println("Número de ID de la habitación: " + habitacion.getNumero());
                    System.out.println("Categoria de la habitación: " + habitacion.getCategoria());

                } // Si no se pudo seleccionar una habitación:
                else {
                    System.out.println("Lo sentimos! No hay habitaciones disponibles en este momento para la categoría " + paciente.getCategoriaHabitacion());
                    System.out.println("¿Desea elegir una habitación de otra categoría (S/N)?");

                    String eleccion = sc.next();
                    sc.nextLine();

                    switch (eleccion) {
                        case "S":
                            CategoriaHabitacion categoria = Habitacion.BuscarOtraCategoria(paciente.getCategoriaHabitacion());
                            otraHabitacionDisponibles = Habitacion.BuscarHabitacionDisponible(categoria);
                            otraHabitacion = disponibilidadHabitacion(otraHabitacionDisponibles, paciente);

                            if (otraHabitacion != null) {
                                //La habitación ahora está ocupada:
                                otraHabitacion.setOcupada(true);

                                //Asignar habitación al paciente y viceversa:
                                otraHabitacion.setPaciente(paciente);
                                paciente.setHabitacionAsignada(otraHabitacion);

                                //Dias estimados de uso:
                                System.out.println("¿Cuántos días estima que hará uso de la habitación?");
                                int dias = sc.nextInt();
                                sc.nextLine();
                                paciente.getHabitacionAsignada().setDias(dias);

                                //Información de la habitación asignada:
                                System.out.println("\nSe le ha asignado una habitación! A continuación está la infomación de su reserva: ");
                                System.out.println("Cedula del Paciente: " + paciente.getCedula());
                                System.out.println("Nombre del Paciente: " + paciente.getNombre());
                                System.out.println("Número de ID de la habitación: " + otraHabitacion.getNumero());
                                System.out.println("Categoria de la habitación: " + otraHabitacion.getCategoria());
                            } else {
                                System.out.println("Lo sentimos! No hay habitaciones disponibles en este momento para ninguna de las categorías.");
                            }
                    }
                }
            } //Si el paciente ya tenía una habitación reservada
            else {
                System.out.println("El paciente ya tiene una habiatación reservada.");
            }
        } //Si no se encontró un paciente:
        else {
            System.out.println("El paciente con identificación " + nIdentificacion + " no está registrado en el sistema.");
            //Opcion para registrarlo?
        }
    }
}
