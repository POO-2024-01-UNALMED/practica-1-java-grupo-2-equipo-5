package gestorAplicacion;
import gestorAplicacion.Proyecto.Inventario;
import gestorAplicacion.Proyecto.Producto;

public class Main {
    public static void main(String[] args) {

        System.out.println("----- TIENDA DE ROPA EL CHUZO -----");

        // CLASE PRODUCTO PRUEBAS:

        Producto producto1 = new Producto( "Jean", 30000, 2, "Pantalon Jean Azul", "Pantalon",0);
        Producto producto2 = new Producto( "Camisa", 30000, 1, "Pantalon Jean Verde", "Pantalon",0);

        System.out.println(producto1);
        System.out.println("--------------------");
        System.out.println(producto2);

        //CLASE INVENTARIO PRUEBAS:

        System.out.println("--------------------");
        System.out.println("Inventario: ");
        Inventario inv1 = new Inventario("Primer Inventario", 0);
        System.out.println(inv1);


    }
}