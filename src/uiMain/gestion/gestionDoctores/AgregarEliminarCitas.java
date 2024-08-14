package uiMain.gestion.gestionDoctores;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.servicios.Cita;

import java.util.Scanner;

//fusione eliminar cita
import java.util.ArrayList;
import java.util.Objects;

public class AgregarEliminarCitas {
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
                            System.out.println("Bruh, Adios");
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
    public static void eliminarCitas(Hospital hospital) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese la cédula del doctor al que se le eliminará una cita: ");
        int cedula = sc.nextInt();
        Doctor doctor = hospital.buscarDoctor(cedula);
        if (doctor == null) {  // lo mismo de arriba, vamos a verificar si el doctor ya esta registrado de lo contrario lo registramos
            while (true) {
                System.out.println("El doctor no esta registrado.\n¿Desea registrarlo?");
                System.out.println("1. Si\n2. No \nSeleccione una opción");
                byte opcion = sc.nextByte();
                switch (opcion) {
                    case 1:
                        RegistrarDoctor.registrarDoctor(hospital);
                        return;

                    case 2:
                        System.out.println("BRUH, Bye");
                        return;
                    default:
                        System.out.println("No entendiste verdad? OPCION INVALIDA");
                }
            }
        }
        System.out.println("Seleccione la cita que desea eliminar, (solo se muestran las citas que " +
                "no tienen un paciente asigando: ");

        ArrayList<Cita> agendaDisponible = doctor.mostrarAgendaDisponible();
        for(int i=1; i<=agendaDisponible.size(); i++) {
            System.out.println(i + ". " + agendaDisponible.get(i-1).getFecha());
        }

        System.out.println("Seleccione la cita que desea eliminar: ");
        byte numeroCita = sc.nextByte();

        //Se valida la opción
        while (numeroCita<1 || numeroCita>agendaDisponible.size()){
            System.out.println("OPCION INVALIDA, te equivocate, por favor ingrese otra opción: ");
            numeroCita= sc.nextByte();
        }

        for(int i=1; i<=doctor.getAgendaDoctor().size(); i++) {
            if (Objects.equals(doctor.getAgendaDoctor().get(i - 1).getFecha(), agendaDisponible.get(numeroCita - 1).getFecha())) {
                doctor.getAgendaDoctor().remove(doctor.getAgendaDoctor().get(i-1));
            }
        }
        System.out.println("¡Cita ELIMINADA con exito!");
        System.out.println(doctor);
        System.out.println("Agenda: ");
        for(int i=1; i<=doctor.getAgendaDoctor().size(); i++) {
            System.out.println(i + ". " + doctor.getAgendaDoctor().get(i-1).getFecha());
        }
    }


}
