package gestorAplicacion.administracionHospital;

import java.util.ArrayList;

import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
//import gestorAplicacion.servicios.Habitacion;

//Importar el serializable y lo que falte.

//En esta clase va todo lo más general relacionado con el hospital
public class Hospital { //implementar de serializable

    //Atributos
    private ArrayList<Doctor> listaDoctores = new ArrayList<>();
    private ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
    private ArrayList<Vacuna> listaVacunas = new ArrayList<>();
    //Atributo estático que cumple con el requerimiento del proyecto:
    //private static ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
}