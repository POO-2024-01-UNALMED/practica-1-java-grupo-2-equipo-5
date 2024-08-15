package uiMain.gestion.gestionVacunas;

import java.util.Scanner;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Vacuna;

public class VerVacuna {

    public static void verVacuna(Hospital hospital){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la vacuna. ");

        String nombreVacuna = sc.nextLine();

        if (!RegistrarEliminarVacunas.verificarExistenciaVacuna(nombreVacuna, hospital)){
            for(Vacuna vacuna: hospital.getListaVacunas()){
                if(Objects.equales(vacuna.getNombre(), nombreVacuna)){
                    System.out.println("\nNombre de la vacuna: " + vacuna.getNombre());
                    System.out.println("Tipo de vacuna: "+vacuna.getTipo());
                    System.out.println("Eps a la que está disponible; ");
                    for(int i=1; i<=vacuna.getTipoEps().size(); i++){
                        System.out.println(i+". "+vacuna.getTipoEps().get(i-1));
                    }
                    System.out.println("Precio de la vacuna: "+vacuna.getPrecio());
                }
            }
        }
    }

}
