package uiMain.gestion.gestionHospital;

import java.util.Scanner;

//import baseDatos.Serializador;
import baseDatos.Serializador;
import gestorAplicacion.administracionHospital.Hospital;


public class GestionHospital {
    private static final Scanner sc = new Scanner(System.in);

    public static void menuGestionHospital(Hospital hospital) {
        byte opcion;

        do {
            System.out.println("\n---Menu Gestion Hospital---");
            System.out.println("Por favor, elija una de las siguientes opciones: ");
            System.out.println("1. Construir Habitación");
            System.out.println("2. Ver lista de Habitaciones");
            System.out.println("3. Destruir Habitación");
            System.out.println("4. Agregar Medicamentos");
            System.out.println("5. Ver Inventario de medicamentos");
            System.out.println("6. Ver personas registradas en el hospital");
            System.out.println("7. Ver vacunas registradas en el hospital");
            System.out.println("8. --Regresar al menu anterior--");
            System.out.println("9. --Salir--");

            opcion = sc.nextByte();

            switch (opcion) {
                case 1 -> ConstruirHabitacion.construirHabitacion(hospital);
                case 2 -> VerHabitacion.verHabitacion(hospital);
                case 3 -> DestruirHabitacion.destruirHabitacion(hospital);
                case 4 -> AgregarMedicamentos.agregarMedicamentos(hospital);
                case 5 -> VerMedicamentos.verMedicamentos(hospital);
                case 6 -> VerPersonasRegistradas.verPersonasRegistradas(hospital);
                case 7 -> VerVacunas.verVacunas(hospital);
                case 8 -> {
                    return;
                }
                case 9 -> {
                    //Serializador.serializar(hospital); -> Terminar
                    System.exit(0);
                }
            }
        } while (true);
    }
}