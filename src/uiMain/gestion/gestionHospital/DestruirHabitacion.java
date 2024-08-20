package uiMain.gestion.gestionHospital;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.servicios.Habitacion;

import java.util.Scanner;

//Clase de Gestion para destruir las habitaciones creadas previamente
public class DestruirHabitacion {

    public static void destruirHabitacion(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, introduzca la información de la habitación que desea destruir");
        System.out.println("Ingrese el número de la habitación: ");
        int nHabitacion = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Qué tipo de habitación desea destruir?");
        System.out.println("'CAMILLA', 'INDIVIDUAL', 'DOBLE', 'OBSERVACION', 'UCI', 'UCC': "); //Igual que en ConstruirHabitacion?
        String categoriaEscogida = sc.next();
        sc.nextLine();
        CategoriaHabitacion hEscogida = CategoriaHabitacion.valueOf(categoriaEscogida);

        for (Habitacion habitacion : hospital.habitaciones) {
            if (habitacion.getNumero() == nHabitacion && habitacion.getCategoria() == hEscogida) {
                if (!habitacion.isOcupada()) {
                    hospital.getListaHabitaciones().remove(habitacion);
                    System.out.println("Se ha destruido la habitación!");
                    return;
                } else {
                    System.out.println("La habitación está en uso y no puede ser destruida en este momento.");
                    return;
                }
            }
        }
        System.out.println("La habitación que intenta destruir no existe.");
    }
}