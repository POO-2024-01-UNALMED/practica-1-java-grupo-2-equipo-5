package gestorAplicacion.administracionHospital;

import gestorAplicacion.servicios.Cita;
import gestorAplicacion.servicios.CitaVacuna;
import gestorAplicacion.servicios.Habitacion;
import gestorAplicacion.servicios.Formula;

public interface Pago {

    double IVA = 0.19;

    double calcularValor(Formula formula);
    double calcularValor(Cita cita);
    double calcularValor(CitaVacuna citaVacuna);
    double calcularValor(Habitacion habitacion);

}
