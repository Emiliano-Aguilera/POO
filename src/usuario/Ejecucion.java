package usuario;

import negocio.Carrito;
import negocio.Catalogo;
import negocio.Producto;

import javax.swing.*;

public class Ejecucion{
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        Carrito carrito = new Carrito(catalogo);

        Producto producto1 = new Producto(1, "Papa", 10, 5, 100);
        Producto producto2 = new Producto(2, "Pap2", 10, 5, 100);
        Producto producto3 = new Producto(3, "Pap1", 10, 5, 100);


        catalogo.agregarProducto(producto1);
        catalogo.agregarProducto(producto2);
        catalogo.agregarProducto(producto3);

        SwingUtilities.invokeLater(() -> {
            InterfazCarrito interfaz = new InterfazCarrito(catalogo);
        });
    }
}
