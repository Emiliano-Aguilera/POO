package negocio;

import datos.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo implements Serializable {
    private final HashMap<Integer, Producto> productos;
    private int idItem;

    public Catalogo(){
        productos = new HashMap<>();
        idItem = 0;
    }

    public Producto elegirProducto(Integer codigoProducto){
        return this.productos.get(codigoProducto);
    }

    public void agregarProducto(Producto producto){
        this.productos.put(producto.getCodigo(), producto);
    }

    public void sacarProducto(Integer codigoProducto){
        this.productos.remove(codigoProducto);
    }

    public ArrayList<Producto> obtenerProductos(){
        return new ArrayList<>(productos.values());
    }

    public int getIdItem() {
        return idItem++;
    }

    public static Catalogo recuperarse(){
        Catalogo cat=(Catalogo)DatosCatalogo.recuperar();
        if(cat == null)
            cat = new Catalogo();
        return cat;
    }

    public boolean guardarse(){
        return DatosCatalogo.guardar(this);
    }
}