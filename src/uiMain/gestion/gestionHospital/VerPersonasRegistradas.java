package uiMain.gestion.gestionHospital;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;

import java.util.ArrayList;

//Clase de gestion encargada de ver las personas registradas, sean pacientes o doctores.
public class VerPersonasRegistradas {
    public static void verPersonasRegistradas(Hospital hospital) {
        ArrayList<Doctor> listaDoctores = hospital.getListaDoctores();
        ArrayList<Paciente> listaPacientes = hospital.getListaPacientes();

        System.out.println("Doctores: ");
        for (Doctor doctor : listaDoctores) {
            System.out.println(doctor);
        }
        System.out.println("Pacientes: ");
        for (Paciente paciente : listaPacientes) {
            System.out.println(paciente);
        }

    }
}
