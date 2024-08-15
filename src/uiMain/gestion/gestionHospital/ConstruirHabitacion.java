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
            System.out.print("Escoja una de las opciones: ");
            eleccion = sc.nextInt();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    categoriaHabitacion = categoriaHabitacion.CAMILLA;
                    break;
                case 2:
                    categoriaHabitacion = categoriaHabitacion.INDIVIDUAL;
                    break;
                case 3:
                    categoriaHabitacion = categoriaHabitacion.DOBLE;
                    break;
                case 4:
                    categoriaHabitacion = categoriaHabitacion.OBSERVACION;
                    break;
                case 5:
                    categoriaHabitacion = categoriaHabitacion.UCI;
                    break;
                case 6:
                    categoriaHabitacion = categoriaHabitacion.UCC;
                    break;
            }
        } while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 4 && eleccion != 5 && eleccion != 6);
        boolean habitacionOcupada = false;
        int dias = 0;

        for (Habitacion habitacion : Hospital.getListaHabitaciones()) {
            if (habitacion.getNumero() == nHabitacion && habitacion.getCategoria() == categoriaHabitacion) {
                System.out.println("La habitación que está intentando constuir ya existe");
                return;
            }
        }
        Habitacion nuevaHabitacion = new Habitacion(nHabitacion, categoriaHabitacion, habitacionOcupada, null, dias);
        System.out.println("Se construyó la nueva habitacion!");
        hospital.getListaHabitaciones().add(nuevaHabitacion);
        System.out.println("-Número de ID de la habitación: " + nuevaHabitacion.getNumero() + " " + "-Categoria de la habitación: " + nuevaHabitacion.getCategoria());
    }
}
