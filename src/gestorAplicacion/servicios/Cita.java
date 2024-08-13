package gestorAplicacion.servicios;
import gestorAplicacion.personas.Doctor;
import gestorAplicacion.personas.Paciente;

public class Cita extends Servicio {
    private Doctor doctor;
    protected String fecha;
    //ATRIBUTOS

    public Cita(Doctor doctor, String fecha, Paciente paciente){
        super(paciente);
        this.doctor = doctor;
        this.fecha = fecha;
    }
    //CONSTRUCTOR

    @Override
    public void validarPago(Paciente paciente, long idServicio){
        for (Cita cita:  paciente.getHistoriaClinica().getHistorialCitas()){
            if(cita.getIdServicio() == idServicio){
                cita.setEstadoPago(true);
            }
        }
    }
    @Override
    public String descripcionServicio() {
        return idServicio + " - Cita medica con " + doctor.getNombre() + " (" + fecha + ")";
    }

    //GETS Y SETS

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


    

}