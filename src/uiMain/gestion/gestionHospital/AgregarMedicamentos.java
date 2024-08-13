package uiMain.gestion.gestionHospital;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Medicamento;
import gestorAplicacion.administracionHospital.Enfermedad;

public class AgregarMedicamentos {
    public static void agregarMeicamentos(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        boolean anadirOtro = false;
        do {
            System.out.println("Bienvenido! Deseas aumentar el stock de un medicamento existente (1) o añadoir uno nuevo (2)?");
            System.out.println("1. Aumentar el stock de un medicamento existente.");
            System.out.println("2. Ingresar un nuevo medicamento.");
            ArrayList<Medicamento> listaMedicamentos = hospital.getListaMedicamentos();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    while (true) {
                        //VerMedicamentos.verMedicamentos(Hospital); //Quitar comentario
                        byte opcionMed = sc.nextByte();
                        if (opcionMed <= 0 || opcionMed > listaMedicamentos.size()) {
                            System.out.println("Opción no válida. Intente de nuevo");
                        } else {
                            Medicamento escogido = listaMedicamentos.get(opcionMed - 1);
                            System.out.println("Ingrese la nueva cantidad del medicamento:");
                            int cantidad = sc.nextInt();
                            escogido.setCantidad(cantidad);
                            System.out.println("Se ha actualizado el medicamento:");
                            System.out.println(escogido);
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {}
            }
        }
    }
}
