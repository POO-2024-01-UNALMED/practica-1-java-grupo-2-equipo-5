package gestorAplicacion.administracionHospital;

import gestorAplicacion.servicios.Cita;
import gestorAplicacion.servicios.CitaVacuna;
import gestorAplicacion.servicios.Habitacion;
import gestorAplicacion.servicios.Formula;

public interface Pago {

    double IVA = 0.19;

    double calcularPrecio(Formula formula);
    double calcularPrecio(Cita cita);
    double calcularPrecio(CitaVacuna citaVacuna);
    double calcularPrecio(Habitacion habitacion);

}
