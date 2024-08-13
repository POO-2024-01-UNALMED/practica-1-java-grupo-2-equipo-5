package gestorAplicacion.servicios;

import gestorAplicacion.personas.Paciente;
//import java.io.Serializable;

//La idea de esta clase es que los diferentes servicios hereden de ella
public abstract class Servicio { //TODO: IMPLEMENTAR SERIALIZABLE

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
