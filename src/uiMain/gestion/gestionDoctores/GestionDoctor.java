package uiMain.gestion.gestionDoctores;

import baseDatos.Serializador;
//base de datos necesitada
import gestorAplicacion.administracionHospital.Hospital;

import java.util.Scanner;

public class GestionDoctor {
    private static final Scanner sc = new Scanner(System.in);

    public static void menuGestionDoctor(Hospital hospital) {
        byte opcion;
        do {
            // Menu para gestionar la clase Doctor
            System.out.println("\nMENU Gestion Doctor");
            System.out.println("1. Registrar doctor");
            System.out.println("2. Eliminar doctor");
            System.out.println("3. Ver doctor");
            System.out.println("4. Agregar citas");
            System.out.println("5. Eliminar citas");
            System.out.println("6. --Regresar al menu anterior--");
            System.out.println("7. --Salir--");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextByte();
            sc.nextLine();
            switch (opcion) {
                case 1-> RegistrarDoctor.registrarDoctor(hospital);
                case 2-> EliminarDoctor.eliminarDoctor(hospital);
                case 3-> VerDoctor.verDoctor(hospital);
                case 4-> AgregarEliminarCitas.agregarCitas(hospital);
                case 5-> AgregarEliminarCitas.eliminarCitas(hospital);
                case 6-> {return;}
                case 7-> {
                    Serializador.serializar(hospital);
                    System.exit(0);
                }
            }
        } while (true);
    }
}
