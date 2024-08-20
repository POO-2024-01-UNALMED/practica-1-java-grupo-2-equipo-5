package gestorAplicacion.servicios;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.administracionHospital.Hospital;
import gestorAplicacion.personas.Paciente;

import java.util.ArrayList;

//Clase encargada de crear las habitaciones del Hospital

public class Habitacion extends Servicio{
    
    private int numero;
    private CategoriaHabitacion categoria;
    private boolean ocupada;
    private int dias;

    public Habitacion(int idHabitacion, CategoriaHabitacion categoria, boolean ocupada, Paciente paciente, int dias){
        
        super(paciente);
        this.numero= idHabitacion;
        this.categoria = categoria;
        this.ocupada = ocupada;
        this.dias=dias;
        
    }

    //Se crea el metodo estatico, el cual se encarga de filtrar y retornar un ArrayList de las habitaciones vacias de la categoria que se selecciono

    public static ArrayList<Habitacion> BuscarHabitacionDisponible(CategoriaHabitacion categoria){
        ArrayList<Habitacion>habitacionesDisponibles=new ArrayList<>();
        for (Habitacion habitacion: Hospital.getListaHabitaciones()){
            if (!habitacion.isOcupada() && habitacion.getCategoria()==categoria){
                habitacionesDisponibles.add(habitacion);;
            }
        }

        if (habitacionesDisponibles.isEmpty()) {
            return null;
            
        }
        return habitacionesDisponibles;
    }

    //Este metodo se encarga de cambiar la categoria a una inferior
    public static CategoriaHabitacion BuscarOtraCategoria(CategoriaHabitacion categoria){

        switch (categoria) {

            case UCC:
                return CategoriaHabitacion.UCI;

            case UCI:
                return CategoriaHabitacion.OBSERVACION;

            case OBSERVACION:
                return CategoriaHabitacion.DOBLE;

            case DOBLE:
                return CategoriaHabitacion.INDIVIDUAL;
            
            case INDIVIDUAL:
                return CategoriaHabitacion.CAMILLA;

           
            default:
                return null;
        }
    }

    public Paciente getPaciente(){
        
        return paciente;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setPaciente(Paciente paciente){

        this.paciente=paciente;

    }

    public CategoriaHabitacion getCategoria(){

        return categoria;
    }

    public void setCategoria(CategoriaHabitacion categoria){

        this.categoria=categoria;

    }

    public boolean isOcupada(){

        return ocupada;
    }

    public void setOcupada(boolean ocupada){

        this.ocupada=ocupada;
    }

    public int getDias(){
        
        return dias;
    }

    public void setDias(int dias){

        this.dias=dias;
    }

    public void validarPago(Paciente paciente, long idServicio){
        if (paciente.getHabitacionAsignada().getIdServicio()==idServicio)
            paciente.getHabitacionAsignada().setEstadoPago(true);

    }

    public String descripcionServicio(){
        return idServicio + "- Habitacion"+ numero + " ocupada "+ dias + " dias";
    }
}
