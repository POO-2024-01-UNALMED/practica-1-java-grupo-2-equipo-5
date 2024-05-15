package Proyecto;
import java.util.ArrayList;

public class Inventario {
    private String tipoInventario;
    private ArrayList<Producto> productos;
    private int stock;
    private ArrayList<String> categorias;
    private ArrayList<String> tallas;

    //Constructor:

    public Inventario(String tipoInventario, int stock) {
        this.tipoInventario = tipoInventario;
        this.stock = stock;
    }

    //Métodos:

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void descontarStock() {
        stock -= 1;
    }

    public void agregarObjeto(Producto producto){
        productos.add(producto);
    }

    public void agregarCategoria(String categoria) {
        categorias.add(categoria)
    }
}

