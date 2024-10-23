package negocio;


import java.util.HashMap;

public class Catalogo {
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

    public HashMap<Integer, Producto> getProductos() {
        return productos;
    }
}