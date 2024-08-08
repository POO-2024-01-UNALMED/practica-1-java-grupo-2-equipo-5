package gestorAplicacion.administracionHospital;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.personas.Paciente;
import gestorAplicacion.servicios.CitaVacuna;

public class Vacuna implements Serializable{

    private String tipo;
    private String nombre;
    private double precio;
    private ArrayList<String> tipoEps = new ArrayList<String>();
    private ArrayList<String> agenda =  new ArrayList<CitaVacuna>();


    public Vacuna(String tipo, String nombre, ArrayList<String> tipoEps, double precio){
        this.tipo = tipo;
        this.nombre = nombre;
        this.tipoEps = tipoEps;
        this.precio = precio;
        
    }


}
