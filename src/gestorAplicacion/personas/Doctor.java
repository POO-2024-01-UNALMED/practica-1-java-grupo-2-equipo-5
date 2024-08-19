package gestorAplicacion.personas;

import gestorAplicacion.servicios.Cita;

import java.util.ArrayList;

public class Doctor extends Persona{

    //ATRIBUTOS

    private String especialidad;
    private ArrayList<Cita> agendaDoctor = new ArrayList<>();

    //Constructor clase Doctor
    public Doctor(int cedula, String nombre, String tipoEps, String especialidad) {
    super(cedula, nombre, tipoEps);
    this.especialidad = especialidad;

    agendaDoctor.add(new Cita(this,"3 de Abril, 8:00 am", null));
    agendaDoctor.add(new Cita(this,"4 de Abril, 3:00 pm", null));
    agendaDoctor.add(new Cita(this,"5 de Abril, 10:00 am", null));
    }

    //Metodos clase doctor

    public ArrayList<Cita> mostrarAgendaDisponible() {
        ArrayList<Cita> agendaDisponible = new ArrayList<>();
        for (int i = 1; i <= agendaDoctor.size(); i++) {
            if (agendaDoctor.get(i - 1).getPaciente() == null) {
                agendaDisponible.add(agendaDoctor.get(i - 1));}
        }
        return agendaDisponible;
    }

    public Cita actualizarAgenda(Paciente pacienteAsignado, byte numeroCita, ArrayList<Cita> agendaDisponible) {
        Cita citaAsignada = null;
        for(int i=1; i<=agendaDoctor.size(); i++) {
            if (agendaDoctor.get(i-1).getFecha().equals(agendaDisponible.get(numeroCita-1).getFecha())) {
                agendaDoctor.get(i-1).setPaciente(pacienteAsignado);
                citaAsignada = agendaDoctor.get(i-1);
            }
        }
        return citaAsignada;
    }


    public  String bienvenida(){
        return "Bienvenido, Doctor " +getNombre(); //Metodo clase persona

    }


    public String toString(){
        return "Nombre: "+ getNombre() +"\nCedula: " +getCedula() + "\nTipo de EPS: "+ getTipoEps() + "\nEspecialidad: " +getEspecialidad();
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
