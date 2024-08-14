package uiMain.gestion.gestionVacunas;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Vacuna;
import gestorAplicacion.servicios.CitaVacuna;

public class AgregarElinimarCitaVacuna {

    public static void agregarCitaVacuna(Hospital hospital){

        Scanner sc= new Scanner(System.in);

        System.out.println("Ingrese el nombre de la vacuna: ");
        String nombreVacuna = sc.nextLine();

        if(!RegistrarVacuna.verificarExistenciaVacuna(nombreVacuna, hospital)){
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
}
