package gestorAplicacion.administracionHospital;

import gestorAplicacion.servicios.Cita;
import gestorAplicacion.servicios.CitaVacuna;

public interface Pago {

    double Iva = 0.19;

    double calcularValor(Formula formula);
    double calcularValor(Cita cita);
    double calcularValor(CitaVacuna citaVacuna);
    double calcularValor(Habitacion habitacion);

}
