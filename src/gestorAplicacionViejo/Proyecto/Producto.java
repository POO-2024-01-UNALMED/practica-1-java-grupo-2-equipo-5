<<<<<<<< HEAD:src/src/gestorAplicacion/Producto.java
package gestorAplicacion;
========
package gestorAplicacion.Proyecto;
>>>>>>>> 7c7155f221b15e549fdeac0a738089f13163e2bb:src/gestorAplicacion/Proyecto/Producto.java

import javax.swing.*;
import java.util.ArrayList;

public class Producto {

    ArrayList<Producto> listaInventario = new ArrayList<Producto>(); //ArrayList de la lista de inventario para mostrar

    //public int idProducto; //Utilizar Random para generar un ID aleatorio
<<<<<<<< HEAD:src/src/gestorAplicacion/Producto.java
    public String nombre;
    public int precio; //El precio Lo podemos mandar a Categoria
    public int cantidadProducto;
    public String descripcion;
    public Categoria categoria;
    public float calificacion = 0; //

    public int  calidad = 5;
========
    private String nombre;
    private int precio;
    private int cantidadProducto;
    private String descripcion;
    private String categoria;
    private float calificacion = 0;
>>>>>>>> 7c7155f221b15e549fdeac0a738089f13163e2bb:src/gestorAplicacion/Proyecto/Producto.java


    //Constructor:
    //public Producto() //CONSTRUCTOR VACIO

    public Producto(String nombre, int precio, int cantidad, String descripcion, Categoria categoria, float calificacion) { //RECORDAR: volver a poner el int id
        //this.idProducto = id;
        this.nombre = nombre;
        this.precio = precio;
        this.calificacion = calificacion;
        this.categoria = categoria;
        this.cantidadProducto = cantidad;
        this.descripcion = descripcion;
    }


    //

    public String Input(String texto){ //Metodo para agregar objetos al ArrayList
        return JOptionPane.showInputDialog(texto);
    }

    public void crearObjeto(){
        String nomb = Input("Nombre del Articulo: ");
        String precioDelArticulo = Input("Precio del Articulo: ");
        Integer intprecio = Integer.valueOf(precioDelArticulo);
        String cant = Input("Cantidad: ");
        Integer intcant = Integer.valueOf(cant);
        String desc = Input("Breve descripcion");
        String cate = Input("Categoría");

        Producto nuevoProducto = new Producto(nomb, intprecio, intcant, desc, cate,0);

    }

    public int getcantidadProducto() {
        return cantidadProducto;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = (calificacion + this.calificacion) / 2;
    }

    public String toString() { //Esto sirve para cuando vamos a imprimir el objeto, dependiendo de los parametros que nosotros queremos mostrar
        return "Producto: " + this.nombre + " - " + "Cantidad: " + this.cantidadProducto;

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public void setCalidad(int calidad){
        this.calidad = calidad;
    }
}

