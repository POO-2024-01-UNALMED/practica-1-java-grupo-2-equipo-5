package uiMain.gestion.gestionDoctores;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Doctor;

import java.util.Scanner;

public class EliminarDoctor {

    public static void eliminarDoctor(Hospital hospital) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese la cédula del doctor que se ELIMINARA: ");
            int cedula = sc.nextInt();
            Doctor doctor = hospital.buscarDoctor(cedula);
            if (doctor == null) { //verificamos si existe el doctor =)
                System.out.println("No puedo eliminar algo que no existe asi que...");
                while (true) {
                    System.out.println("El doctor no esta registrado.\n¿Desea registrarlo?");
                    System.out.println("1. Si\n2. No \nSeleccione una opción");
                    byte opcion = sc.nextByte();
                    switch (opcion) {
                        case 1:
                            RegistrarDoctor.registrarDoctor(hospital);
                            return;

                        case 2:
                            System.out.println(">:( Adios");
                            return;
                        default:
                            System.out.println("Opción Inválida");
                    }
                }
            }
            hospital.getListaDoctores().remove(doctor);
        }
        System.out.println("¡DOCTOR ASESINADO! digo eliminado");
    }
}