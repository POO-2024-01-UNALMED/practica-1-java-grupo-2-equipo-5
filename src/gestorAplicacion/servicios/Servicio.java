package gestorAplicacion.servicios;

import java.util.ArrayList;

import gestorAplicacion.administracionHospital.HistoriaClinica;
import gestorAplicacion.personas.Paciente;

//La idea de esta clase es que los diferentes servicios hereden de ella
public abstract class Servicio { //--> Implementar la interface Serializable

    //Atributos
    protected Paciente paciente;

    //Constructor
    public Servicio(Paciente paciente) {
        this.paciente = paciente;
    }

    //Metodos restantes

    //Getters y setters

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
