package uiMain.gestion.gestionHospital;

import java.util.Scanner;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.servicios.Habitacion;
import gestorAplicacion.administracionHospital.CategoriaHabitacion;

public class ConstruirHabitacion {
    public static void construirHabitacion(Hospital hospital) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor introduzca la información de la nueva habitación a construir:");
        System.out.println("Ingrese el número de la habitación:");
        int nHabitacion = sc.nextInt();
        CategoriaHabitacion categoriaHabitacion = null;
        int eleccion;

        do {
            System.out.println("Por favor, elija el tipo de habitación que desea construir");
            System.out.println("1. CAMILLA");
            System.out.println("2. INDIVIDUAL");
            System.out.println("3. DOBLE");
            System.out.println("4. OBSERVACION");
            System.out.println("5. UCI");
            System.out.println("6. UCC");
            System.out.print("Ingrese una opción: ");
            eleccion = sc.nextInt();
            sc.nextLine();
        }
    }
}
