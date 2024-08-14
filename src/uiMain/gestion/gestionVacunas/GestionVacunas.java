package uiMain.gestion.gestionVacunas;

import java.util.Scanner;

import gestorAplicacion.administracionHospital.Hospital;

public class GestionVacunas {

    static Scanner sc = new Scanner(System.in);
    public static void menuGestionVacunas(Hospital hospital){
        byte opcion;
        do{
            System.out.println("Gestion de Vacunas");
            System.out.println("1. Registrar Vacuna");
            System.out.println("2. Eliminar Vacuna");
            System.out.println("3. Agregar cita de una vacuna");
            System.out.println("4. Eliminar cita de una vacuna");
            System.out.println("5. Ver informacion de una vacuna");
            System.out.println("6. Regresar al menu anterior");
            System.out.println("7. Salir");
            opcion = sc.nextByte();
            switch(opcion){
                case 1 -> RegistrarEliminarVacunas.registrarVacuna(hospital);
                case 2 -> RegistrarEliminarVacunas.eliminarVacuna(hospital);
                case 3 -> AgregarElinimarCitaVacuna.agregarCitaVacuna(hospital);
                case 4 -> AgregarElinimarCitaVacuna.eliminarCitaVacuna(hospital);
                case 5 -> VerVacuna.verVacuna(hospital);
                case 6 -> {
                    return;
                }
                case 7 -> {
                    Serializador.serializador(hospital);
                    System.exit(0);
                }

            }  
        }
        while (true);
    }
}
