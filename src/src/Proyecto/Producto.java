package Proyecto;

public class Producto {

    //private Inventario inventario;

    public int idProducto; //Utilizar Random para generar un ID aleatorio
    public String nombre;
    public int precio;
    public int cantidadProducto;
    public String descripcion;
    public String categoria;
    public float calificacion;

    //Constructor:

    public Producto(int id , String nombre, int precio, int cantidad, String descripcion, String categoria, float calificacion) {
        this.idProducto = id;
        this.nombre = nombre;
        this.precio = precio;
        this.calificacion = calificacion;
        this.categoria = categoria;
        this.cantidadProducto = cantidad;
        this.descripcion = descripcion;
    }

    //Metodos:

    public int getcantidadProducto() {
        return cantidadProducto;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = (calificacion + this.calificacion) / 2;
    }
    public String toString(){ //Esto sirve para cuando vamos a imprimir el objeto, dependiendo de los parametros que nosotros queremos mostrar
        return "Producto = " + this.nombre + "Cantidad = " + this.cantidadProducto;
    }




}
