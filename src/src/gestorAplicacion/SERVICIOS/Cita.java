package gestorAplicacion.SERVICIOS;
import gestorAplicacion.Persona.Doctor;
import gestorAplicacion.Persona.Paciente;

public class Cita extends Servicio {
    private Doctor doctor;
    protected String fecha;
    #Atributos

    public Cita(Doctor doctor, String fecha, Paciente paciente){
        super(paciente)
        this.doctor = doctor;
        this.fecha = fecha;
    }
    #Constructor

    @Override
    public void validarPago(Paciente paciente, long idServicio){
        for (Cita cita:  paciente.getHistoriaClinica().getHistorialCitas()){
            if(cita.getIdServicio() == idServicio){
                cita.getEstadoPago(true);
            }
        }
    }
    

    

}