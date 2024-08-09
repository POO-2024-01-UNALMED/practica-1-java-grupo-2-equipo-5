package gestorAplicacion.servicios;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;

public class Cita extends Servicio {
    private Doctor doctor;
    protected String fecha;
    //Atributos

    public Cita(Doctor doctor, String fecha, Paciente paciente){
        super();
        this.doctor = doctor;
        this.fecha = fecha;
    }
    //Constructor

    @Override
    public void validarPago(Paciente paciente, long idServicio){
        for (Cita cita:  paciente.getHistoriaClinica().getHistorialCitas()){
            if(cita.getIdServicio() == idServicio){
                cita.getEstadoPago(true);
            }
        }
    }
    @Override
    public String descripcionServicio() {
        return idServicio + " - Cita medica con " + doctor.getNombre() + " (" + fecha + ")";
    }
    //metodos

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String mensaje(){
        return "del servicio cita médica!";
    }
    //gets y sets

    

}