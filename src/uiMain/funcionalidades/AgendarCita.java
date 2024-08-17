package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.servicios.Cita;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
//import uiMain.gestion.gestionPacientes.RegistrarPaciente;

public class AgendarCita {
    static Scanner sc = new Scanner(System.in);

    public static void agendarCita(Hospital hospital) {
        //Buscar el paciente con el numero de la cédula
        System.out.println("Por favor, ingrese su número de identificación: ");

        int numeroCedula = sc.nextInt();

        Paciente pacienteCita = hospital.buscarPaciente(numeroCedula);

        //Verificamos si se encontró un paciente que coincida con la cédula
        if (pacienteCita == null) {
            //Si no se encontró, podems registrarlo
            while(true) {
                System.out.println("El paciente no está registrado.\nDesea registrarlo?");
                System.out.println("Por favor elija una opción:\n1. Si\n2. No");
                byte opcion = sc.nextByte();
                switch (opcion) {
                    case 1:
                        //RegistrarPaciente.registrarPaciente(hospital); Terminar
                        return;
                    case 2:
                        System.out.println("Regresando a la opción anterior...");
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
        //Bienvenida:
        System.out.println(pacienteCita.bienvenida());

        //Array de doctores para uso posterior
        ArrayList<Doctor> doctoresDisponibles = new ArrayList<Doctor>();
    }
}
