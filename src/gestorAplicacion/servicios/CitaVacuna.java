package gestorAplicacion.servicios;
import gestorAplicacion.administracionHospital.Vacuna;
import gestorAplicacion.personas.Paciente;

public class CitaVacuna extends Cita {
    private Vacuna vacuna;
    //Atributos

    public CitaVacuna( Vacuna vacuna, String fecha, Paciente paciente){
        super(null, fecha, paciente)
        this.vacuna=vacuna;
    }
    //Constructor

    @Override
    public void validarPago(Paciente paciente, long idServicio){
        for (CitaVacuna citaVacuna:  paciente.getHistoriaClinica().getHistorialCitas()){
            if(citaVacuna.getIdServicio() == idServicio){
                citaVacuna.getEstadoPago(true);
            }
        }
    }
    @Override
    public String descripcionServicio() {
        return idServicio + " - Vacuna " + vacuna.getNombre() + " (" + fecha + ")";
    }
    //metodos

    public Vacuna getVacuna() {
        return vacuna;
    }
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
  
    public String mensaje(){
        return "del servicio de vacunas";
    }
    //gets y sets
    

}