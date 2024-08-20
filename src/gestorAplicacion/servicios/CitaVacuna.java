package gestorAplicacion.servicios;

import gestorAplicacion.administracionHospital.Vacuna;
import gestorAplicacion.personas.Paciente;

//Clase destinada a las citas que son de vacunas
public class CitaVacuna extends Cita {

    //ATRIBUTOS

    private Vacuna vacuna;


    //CONSTRUTOR

    public CitaVacuna(String fecha, Paciente paciente, Vacuna vacuna) {
        super(null, fecha, paciente);
        this.vacuna=vacuna;
    }

    //METODOS

    //Metodo para buscar id del servicio y cambiar estado de pago
    @Override
    public void validarPago(Paciente paciente, long idServicio){
        for (CitaVacuna citaVacuna:  paciente.getHistoriaClinica().getHistorialVacunas()){
            if(citaVacuna.getIdServicio() == idServicio){
                citaVacuna.setEstadoPago(true);
            }
        }
    }

    // Metodo que imprime una descripcion del servicio
    @Override
    public String descripcionServicio() {
        return idServicio + " - Vacuna " + vacuna.getNombre() + " (" + fecha + ")";
    }

    //GETS Y SETS

    public Vacuna getVacuna() {
        return vacuna;
    }
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
  
    public String mensaje(){
        return "del servicio de vacunas";
    }

    

}