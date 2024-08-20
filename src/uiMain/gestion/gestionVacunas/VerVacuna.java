package uiMain.gestion.gestionVacunas;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Vacuna;

import java.util.Objects;
import java.util.Scanner;

//Clase de Gestion encargada de ver las vacunas disponibles del hospital
public class VerVacuna {

    public static void verVacuna(Hospital hospital) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la vacuna. ");

        String nombreVacuna = sc.nextLine();

        if (!RegistrarEliminarVacunas.verificarExistenciaVacuna(nombreVacuna, hospital)) {
            System.out.println("Esta vacuna no existe en el inventario del hospital");
        } else {
            for (Vacuna vacuna : hospital.getListaVacunas()) {
                if (Objects.equals(vacuna.getNombre(), nombreVacuna)) {
                    System.out.println("\nNombre: " + vacuna.getNombre());
                    System.out.println("Tipo: " + vacuna.getTipo());
                    System.out.println("Eps a la que está disponible: ");
                    for (int i = 1; i <= vacuna.getTipoEps().size(); i++) {
                        System.out.println(i + ". " + vacuna.getTipoEps().get(i - 1));
                    }
                    System.out.println("Precio: " + vacuna.getPrecio());
                }
            }
        }
    }
}
