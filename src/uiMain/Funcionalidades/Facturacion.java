package uiMain.funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.CitaVacuna;
import gestorAplicacion.servicios.Formula;
import gestorAplicacion.servicios.Habitacion;
import gestorAplicacion.servicios.Servicio;

public class Facturacion {

    private static final Scanner sc = new Scanner(System.in);

    public static void facturacion(Hospital hospital) {

        Paciente pacienteSeleccionado;

        do {
            System.out.println("Ingrese el cedula del paciente:");
            pacienteSeleccionado = hospital.buscarPaciente(Integer.parseInt(sc.nextLine()));

            if (pacienteSeleccionado == null) {
                System.out.println("Paciente no encontrado. ¿Desea intentar de nuevo? (s/n)");
                if (sc.nextLine().equalsIgnoreCase("n")) {
                    return;
                }

            }
        }

        while (pacienteSeleccionado == null);

        ArrayList<Servicio> serviciosSinPagar = Servicio.obtenerServiciosSinPagar(pacienteSeleccionado);

        if (serviciosSinPagar.size() == 0) {
            System.out.println("El paciente no tiene servicios pendientes de pago.");
            return;
        }

        System.out.println("El paciente tiene servicios pendientes de pago:");

        for (Servicio servicio : serviciosSinPagar)
            System.out.println(servicio.descripcionServicio());

        Servicio servicioSeleccionado = null;
        System.out.println("Ingrese el número del servicio que va a pagar:");

        do {
            long idSeleccionada = Long.parseLong(sc.nextLine());
            for (Servicio servicio : serviciosSinPagar) {
                if (servicio.idServicio() == idSeleccionada) {
                    servicioSeleccionado = servicio;
                    break;
                }
            }

            if (servicioSeleccionado == null) {
                System.out.println("Servicio no encontrado. ¿Desea intentar de nuevo?");

            }


        }

        while (servicioSeleccionado == null);

        double precioServicioSeleccionado = 0;
        if (servicioSeleccionado instanceof Formula)
            precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((Formula) servicioSeleccionado);

        else if (servicioSeleccionado instanceof CitaVacuna)
            precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((CitaVacuna) servicioSeleccionado);

        else if (servicioSeleccionado instanceof Habitacion)
            precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((Habitacion) servicioSeleccionado);

        else if (servicioSeleccionado instanceof Cita)
            precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((Cita) servicioSeleccionado);

        System.out.println("Total a pagar: $" + precioServicioSeleccionado);
        System.out.println("¿Desea pagar? (s/n)");

        if (sc.nextLine().equalsIgnoreCase("s")) {
            servicioSeleccionado.validarPago(pacienteSeleccionado, servicioSeleccionado.getIdServicio());
            System.out.println("Pago realizado con éxito");

        } else {
            System.out.println("Pago cancelado");
        }
        serviciosSinPagar.clear();


    }
}
