package gestorAplicacion.Proyecto;

import javax.swing.*;
import java.util.ArrayList;

public class Inventario {
    private final String tipoInventario; //(Sugerencia) Hacer esta variable de clase y constante
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private int stock;
    private ArrayList<String> categorias;
    private ArrayList<String> tallas;

    //Constructor:

    public Inventario(String tipoInventario, int stock) {
        this.tipoInventario = tipoInventario;
        this.stock = stock;
    }

    //Métodos:

    //Método get:
    public int getStock() {
        return stock;
    }

    //Método set:
    public void setStock(int stock) {
        this.stock = stock;
    }

    //Descontar cantidad del stock, se llama desde el método eliminarProducto,
    //cuando se realiza una compra:
    public void descontarStock() {
        stock -= 1;
    }

    //Sumar cantidad al stock, se llama desde el método agregarProducto,
    //cuando se ingresa un nuevo producto al stock o se hace una devolución:
    public void sumarStock() {
        stock =+ 1;
    }

    //Agregar un producto al inventario
    public void agregarProducto(Producto producto){
        productos.add(producto);
        this.sumarStock();
    }

    //Eliminar producto del inventario (Por implementar):
    public void eliminarProducto(int indice) {
        productos.remove(indice);
        this.descontarStock();
    }

    //Agregar nuevas categorías (Si es necesario):
    public void agregarCategoria(String categoria) {
        categorias.add(categoria);
    }

    // Ciclo que nos permite recorrer la lista de Productos:
    public void mostrarProductos() {
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i));
        }
    }
}

