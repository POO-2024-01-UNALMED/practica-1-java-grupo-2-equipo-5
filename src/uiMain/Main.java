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
            System.out.println("888    888  .d88888b.   .d8888b.  8888888b. 8888888 88888888888     d8888 888                  d8888 888b    888 8888888b. 8888888 888b    888  .d88888b.  \n" +
                    "888    888 d88P\" \"Y88b d88P  Y88b 888   Y88b  888       888        d88888 888                 d88888 8888b   888 888  \"Y88b  888   8888b   888 d88P\" \"Y88b \n" +
                    "888    888 888     888 Y88b.      888    888  888       888       d88P888 888                d88P888 88888b  888 888    888  888   88888b  888 888     888 \n" +
                    "8888888888 888     888  \"Y888b.   888   d88P  888       888      d88P 888 888               d88P 888 888Y88b 888 888    888  888   888Y88b 888 888     888 \n" +
                    "888    888 888     888     \"Y88b. 8888888P\"   888       888     d88P  888 888              d88P  888 888 Y88b888 888    888  888   888 Y88b888 888     888 \n" +
                    "888    888 888     888       \"888 888         888       888    d88P   888 888             d88P   888 888  Y88888 888    888  888   888  Y88888 888     888 \n" +
                    "888    888 Y88b. .d88P Y88b  d88P 888         888       888   d8888888888 888            d8888888888 888   Y8888 888  .d88P  888   888   Y8888 Y88b. .d88P \n" +
                    "888    888  \"Y88888P\"   \"Y8888P\"  888       8888888     888  d88P     888 88888888      d88P     888 888    Y888 8888888P\" 8888888 888    Y888  \"Y88888P\"");
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
