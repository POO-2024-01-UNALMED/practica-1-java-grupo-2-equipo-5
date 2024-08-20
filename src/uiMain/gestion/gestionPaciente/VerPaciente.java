package uiMain.gestion.gestionPaciente;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Enfermedad;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Cita;
import gestorAplicacion.servicios.CitaVacuna;
import gestorAplicacion.servicios.Formula;

import java.util.Scanner;

//Clase de gestion encargada de visualizar el objeto paciente
public class VerPaciente {

    public static void mostrarInformacionPaciente(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese la cédula del paciente: ");
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

        // Mostrar la información del paciente
        System.out.println("\n--- Información del Paciente ---");
        System.out.println(paciente);

        System.out.println("\n--- Historia Clínica ---");

        // Mostrar enfermedades
        System.out.println("Enfermedades:");
        for (Enfermedad enfermedad : paciente.getHistoriaClinica().getEnfermedades()) {
            System.out.println(enfermedad);
        }

        // Mostrar fórmulas
        System.out.println("\nFormulas:");
        for (Formula formula : paciente.getHistoriaClinica().getListaFormulas()) {
            System.out.println(formula);
        }

        // Mostrar citas
        System.out.println("\nCitas:");
        for (Cita cita : paciente.getHistoriaClinica().getHistorialCitas()) {
            System.out.println("Fecha: " + cita.getFecha());
            System.out.println("Doctor: " + cita.getDoctor().getNombre());
        }

        // Mostrar historial de vacunas
        System.out.println("\nHistorial de Vacunas:");
        for (CitaVacuna vacuna : paciente.getHistoriaClinica().getHistorialVacunas()) {
            System.out.println(vacuna.getVacuna().getNombre());
        }
    }
}
