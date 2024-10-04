package negocio;

import java.util.ArrayList;
import java.util.HashMap;

public class Catalogo {
    private final HashMap<Integer, Producto> productos;

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
        return this.productos.get(codigoProducto);
    }

    public void mostrarCatalogo() {
        productos.forEach((codigo, producto) -> {
            int stock = producto.getStock();
            if (stock <= producto.getStockMinimo()) {
                System.out.printf("*** Codigo: %d \t Nombre: %s \t Stock: %d \n", codigo, producto.getDescripcion(), stock);
            } else {
                System.out.printf("Codigo: %d \t Nombre: %s \t Stock: %d \n", codigo, producto.getDescripcion(), stock);
            }
        });
    }
}