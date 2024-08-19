
package uiMain.gestion.gestionDoctores;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Doctor;

import java.util.Scanner;

public class VerDoctor {
    public static void verDoctor(Hospital hospital) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la cédula del doctor: ");
            int cedula = sc.nextInt();
            Doctor doctor = hospital.buscarDoctor(cedula);
            if (doctor == null) { //revisando si existe el man o hay que traerlo a la existencia
                while (true) {
                    System.out.println("El doctor no esta registrado.\n¿Desea registrarlo?");
                    System.out.println("1. Si\n2. No \nSeleccione una opción");
                    byte opcion = sc.nextByte();
                    switch (opcion) {
                        case 1:
                            RegistrarDoctor.registrarDoctor(hospital);
                            return;

                        case 2:
                            System.out.println("Adios");
                            return;
                        default:
                            System.out.println("Opción Inválida");
                    }
                }
            }
            System.out.println("ILUMINATE pues he aqui la informacion que buscabas del erudito en diagnóstico, tratamiento y prevención de enfermedades o condiciones médicas.");
            System.out.println(doctor);
            System.out.println("Esta es su Agenda: ");
            for(int i=1; i<=doctor.getAgendaDoctor().size(); i++) {
                System.out.println(i + ". " + doctor.getAgendaDoctor().get(i-1).getFecha());
            }
        }
    }

