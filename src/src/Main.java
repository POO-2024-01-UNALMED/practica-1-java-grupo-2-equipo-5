package src;
import src.Proyecto.Inventario;
import src.Proyecto.Producto;

public class Main {
    public static void main(String[] args) {
        // CLASE PRODUCTO PRUEBAS
        Producto producto1 = new Producto( "jean", 30000, 2, "Pantalon Jean Azul", "Pantalon",0);
        Producto producto2 = new Producto( "jean", 30000, 1, "Pantalon Jean Verde", "Pantalon",0);

        System.out.println(producto2);
        System.out.println(producto1);



        //CLASE INVENTARIO PRUEBAS

        Inventario inv1 = new Inventario("Primer Inventario", 0);


    }
}