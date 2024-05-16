package gestorAplicacion.Proyecto;
import java.util.ArrayList;

public class Carrito {

    //Atributos:

    private int cantidadProductos;
    private double subtotal;
    private ArrayList<Producto> productos = new ArrayList<>();

    //Métodos:

    //Agragar productos al carrito (Mejorar):
    public void agregarProducto(Producto producto, int cantidad) {
        for (int a = 0; a < cantidad; a++) {
            productos.add(producto);
            cantidadProductos++;
        }
        System.out.println("Se añadieron " + cantidad + " " + producto.getNombre() + " al carrito!");
    }

    //Eliminar productos del carrito (Por corregir):
    public void removerProducto(int indice){
        productos.remove(indice);
    }

    //Cambiar la cantidad de cierto producto (Por corregir):
    public void actualizarCantidad(int indice, Producto producto) {
        productos.set(indice, producto);
    }

    //Calcular el subtotal:
    public double calcularSubtotal() {
        for (Producto producto : productos) {
            subtotal += producto.getPrecio();
        }
        return subtotal;
    }

    //Vaciar el carrito por completo.
    public void vaciarCarrito() {
        productos.clear();
        System.out.println("Se vació el carrito de compras!");
    }

    //Método que nos redirija a la opción de pagar (Continuar con la compra):
    public boolean realizarPago() {
        boolean comprar = true;
        return comprar;
    }

    // Ver que productos ha escogido el cliente.
    // Primero se verifica si el carrito está vacio. Si no lo está,
    // calculamos el total de productos y el costo total.
    public void verCarrito() {
        if (productos.size() == 0) { // Cambiar por: productos.isEmpty()?
            System.out.println("El carrito está vacío. Por favor, seleccione un producto del catálogo para continuar.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto.getNombre());
            }
            System.out.println("Cantidad total de productos: " + cantidadProductos);
            System.out.println("Subtotal: $" + calcularSubtotal());
        }
    }

}
