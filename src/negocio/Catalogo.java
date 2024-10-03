package negocio;

import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {
    private HashMap<Integer, Producto> productos;

    public Catalogo(){
        productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto){
        this.productos.put(producto.getCodigo(), producto);
    }

    public void sacarProducto(int codigoProducto){
        this.productos.remove(codigoProducto);
    }

    public Producto elegirProducto(int codigoProducto){
        return productos.get(codigoProducto);
    }


}
