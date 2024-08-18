package uiMain.gestion.gestionPaciente;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;

import java.util.Scanner;

public class RegistrarPaciente {

    public static void registrarPaciente (Hospital hospital) {
        Scanner sc = new Scanner(System.in);

        // Solicitar información del paciente
        System.out.println("Por favor, introduzca la información del paciente para su registro.");

        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el número de cédula: ");
        int cedula = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea pendiente

        // Verificar si el paciente ya está registrado
        if (hospital.buscarPaciente(cedula) != null) {
            System.out.println("Este paciente ya está registrado.");
            return;
        }

        System.out.print("Ingrese su tipo de EPS ('Subsidiado', 'Contributivo' o 'Particular'): ");
        String eps = sc.nextLine();

        // Crear nuevo paciente y agregarlo al hospital
        Paciente nuevoPaciente = new Paciente(cedula, nombre, eps);
        hospital.getListaPacientes().add(nuevoPaciente);

        // Confirmar registro exitoso
        System.out.println("\n¡El paciente ha sido registrado con éxito!");
        System.out.println("Recuerde que actualmente la historia clínica del paciente está vacía.");
        System.out.println(nuevoPaciente);
    }
}
