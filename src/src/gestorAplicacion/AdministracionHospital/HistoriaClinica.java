package src.gestorAplicacion.administracionHospital;

import java.util.ArrayList;
import gestorAplicacion.SERVICIOS.Cita;
import gestorAplicacion.Persona.Paciente;
//Falta importar las demás clases aquí...

//Creamos las historias clínicas de los pacientes:
//Podriamos hacer que esto sea un método?

public class HistoriaClinica { // ->Implementar la interface Serializable

    //Atributos.

    private final Paciente paciente; //Único paciente asociado (final).
    private ArrayList<Formula> listaFormulas = new ArrayList<>();
    private ArrayList<Cita> historialCitas = new ArrayList<>();
}
