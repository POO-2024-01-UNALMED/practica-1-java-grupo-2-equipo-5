package uiMain.gestion.gestionVacunas;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;

import java.util.Scanner;

public class EliminarPaciente {
    public static void eliminarPaciente(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        int cedula = sc.nextInt();
        Paciente paciente = hospital.buscarPaciente(cedula);
        if (paciente != null) {
            System.out.println("El Paciente NO EXISTE / Se encuentra ELIMINADO");
        }
        hospital.getListaPacientes().remove(paciente);
        System.out.println("Paciente Eliminado con Exito");
    }
}
