package uiMain.gestion.gestionHospital;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.administracionHospital.Medicamento;

import java.util.ArrayList;

public class VerMedicamentos {
    public static void verMedicamentos(Hospital hospital) {
        ArrayList<Medicamento> listaMedicamentos = hospital.getListaMedicamentos();
        System.out.println("Este es el inventario de los medicamentos del hospital");
        for (int i = 0; i < listaMedicamentos.size(); i++) {
            System.out.println( i + 1 + "." + listaMedicamentos.get(i).getNombre() + "Cantidad: " + listaMedicamentos.get(i).getCantidad());

        }
    }
}
