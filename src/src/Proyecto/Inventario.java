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

    //Metodos

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void agregarObjeto(ArrayList<Producto>){
        productos.add()
    }
}

