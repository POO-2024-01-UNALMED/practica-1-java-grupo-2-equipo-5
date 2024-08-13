package gestorAplicacion.servicios;

import gestorAplicacion.administracionHospital.Medicamento;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;

import java.util.ArrayList;

public class Formula extends Servicio{
    //Atributos
    private ArrayList<Medicamento> listaMedicamentos=new ArrayList<Medicamento>();
    private Doctor doctor;

    //CONSTRUCTOR
    public Formula(ArrayList<Medicamento> listaMedicamentos, Doctor doctor, Paciente paciente) {
        super(paciente);
        this.listaMedicamentos=listaMedicamentos;
        this.doctor=doctor;
    }
    //Sobrecarga de Constructor

    public Formula(Paciente paciente) {
        this(null, null, paciente);
    }
    //Metodos
    @Override
    public void validarPago(Paciente paciente, long idServicio) {
        for (Formula formula :
                paciente.getHistoriaClinica().getListaFormulas()) {
            if (formula.getIdServicio() == idServicio)
                formula.setEstadoPago(true);
        }
    }

    // Metodo que imprime una descripcion del servicio
    @Override
    public String descripcionServicio() {
        return idServicio + " - Formula prescrita por " + doctor.getNombre();
    }

    // toString
    @Override
    public String toString() {
        return "Hola "+paciente.getNombre()+"\nEstos son tus medicamentos formulados:\n"+listaMedicamentos;
    }



    //GETS Y SETS
    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(ArrayList<Medicamento> listaMedicamentos) {
        this.listaMedicamentos = listaMedicamentos;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
