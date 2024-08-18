package gestorAplicacion.administracionHospital;

import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.Cita;
import gestorAplicacion.servicios.CitaVacuna;
import gestorAplicacion.servicios.Formula;

import java.io.Serializable;
import java.util.ArrayList;


//Se usa para revisar actividad pasada del paciente con el hospital.
public class HistoriaClinica implements Serializable { // -> Implementar interface Serializable.

    //Atributos
    private final Paciente paciente;
    private ArrayList<Cita> historialCitas = new ArrayList<>();
    private ArrayList<Formula> listaFormulas = new ArrayList<>();
    private ArrayList<CitaVacuna> historialVacunas = new ArrayList<>();
    private ArrayList<Enfermedad> enfermedades = new ArrayList<>();
    //private ArrayList<Formula> listaFormulas = new ArrayList<>(); para cuando se cree la clase Formula


    //CONSTRUCTOR
    public HistoriaClinica(Paciente paciente) {
        this.paciente = paciente;
    }


    public ArrayList<Doctor> buscarCitaDoc(String especialidad, Hospital hospital) {
        ArrayList<Doctor> doctoresDisp = hospital.buscarTipoDoctor(especialidad);
        ArrayList<Doctor> docCita = new ArrayList<>();
        for (Doctor doc : doctoresDisp){
            for (Cita cita : historialCitas){
                if (doc.getCedula() == cita.getDoctor().getCedula()){
                    docCita.add(doc);
                }
            }
        }
        return docCita;
    }

    public void agregarFormula(Formula formulaPaciente) {
        listaFormulas.add(formulaPaciente);
    }


    //GETS Y SETS

    public Paciente getPaciente() {
        return paciente;
    }

    public ArrayList<Cita> getHistorialcitas() {
        return historialCitas;
    }

    public void setHistorialcitas(ArrayList<Cita> historialcitas) {
        this.historialCitas = historialcitas;
    }

    public ArrayList<Formula> getListaFormulas() {
        return listaFormulas;
    }

    public void setListaFormulas(ArrayList<Formula> listaFormulas) {
        this.listaFormulas = listaFormulas;
    }

    public ArrayList<CitaVacuna> getHistorialVacunas() {
        return historialVacunas;
    }

    public ArrayList<Cita> getHistorialCitas() {
        return historialCitas;}

    public void setHistorialCitas(ArrayList<Cita> historialcitas) {
        this.historialCitas = historialcitas;}

    public void setHistorialVacunas(ArrayList<CitaVacuna> historialVacunas) {
        this.historialVacunas = historialVacunas;}

    public ArrayList<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

}
