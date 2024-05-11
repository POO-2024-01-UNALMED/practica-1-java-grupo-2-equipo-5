package Proyecto;

public class Producto {

    private Inventario inventario;

    private int idProducto; //Utilizar Random para generar un ID aleatorio
    private String nombre;
    private int precio;
    private int cantidadProducto;
    private String descripcion;
    private String categoria;
    private float calificacion;

    //Constructor:

    public Producto(int id , String nombre, int precio, int cantidad, String descripcion, String categoria, float calificacion) {

    }

    //Metodos:

    public int getcantidadProducto() {
        
        return cantidadProducto;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = (calificacion + this.calificacion) / 2;

    }

    public void setInventario()

    


}
