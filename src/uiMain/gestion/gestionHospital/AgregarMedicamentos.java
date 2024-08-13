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
        }
    }
}
