package uiMain.gestion.gestionVacunas;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Vacuna;
import gestorAplicacion.servicios.CitaVacuna;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AgregarEliminarCitaVacuna {

    public static void agregarCitaVacuna(Hospital hospital){

        Scanner sc= new Scanner(System.in);

        System.out.println("Ingrese el nombre de la vacuna: ");
        String nombreVacuna = sc.nextLine();

        if(!RegistrarEliminarVacunas.verificarExistenciaVacuna(nombreVacuna, hospital)){
            System.out.println("Esta vacuna no existe en el inventario del hospital");

        }
        else{

            Vacuna vacuna = hospital.buscarVacuna(nombreVacuna);

            System.out.println("Ingrese la fecha de la cita para la vacunacion: (Ejemplo: 28 de Agosto, 8:00 am)");
            String fechaCita = sc.nextLine();

            vacuna.getAgenda().add(new CitaVacuna(fechaCita, null, null));
            System.out.println("Cita vacuna agregada con exito");

            System.out.println("\nVacuna: "+vacuna.getNombre());
            System.out.println("Agenda: ");
            for(int i=1; i<vacuna.getAgenda().size(); i++){
                System.out.println(i+". "+ vacuna.getAgenda().get(i-1).getFecha());
            }
        }
    }   


    public static void eliminarCitaVacuna(Hospital hospital){
        Scanner sc= new Scanner(System.in);

        System.out.println("Ingrese el nombre de la vacuna a la que se le eliminará su cita");
        String nombreVacuna = sc.nextLine();

        if(!RegistrarEliminarVacunas.verificarExistenciaVacuna(nombreVacuna, hospital)){
            System.out.println("Esta vacuna no existe en el inventario del hospital.");

        }

        else{
            Vacuna vacuna = hospital.buscarVacuna(nombreVacuna);
            System.out.println("A continuación se muestran las citas de esta vacuna que no tiene paciente asignado: ");
            ArrayList<CitaVacuna> agendaDisponible = vacuna.mostrarAgendaDisponible();

            if(agendaDisponible.size()==0){
                System.out.println("No hay citas disponibles para eliminar");
                return;
            
            }

            for(int i=1; i<= agendaDisponible.size(); i++){
                System.out.println(i+". "+ agendaDisponible.get(i-1).getFecha());
            }

            System.out.println("Seleccione la cita que desea eliminar: ");
            byte numeroCita = sc.nextByte();

            while (numeroCita<1 || numeroCita>agendaDisponible.size()) {
                System.out.println("Ingrese un número válido");
                numeroCita = sc.nextByte();
                
            }

            for (int i=1; i<=vacuna.getAgenda().size(); i++){
                if(Objects.equals(vacuna.getAgenda().get(i - 1).getFecha(), agendaDisponible.get(numeroCita - 1).getFecha())){
                    vacuna.getAgenda().remove(vacuna.getAgenda().get(i-1));
                }
            }
            System.out.println("Cita eliminada con éxito");
            System.out.println("\nVacuna "+vacuna.getNombre());
            System.out.println("Agenda: ");

            for (CitaVacuna agenda : vacuna.getAgenda()){
                System.out.println(agenda.getFecha());
            }
        }
    }
}
