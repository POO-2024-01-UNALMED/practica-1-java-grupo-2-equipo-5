package gestorAplicacion.administracionHospital;

import java.util.ArrayList;

import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Cita;
import gestorAplicacion.servicios.CitaVacuna;
//Importar las clases faltantes aquí....

//Clase para crear las historias clinicas de los pacientes.
//Se usa para revisar actividad pasada del paciente con el hospital.

public class HistoriaClinica { // -> Implementar interface Serializable.

    //Atributos
    private final Paciente paciente;
    private ArrayList<Cita> historialcitas = new ArrayList<>();
    private ArrayList<CitaVacuna> historialVacunas = new ArrayList<>();
    private ArrayList<Enfermedad> enfermedades = new ArrayList<>();
    //private ArrayList<Formula> listaFormulas = new ArrayList<>(); para cuando se cree la clase Formula

    //Constructor para inicializar el valor del paciente.
    public HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
    }


    //Métodos get y set para historialCitas, historialVacunas, enfernedades y listaFormulas.
    public Paciente getPaciente() {
        return paciente;
    }

    public ArrayList<Cita> getHistorialcitas() {
        return historialcitas;
    }

    public void setHistorialcitas(ArrayList<Cita> historialcitas) {
        this.historialcitas = historialcitas;
    }

    public ArrayList<CitaVacuna> getHistorialVacunas() {
        return historialVacunas;
    }

    public void setHistorialVacunas(ArrayList<CitaVacuna> historialVacunas) {
        this.historialVacunas = historialVacunas;
    }

    public ArrayList<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    /* Para cuando se implemente la clase Formula
    public ArrayList<Formula> getListaFormulas() {
        return listaFormulas;
    }

    public void setListaFormulas(ArrayList<Formula> listaFormulas) {
        this.listaFormulas = listaFormulas;
    }
    */

}
