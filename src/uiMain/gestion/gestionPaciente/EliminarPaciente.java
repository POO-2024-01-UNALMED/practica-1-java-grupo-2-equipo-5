package uiMain.gestion.gestionPaciente;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;

import java.util.Scanner;

public class EliminarPaciente {
    public static void eliminarPaciente(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cedula del paciente a eliminar");
        int cedula = sc.nextInt();
        Paciente paciente = hospital.buscarPaciente(cedula);
        if (paciente != null) {
            System.out.println("El Paciente NO EXISTE / Se encuentra ELIMINADO");
        }
        hospital.getListaPacientes().remove(paciente);
        System.out.println("Paciente Eliminado con Exito");
    }
}