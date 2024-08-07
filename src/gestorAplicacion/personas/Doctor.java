package gestorAplicacion.personas;

import java.util.ArrayList;

public class Doctor extends Persona{ //Falta el extends de persona

    //Atributos de la Clase Doctor
    private String especialidad;
    //Crear clase Cita
    private ArrayList<Cita> agendaDoctor = new ArrayList<Cita>();

    //Constructor clase Doctor
    public Doctor(int cedula, String nombre, String tipoEps){
    //Falta crear la clase Cita
    }

    //Metodos clase doctor

    public ArrayList<Cita> mostrarAgendaDisponible(){
        ArrayList<Cita> agendaDisponible = new ArrayList<Cita>();

    //Crear ciclo for para que recorra el ArrayList junto con la agenda

    }
    //Crear Metodo con la clase Cita donde se actualice la agenda

    public  String bienvenida(){
        return "Bienvenido, Doctor " +getNombre(); //Metodo clase persona

    }

    public String despedida(){
        return "Adios, Doctor";
    }

    public String toString(){
        return "Nombre: "+ getNombre() +"\nCedula: " +getCedula() + "\nTipo de EPS"+ getTipoEps() + "\nEspecialidad: " +getEspecialidad();
    }



    //GET Y SET

    public String getEspecialidad(){
        return especialidad;
    }

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    public ArrayList<Cita> getAgendaDoctor(){
        return agendaDoctor;
    }
    public void setAgendaDoctor(ArrayList<Cita> agenda) {
        this.agendaDoctor = agenda;
    }

}
