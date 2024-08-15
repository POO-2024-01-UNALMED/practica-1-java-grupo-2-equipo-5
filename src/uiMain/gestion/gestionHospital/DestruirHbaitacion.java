package uiMain.gestion.gestionHospital;

import java.util.Scanner;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.servicios.Habitacion;

public class DestruirHbaitacion {
    public static void destruirHabitacion(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, introduzca la información de la habitación que desea destruir");
        System.out.println("Ingrese el número de la habitación: ");
        int numero = sc.nextInt();
        System.out.println("¿Qué tipo de habitación desea destruir?");
        System.out.println("nada")
    }
}
