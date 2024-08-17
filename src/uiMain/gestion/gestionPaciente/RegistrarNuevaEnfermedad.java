package uiMain.gestion.gestionPaciente;

import gestorAplicacion.administracionHospital.HistoriaClinica;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Enfermedad;
import gestorAplicacion.personas.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarNuevaEnfermedad {

    public static void registrarNuevaEnfermedad(Hospital hospital) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cédula del paciente para registrar nuevas enfermedades: ");
        int cedula = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea pendiente

        Paciente paciente = hospital.buscarPaciente(cedula);
        if (paciente == null) {
            // Si el paciente no está registrado
        	
            while (true) {
                System.out.println("El paciente no está registrado.\n¿Desea registrarlo?");
                System.out.print("1. Sí\n2. No\nSeleccione una opción: ");
                byte opcion = sc.nextByte();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        RegistrarPaciente.registrarPaciente(hospital);
                        return;
                    case 2:
                        System.out.println("Adiós.");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        }

        HistoriaClinica historiaPaciente = paciente.getHistoriaClinica();
        if (historiaPaciente.getEnfermedades() == null || historiaPaciente.getEnfermedades().isEmpty()) {
            System.out.println("El paciente no tiene enfermedades registradas.");
        } else {
            System.out.println("Estas son las enfermedades del paciente:");
            for (int i = 0; i < historiaPaciente.getEnfermedades().size(); i++) {
                System.out.println((i + 1) + ". " + historiaPaciente.getEnfermedades().get(i));
            }
        }

        boolean agregarOtraEnfermedad;
        do {
            ArrayList<Enfermedad> enfermedadesRegistradas = Enfermedad.getEnfermedadesRegistradas();

            while (true) {
                System.out.println("Estas son las enfermedades registradas en el sistema. Por favor, elija una.");
                System.out.println("0. Registrar nueva enfermedad al sistema");
                for (int i = 0; i < enfermedadesRegistradas.size(); i++) {
                    System.out.println((i + 1) + ". " + enfermedadesRegistradas.get(i));
                }

                byte opcionEnfermedad = sc.nextByte();
                sc.nextLine();

                if (opcionEnfermedad == 0) {
                	
                    // Registrar nueva enfermedad
                	
                    System.out.print("Ingrese el nombre de la enfermedad: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la tipología de la enfermedad: ");
                    String tipologia = sc.next();
                    System.out.print("Ingrese la especialidad que trata la enfermedad: ");
                    String especialidad = sc.next();

                    Enfermedad nuevaEnfermedad = new Enfermedad(especialidad, nombre, tipologia);
                    historiaPaciente.getEnfermedades().add(nuevaEnfermedad);
                    System.out.println("¡La enfermedad ha sido agregada con éxito!");
                    break;
                } else if (opcionEnfermedad < 1 || opcionEnfermedad > enfermedadesRegistradas.size()) {
                    System.out.println("Opción inválida.");
                } else {
                    Enfermedad enfermedadSeleccionada = enfermedadesRegistradas.get(opcionEnfermedad - 1);
                    enfermedadSeleccionada.nuevoEnfermo();
                    historiaPaciente.getEnfermedades().add(enfermedadSeleccionada);
                    System.out.println("¡La enfermedad ha sido agregada con éxito!");
                    break;
                }
            }

            while (true) {
                System.out.print("¿Desea agregar otra enfermedad? (s/n): ");
                char respuesta = sc.next().charAt(0);

                if (respuesta == 's' || respuesta == 'n') {
                    agregarOtraEnfermedad = respuesta == 's';
                    break;
                } else {
                    System.out.println("Opción inválida.");
                }
            }
        } while (agregarOtraEnfermedad);

        System.out.println("¡La enfermedad o enfermedades han sido agregadas con éxito!");
    }
}
