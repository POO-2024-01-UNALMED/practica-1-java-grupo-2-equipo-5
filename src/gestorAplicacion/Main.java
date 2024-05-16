package gestorAplicacion;
import gestorAplicacion.Proyecto.Inventario;
import gestorAplicacion.Proyecto.Producto;
import gestorAplicacion.Proyecto.Carrito;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("----- TIENDA DE ROPA EL CHUZO -----");

        // CLASE PRODUCTO PRUEBAS:

        Producto producto1 = new Producto( "Jean", 30000, 2, "Pantalon Jean Azul", "Pantalon",0);
        Producto producto2 = new Producto( "Camisa", 30000, 1, "Pantalon Jean Verde", "Pantalon",0);

        //System.out.println(producto1);
        //System.out.println(producto2);

        //CLASE INVENTARIO PRUEBAS:

        Inventario inv1 = new Inventario("Primer Inventario", 0);
        //System.out.println(inv1);


        //Añadiendo productos al inventario con el método agregarProductos (Test):

        inv1.agregarProducto(producto1);
        inv1.agregarProducto(producto2);
        System.out.println("Listado de productos:");
        inv1.mostrarProductos();

        //Añadiendo productos al carrito y mostrandolos por pantalla (Test):

        System.out.println("Carrito de Compras: ");

        //Creamos un carrito:
        Carrito carrito1 = new Carrito();
        
        //Le añadimos productos:
        carrito1.agregarProducto(producto1, 3);
        carrito1.agregarProducto(producto2, 2);
        
        //Los mostramos por consola y calculamos el subtotal:
        carrito1.verCarrito();

        //Eliminar producto:


    }
}