package gestorAplicacion.administracionHospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.CitaVacuna;

public class Vacuna implements Serializable{

    private String tipo;
    private double valor;
    private String nombre;

    private ArrayList<CitaVacuna> agenda =  new ArrayList<CitaVacuna>();
    private ArrayList<String> tipoEps = new ArrayList<String>();
    


    public Vacuna(String tipo, String nombre, ArrayList<String> tipoEps, double valor){
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
        this.tipoEps = tipoEps;

        agenda.add(new CitaVacuna("23 de Agosto de 2024. Hora 7:45 am", null, this));
        agenda.add(new CitaVacuna("26 de Agosto de 2024. Hora 11:20 am", null, this));
        agenda.add(new CitaVacuna("27 de Agosto de 2024. Hora 8:45 am", null, this));
        agenda.add(new CitaVacuna("28 de Agosto de 2024. Hora 3:45 pm", null, this));
        agenda.add(new CitaVacuna("29 de Agosto de 2024. Hora 12:30 m", null, this));
        agenda.add(new CitaVacuna("30 de Agosto de 2024. Hora 10:00 am", null, this));
    }

    public ArrayList<CitaVacuna> mostrarAgendaDisponible(){
        ArrayList<CitaVacuna> agendaDisponible=new ArrayList<CitaVacuna>();
        for (int i =1; i<=agenda.size(); i++){
            if (agenda.get(i-1).getPaciente()==null){
                agendaDisponible.add(agenda.get(i-1));
            }
        }
        return agendaDisponible;
    }

    
    public CitaVacuna actualizarAgenda(Paciente pacienteAsignado, byte numeroCita, ArrayList<CitaVacuna> agendaDisponible){
        CitaVacuna citaAsignada= null;
        for (int i=1 ; i<=agenda.size();i++){
             if(Objects.equals(agenda.get(i-1).getFecha(), agendaDisponible.get(numeroCita-1).getFecha())){
                agenda.get(i-1).setPaceinte(pacienteAsignado);
                citaAsignada=agenda.get(i-1);
             }
        }
        return citaAsignada;
    }


    
}