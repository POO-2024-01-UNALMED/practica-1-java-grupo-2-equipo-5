package gestorAplicacion.servicios;

import gestorAplicacion.administracionHospital.HistoriaClinica;
import gestorAplicacion.personas.Paciente;

import java.io.Serializable;
import java.util.ArrayList;



//COMO CLASE ABSTRACTA, ESTA PENSADA PARA IMPLEMENTAR LA HERENCIA DE LOS SERVICIOS GENERALES DEL HOSPITAL
public abstract class Servicio implements Serializable {

    //ATRIBUTOS
    protected Paciente paciente;
    protected static long generadorID = 1000;
    protected final long idServicio;
    private boolean estadoPago;



    //CONSTRUCTOR
    public Servicio(Paciente paciente) {
        this.paciente = paciente;
        this.idServicio = generadorID++;
        this.estadoPago = false;
    }

    //METODOS

    public abstract void validarPago(Paciente paciente, long idServicio);

    public abstract String descripcionServicio();

    public static ArrayList<Servicio> obtenerServiciosSinPagar(Paciente paciente) {
        HistoriaClinica historiaClinicaPaciente = paciente.getHistoriaClinica();
        ArrayList<Servicio> listaServicios = new ArrayList<Servicio>();

        listaServicios.addAll(historiaClinicaPaciente.getHistorialCitas());
        listaServicios.addAll(historiaClinicaPaciente.getListaFormulas());
        if(paciente.getHabitacionAsignada() != null)
            listaServicios.add(paciente.getHabitacionAsignada());
        listaServicios.addAll(historiaClinicaPaciente.getHistorialVacunas());

        listaServicios.removeIf(Servicio::isEstadoPago);

        return listaServicios;
    }

    //GETTERS Y SETTERS

    public boolean isEstadoPago(){return estadoPago;}

    public long getIdServicio(){return idServicio;}

    public void setEstadoPago(boolean estadoPago){this.estadoPago = estadoPago;}

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
