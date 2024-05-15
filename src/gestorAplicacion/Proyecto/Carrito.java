package gestorAplicacion.Proyecto;
import java.util.ArrayList;

public class Carrito {

//Atributos:

    private int cantidadProducto;
    private double subtotal;
    private double total;
    private ArrayList<Producto> productos;

//Métodos:

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
    }

    public void removerProducto(int indice) {
        productos.remove(indice);
    }

    public void actualizarCantidad(int indice, Producto producto) {
        productos.set(indice, producto);
    }

    public double calcularSubtotal(ArrayList<Producto> productos) {
        int suma = 0;
        return suma;
    }

    public void vaciarCarrito() {
        cantidadProducto = 0;
    }

    public boolean realizarPago() {
        boolean comprar = true;
        return comprar;
    }

    public String verCarrito() {
        return "Cantidad productos: " + cantidadProducto + "Total: " + total;
    }
}
