package uiMain;

import gestorAplicacion.administracionHospital.Hospital;  
  //importar baseDatos.Serializador
  //importar uiMain.funcionalidades.MenuFuncionalidades
  //importar uiMain.gestion.MenuGestion

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Hospital hospital = new Hospital(); // Crear instancia de Hospital
        mostrarMenuInicial(hospital);
    }

    private static void mostrarMenuInicial(Hospital hospital) {

        byte opcionSeleccionada;

        while (true) {
            System.out.println("\n--- MENU INICIAL ---");
            System.out.println("1. Servicios para pacientes");
            System.out.println("2. Gestionar registros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcionSeleccionada = sc.nextByte();

            switch (opcionSeleccionada) {
                case 1:
                    // MenuFuncionalidades
                    break;
                case 2:
                    // MenuGestion
                    break;
                case 3:
                    // Serializador
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
