package gestorAplicacion.administracionHospital;

import java.io.Serializable;

public class Medicamento implements Serializable {


    //ATRIBUTOS
    private String nombre;
    private Enfermedad enfermedad;
    private String descripcion;
    private int cantidad;
    private float precio;


    //METODOS
    public Medicamento(String nombre, Enfermedad enfermedad, String descripcion, int cantidad, float precio){
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.descripcion = descripcion;
        this.cantidad=cantidad;
        this.precio = precio;
    }

    public void eliminarCantidad(){
        this.cantidad -= 1;
    }

    //SETS Y GETS


    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Enfermedad getEnfermedad(){return enfermedad;}

    public void setEnfermedad(Enfermedad enfermedad){
        this.enfermedad = enfermedad;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(){
        this.descripcion = descripcion;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public float getPrecio(){return valor;}

    public void setPrecio(float precio){
        this.precio = precio;
    }

    public String toString(){return "Nombre:" + nombre +", " + "Enfermedad:"+ enfermedad.getNombre()+" "+ enfermedad.getTipologia()+", "+"Descripcion:"+descripcion;}
}
