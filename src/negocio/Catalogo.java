package negocio;

import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {
    private final HashMap<Integer, Producto> productos;

    public Catalogo(){
        productos = new HashMap<>();
    }

    public Producto elegirProducto(int codigoProducto){
        return this.productos.get(codigoProducto);
    }

    public void agregarProducto(Producto producto){
        this.productos.put(producto.getCodigo(), producto);
    }

    public void sacarProducto(int codigoProducto){
        this.productos.remove(codigoProducto);
    }

    public HashMap<Integer, Producto> getProductos() {
        return productos;
    }
}