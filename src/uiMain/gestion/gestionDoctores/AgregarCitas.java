package uiMain.gestion.gestionDoctores;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.servicios.Cita;

import java.util.Scanner;

public class AgregarCitas {
    public static void agregarCitas(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cédula del doctor: ");
        int cedula = sc.nextInt();
        sc.nextLine();
        Doctor doctor = hospital.buscarDoctor(cedula);
        if (doctor == null) { //vamos a verificar si el doctor ya esta registrado de lo contrario lo registramos
                while (true) {
                    System.out.println("El doctor no esta registrado.\n¿Desea registrarlo?");
                    System.out.println("1. Si\n2. No \nElije sabiamente");
                    byte opcion = sc.nextByte();
                    sc.nextLine();
                    switch (opcion) {
                        case 1:
                            RegistrarDoctor.registrarDoctor(hospital);
                            //??????????????????
                            return;
    
                        case 2:
                            System.out.println("Adios");
                            return;
                        default:
                            System.out.println("Opción Inválida");
                    }
                }
            }
        System.out.println("Ingrese la fecha de la cita: ");
        String fecha = sc.nextLine();
        doctor.getAgendaDoctor().add(new Cita(doctor, fecha, null));
        System.out.println("Listo! La cita ya ha sido agregada a la agenda del doctor correctamente!");
        System.out.println(doctor);
        System.out.println("Agenda: ");
        for(int i=1; i<=doctor.getAgendaDoctor().size(); i++) {
            System.out.println(i + ". " + doctor.getAgendaDoctor().get(i-1).getFecha());
        }

    }


}
