package negocio;

import datos.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo implements Serializable {
    private final HashMap<Integer, Producto> productos;

    public Catalogo(){
        productos = new HashMap<>();
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