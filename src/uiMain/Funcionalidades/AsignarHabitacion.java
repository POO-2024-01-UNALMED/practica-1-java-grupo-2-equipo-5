package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.servicios.Habitacion;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;

public class AsignarHabitacion {
    static Scanner sc = new Scanner(System.in);

    public static void asignarHabitacion(Hospital hospital) {
        //Buscar paciente
        System.out.println("Por favor, ingrese el número de identificación del paciente: ");

        int nIdentificacion = sc.nextInt();
        sc.nextLine();

        Paciente paciente = hospital.buscarPaciente(nIdentificacion);

        //El paciente no puede tener una habitación asignada previamente.
        if (paciente != null) {
            if (paciente.getHabitacionAsignada() == null) {
                //Algunos atributos que se usarán
                Habitacion habitacion;
                Habitacion hElegida;
                Habitacion otraHabitacion;
                ArrayList<Habitacion> hDisponibles;
                ArrayList<Habitacion> otraHabitacionDisponibles;
            }
        }
    }

}
