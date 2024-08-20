package gestorAplicacion.administracionHospital;

import gestorAplicacion.servicios.Cita;
import gestorAplicacion.servicios.CitaVacuna;
import gestorAplicacion.servicios.Habitacion;
import gestorAplicacion.servicios.Formula;

//Interfaz destinada a pagos
public interface Pago {
    //Constante
    double IVA = 0.19;
    //Metodos
    double calcularPrecio(Formula formula);
    double calcularPrecio(Cita cita);
    double calcularPrecio(CitaVacuna citaVacuna);
    double calcularPrecio(Habitacion habitacion);

}
