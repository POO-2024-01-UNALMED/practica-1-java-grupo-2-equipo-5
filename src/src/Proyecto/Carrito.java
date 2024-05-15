package src.Proyecto;

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

    public void actualizarCantidad(int indice, int cantidad) {
        productos.set(indice, cantidad);
    }

    public double calcularSubtotal(ArrayList<Producto> productos) {
        suma = 0;
        return suma;
    }

    public void vaciarCarrito() {
        cantidadProducto = 0;
    }

    public void realizarPago() {
        comprar = true;
    }

    public void verCarrito() {
        return "Cantidad productos: " + cantidadProductos + "Total: " + total;
    }
}
