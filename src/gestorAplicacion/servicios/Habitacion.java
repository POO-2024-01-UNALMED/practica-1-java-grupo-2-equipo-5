package gestorAplicacion.servicios;

import java.util.ArrayList;

import gestorAplicacion.administracionHospital.CategoriaHabitacion;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.administracionHospital.Hospital;


public class Habitacion extends Servicio{
    
    private int idHabitacion;
    private CategoriaHabitacion categoria;
    private boolean ocupada;
    private int dias;

    public Habitacion(int idHabitacion, CategoriaHabitacion categoria, boolean ocupada, Paciente paciente, int dias){
        
        super(paciente);
        this.idHabitacion= idHabitacion;
        this.categoria = categoria;
        this.ocupada = ocupada;
        this.dias=dias;
        
    }

    public static ArrayList<Habitacion> BuscarHabitacionDisponible(CategoriaHabitacion categoria){

        ArrayList<Habitacion>habitacionesDisponibles=new ArrayList<>();

        for (Habitacion habitacion: Hospital.habitaciones){

            if (!habitacion.isOcupada() && habitacion.getCategoria()==categoria){

                habitacionesDisponibles.add(habitacion);;
            }
        }

        if (habitacionesDisponibles.isEmpty()) {
            return null;
            
        }
        return habitacionesDisponibles;
    }

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

    public void setPaciente(Paciente paciente){

        this.paciente=paciente;

    }

    public CategoriaHabitacion getCategoria(){

        return categoria;
    }

    public void setCategoria(CategoriaHabitacion categoria){

        this.categoria=categoria;

    }

    public boolean isOcupada(boolean ocupada){

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
        return "No.: "idServicio + "- Habitacion"+ idHabitacion + " ocupada "+ dias + " dias";
    }
}
