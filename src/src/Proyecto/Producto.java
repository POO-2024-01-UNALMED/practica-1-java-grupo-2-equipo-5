package Proyecto;

import javax.swing.*;

public class Producto {

    //private Inventario inventario;



    //public int idProducto; //Utilizar Random para generar un ID aleatorio
    public String nombre;
    public int precio;
    public int cantidadProducto;
    public String descripcion;
    public String categoria;
    public float calificacion = 0;


    //Constructor:
    //public Producto() //CONSTRUCTOR VACIO

    public Producto(String nombre, int precio, int cantidad, String descripcion, String categoria, float calificacion) { //RECORDAR: volver a poner el int id
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
        return "Producto = " + this.nombre + "Cantidad = " + this.cantidadProducto;

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

}

