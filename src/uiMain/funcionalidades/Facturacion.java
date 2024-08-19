package uiMain.funcionalidades;

import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Facturacion {

    private static final Scanner sc = new Scanner(System.in);

    public static void facturacion(Hospital hospital){
        //Buscar paciente
        Paciente pacienteSeleccionado;

        do{
            System.out.println("Ingrese la cedula del paciente:");
            pacienteSeleccionado = hospital.buscarPaciente(Integer.parseInt(sc.nextLine()));

            if (pacienteSeleccionado == null) {
                System.out.println("Paciente no encontrado. ¿Desea intentar de nuevo? (s/n)");
                if (sc.nextLine().equalsIgnoreCase("n")){
                    return;
                }
                
            }
        }

        while(pacienteSeleccionado == null);

        //Buscar servicios pendientes por pago
        ArrayList<Servicio> serviciosSinPagar = Servicio.obtenerServiciosSinPagar(pacienteSeleccionado);

        if (serviciosSinPagar.size()==0){
            System.out.println("El paciente no tiene servicios pendientes de pago.");
            return;
        }

        System.out.println("El paciente tiene servicios pendientes de pago:");

        for(Servicio servicio: serviciosSinPagar)
            System.out.println(servicio.descripcionServicio());


        // Seleccionar para pagar
        Servicio servicioSeleccionado = null;
        System.out.println("Ingrese el número del servicio que va a pagar:");

        do{
            long idSeleccionada = Long.parseLong(sc.nextLine());
            for (Servicio servicio : serviciosSinPagar){
                if (servicio.getIdServicio() == idSeleccionada) {
                    servicioSeleccionado = servicio;
                    break; 
                }
            }

            if (servicioSeleccionado == null){
                System.out.println("Servicio no encontrado. ¿Desea intentar de nuevo?");
            }
        }

        while(servicioSeleccionado == null);

        //Calcular precios 
        //Hay ligadura dinamica
        double precioServicioSeleccionado = 0;
        if(servicioSeleccionado instanceof Formula)
        precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((Formula)servicioSeleccionado);
    
        else if (servicioSeleccionado instanceof CitaVacuna)
        precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((CitaVacuna) servicioSeleccionado);
    
        else if (servicioSeleccionado instanceof Habitacion)
        precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((Habitacion) servicioSeleccionado);
    
        else if (servicioSeleccionado instanceof Cita) 
        precioServicioSeleccionado = pacienteSeleccionado.calcularPrecio((Cita) servicioSeleccionado);        
        
        // Meterse la mano al drill(Pagar)
        System.out.println("Total a pagar: $"+ precioServicioSeleccionado);
        System.out.println("¿Desea pagar? (s/n)");
    
        if (sc.nextLine().equalsIgnoreCase("s")){
            servicioSeleccionado.validarPago(pacienteSeleccionado, servicioSeleccionado.getIdServicio());
            System.out.println("Pago realizado con éxito");
    
        }
    
        else{
            System.out.println("Pago cancelado");
        }

        //Limpiar la lista de servicios sin pagar
        serviciosSinPagar.clear();

    }
    
}
