package uiMain.funcionalidades;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Cita;
import uiMain.gestion.gestionPaciente.RegistrarPaciente;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendarCita {
    static Scanner sc = new Scanner(System.in);

    public static void doctoresEps(ArrayList<Doctor> doctores, Paciente paciente) {
        if (!doctores.isEmpty()) {
            System.out.println("Los doctores disponibles para la EPS " + paciente.getTipoEps() + " son:");

            for (int i =0; i <= doctores.size();i++) {
                System.out.println(i + ". " + doctores.get(i - 1).getNombre());
            }

        }
        else {
            System.out.println("\nLo sentimos! En este momento no hay doctores disponibles para la EPS " + paciente.getTipoEps() + ".\nPuede elegir otra opción si lo desea.");
        }
    }

    public static void agendarCita(Hospital hospital) {
        //Buscar el paciente con el numero de la cédula
        System.out.println("Por favor, ingrese su número de identificación: ");

        int numeroCedula = sc.nextInt();
        sc.nextLine();

        Paciente pacienteCita = hospital.buscarPaciente(numeroCedula);

        //Verificamos si se encontró un paciente que coincida con la cédula
        if (pacienteCita == null) {
            //Si no se encontró, podemos registrarlo
            while(true) {
                System.out.println("El paciente no está registrado.\nDesea registrarlo? ");
                System.out.println("\n1. Si\n2. No");
                byte opcion = sc.nextByte();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        RegistrarPaciente.registrarPaciente(hospital);
                        return;
                    case 2:
                        System.out.println("Regresando al menú principal... ");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo. ");
                }
            }
        }
        //Bienvenida:
        System.out.println(pacienteCita.bienvenida());

        //Array de doctores para uso posterior
        ArrayList<Doctor> doctoresDisponibles = new ArrayList<>();

        //Si no hay doctores por tipo de EPS buscada
        while(doctoresDisponibles.isEmpty()) {
            //Elegir el tipo de cita:
            byte opcion;

            System.out.println("\nPor favor, seleccione el tipo de cita que requiere: ");
            System.out.println("1. General.\n2. Odontología.\n3. Oftanmología.\n4. Regresar al menú");

            opcion = sc.nextByte();
            sc.nextLine();

            //Casos de error:
            while(opcion < 1 || opcion > 4) {
                System.out.println("Opción no válida. Intente de nuevo");
                opcion = sc.nextByte();
                sc.nextLine();
            }

            //Busqueda de doctores según la especialidad elegida y que coincidan con la EPS del paciente
            switch (opcion) {
                case 1:
                    doctoresDisponibles = pacienteCita.buscarDoctorEps("General", hospital);
                    doctoresEps(doctoresDisponibles, pacienteCita);
                    break;

                case 2:
                    doctoresDisponibles = pacienteCita.buscarDoctorEps("Odontología", hospital);
                    doctoresEps(doctoresDisponibles, pacienteCita);
                    break;

                case 3:
                    doctoresDisponibles = pacienteCita.buscarDoctorEps("Oftanmología", hospital);
                    doctoresEps(doctoresDisponibles, pacienteCita);
                    break;

                case 4:
                    return;
            }
        }
        //Agenda del doctor escogido:
        ArrayList<Cita> agendaDoctor = new ArrayList<>();

        //Si el doctor no tiene citas escogidas:
        while (agendaDoctor.isEmpty()) {
            //Elegir doctor lista doctoresDisponibles
            System.out.println("\nPor favor, elija el doctor por el que desea ser atendido: ");

            byte eleccionDoctor;
            eleccionDoctor = sc.nextByte();
            sc.nextLine();

            //Casos de error:
            while (eleccionDoctor < 1 || eleccionDoctor > doctoresDisponibles.size() + 1) {
                System.out.println("Opción no válida. Intente de nuevo.");
                eleccionDoctor = sc.nextByte();
                sc.nextLine();
            }

            if (eleccionDoctor == doctoresDisponibles.size() + 1) {
                return;
            }

            Doctor doctorElegido = doctoresDisponibles.get(eleccionDoctor - 1);
            agendaDoctor = doctorElegido.mostrarAgendaDisponible();

            if (!agendaDoctor.isEmpty()) {
                //Mostrar agenda del Doctor
                System.out.println("\nLas citas disponibles para el/la Doctor(a) " + doctorElegido.getNombre() + " son:");
                for (int i = 0; i <= agendaDoctor.size(); i++) {
                    System.out.println(i + ". " + agendaDoctor.get(i - 1).getFecha());
                }
                //Elegir entre los horarios disponibles
                System.out.println("Por favor, elija el horario de la cita que el paciente quiere tomar: ");

                byte eleccionCita;
                eleccionCita = sc.nextByte();
                sc.nextLine();

                //Casos de error
                while (eleccionCita < 1 || eleccionCita > agendaDoctor.size()) {
                    System.out.println("Opción no válida. Intente de nuevo");
                    eleccionCita = sc.nextByte();
                    sc.nextLine();
                }

                //Actualizar agenda Doctor
                Cita cita = doctorElegido.actualizarAgenda(pacienteCita, eleccionCita, agendaDoctor);

                System.out.println("Se ha asignado su cita!");

                //Historial citas paciente
                pacienteCita.actualizarHistorialCitas(cita);

                System.out.println("Información de su cita:\nFecha: " + cita.getFecha() + "\nDoctor: " + cita.getDoctor().getNombre());

                //Limpiar Arrays
                agendaDoctor.clear();
                doctoresDisponibles.clear();

                //Historial de citas del paciente?

                System.out.println("\n" + pacienteCita.despedida(cita));
                break;
            }
            else {
                System.out.println("Lo sentimos! El doctor elegido no tiene citas disponibles en su agenda. Puede intentar elegir otro Doctor.");
            }
        }
    }
}
