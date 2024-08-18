package uiMain.gestion.gestionPaciente;

import baseDatos.Serializador;
import gestorAplicacion.administracionHospital.Hospital;
import uiMain.gestion.gestionVacunas.EliminarPaciente;

import java.util.Scanner;

public class GestionPaciente {
    private static final Scanner sc = new Scanner(System.in);

    public static void mostrarMenuGestionPaciente(Hospital hospital) {
        byte opcionSeleccionada;
        
        while (true) {
        	
            // Menú para gestionar la clase Paciente
        	
            System.out.println("\n--- MENU GESTIÓN PACIENTE ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar enfermedad");
            System.out.println("3. Eliminar paciente");
            System.out.println("4. Ver paciente");
            System.out.println("5. Regresar al menú anterior");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcionSeleccionada = sc.nextByte();

            switch (opcionSeleccionada) {
            
                case 1:
                    RegistrarPaciente.registrarPaciente(hospital);
                    break;
                    
                case 2:
                    RegistrarNuevaEnfermedad.registrarNuevaEnfermedad(hospital);
                    break;

                case 3:
                    EliminarPaciente.eliminarPaciente(hospital);
                    break;
                    
                case 4:
                    VerPaciente.mostrarInformacionPaciente(hospital);
                    break;
                    
                case 5:
                    return;
                    
                case 6:
                    Serializador.serializar(hospital);
                    System.exit(0);
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
