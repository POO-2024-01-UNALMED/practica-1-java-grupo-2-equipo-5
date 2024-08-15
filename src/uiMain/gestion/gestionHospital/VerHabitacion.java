package uiMain.gestion.gestionHospital;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.servicios.Habitacion;

import java.util.Scanner;

public class VerHabitacion {
    public static void VerHabitacion(Hospital hospital) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tipo de Habitacion que desea ver");
        System.out.println("'CAMILLA' , 'INDIVIDUAL' , 'DOBLE' , 'OBSERVACION' , 'UCI' , 'UCC''");
        String categoriaSeleccionada = sc.next();
        CategoriaHabitacion habitacionSeleccionada = CategoriaHabitacion.valueOf(categoriaSeleccionada);
        for (Habitacion habitacion: hospital.habitaciones){
            if (habitacion.getCategoria()==habitacionSeleccionada){
                String ocupada = "Libre";
                if(habitacion.isOcupada()){
                    ocupada="Ocupada";
                }
                System.out.println("Numero ID de la habitación:  "+ habitacion.getNumero()+" "+ "Tipo de habitación: "+ habitacion.getCategoria()+" "+ "Estado: "+ ocupada);
            }
        }
    }
}
