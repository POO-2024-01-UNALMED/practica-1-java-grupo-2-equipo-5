package gestorAplicacion.administracion;

import java.io.Serializable;

import gestorAplicacion.personas.Enfermedad;

public class Medicamento implements Serializable {

    private String nombre;
    private Enfermedad enfermedad;
    private String descripcion;
    private int cantidad;
    private float precio;

    public Medicamento(String nombre, Enfermedad enfermedad, String descripcion, int cantidad, float precio){
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.descripcion = descripcion;
        this.cantidad=cantidad;
        this.precio=precio;
    }

}
