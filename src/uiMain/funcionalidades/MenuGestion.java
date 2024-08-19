package uiMain.funcionalidades;


import baseDatos.Serializador;
import gestorAplicacion.administracionHospital.Hospital;
import uiMain.gestion.gestionDoctores.GestionDoctor;
import uiMain.gestion.gestionHospital.GestionHospital;
import uiMain.gestion.gestionPaciente.GestionPaciente;
import uiMain.gestion.gestionVacunas.GestionVacunas;

import java.util.Scanner;

public class MenuGestion {

    private static final Scanner sc = new Scanner(System.in);
    public static void menuGestion(Hospital hospital) {
        byte opcion;
        // Menú para gestionar las clases del programa
        do {
            System.out.println("\n─────────   MENU GESTION GENERAL   ─────────");
            System.out.println("1. Gestionar Pacientes");
            System.out.println("2. Gestionar apartado de vacunas");
            System.out.println("3. Gestionar Doctores");
            System.out.println("4. Gestionar Hospital");
            System.out.println("5. --Regresar al menu inicial--");
            System.out.println("6. --Salir--");
            System.out.print("──────────────────────────────");
            System.out.print("\nSeleccione una opción: ");
            opcion = sc.nextByte();
            sc.nextLine();
            switch (opcion) {
                case 1-> GestionPaciente.mostrarMenuGestionPaciente(hospital);
                case 2-> GestionVacunas.menuGestionVacunas(hospital);
                case 3-> GestionDoctor.menuGestionDoctor(hospital);
                case 4-> GestionHospital.menuGestionHospital(hospital);
                case 5->{return;}
                case 6-> {
                    Serializador.serializar(hospital);
                    System.exit(0);
                }
            }
        } while (true);
    }
}
