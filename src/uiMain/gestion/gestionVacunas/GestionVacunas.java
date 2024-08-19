package uiMain.gestion.gestionVacunas;

import baseDatos.Serializador;
import gestorAplicacion.administracionHospital.Hospital;

import java.util.Scanner;

public class GestionVacunas {

    static Scanner sc = new Scanner(System.in);
    public static void menuGestionVacunas(Hospital hospital){
        byte opcion;
        do{
            System.out.println("───────── MENU DE GESTION DE VACUNAS ─────────");
            System.out.println("1. Registrar Vacuna");
            System.out.println("2. Eliminar Vacuna");
            System.out.println("3. Agregar cita de una vacuna");
            System.out.println("4. Eliminar cita de una vacuna");
            System.out.println("5. Ver informacion de una vacuna");
            System.out.println("6. Regresar al menu anterior");
            System.out.println("7. Salir");
            System.out.print("──────────────────────────────");
            System.out.print("\nSeleccione una opción: ");
            opcion = sc.nextByte();
            sc.nextLine();
            switch(opcion){
                case 1 -> RegistrarEliminarVacunas.registrarVacuna(hospital);
                case 2 -> RegistrarEliminarVacunas.eliminarVacuna(hospital);
                case 3 -> AgregarEliminarCitaVacuna.agregarCitaVacuna(hospital);
                case 4 -> AgregarEliminarCitaVacuna.eliminarCitaVacuna(hospital);
                case 5 -> VerVacuna.verVacuna(hospital);
                case 6 -> {
                    return;
                }
                case 7 -> {
                    Serializador.serializar(hospital);
                    System.exit(0);
                }

            }

        }while (true);
    }
}
