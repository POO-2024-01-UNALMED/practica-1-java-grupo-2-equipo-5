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
        int nHabitacion = sc.nextInt();
        System.out.println("¿Qué tipo de habitación desea destruir?");
        System.out.println("'CAMILLA', 'INDIVIDUAL', 'DOBLE', 'OBSERVACION', 'UCI', 'UCC': "); //Igual que en ConstruirHabitacion?
        String categoriaEscogida = sc.nextLine();
        CategoriaHabitacion hEscogida = CategoriaHabitacion.valueOf(categoriaEscogida);
        for (Habitacion habitacion : Hospital.getListaHabitaciones()) {
            if (habitacion.getNumero() == nHabitacion && habitacion.getCategoria() == hEscogida) {
                if (!habitacion.isOcupada()) {}
            }
        }
    }
}
