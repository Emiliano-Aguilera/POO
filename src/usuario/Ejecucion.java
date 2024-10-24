package usuario;

import negocio.Carrito;
import negocio.Catalogo;
import negocio.Producto;

import javax.swing.*;

public class Ejecucion{
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        Carrito carrito = new Carrito(catalogo);

        for(int i = 0; i < 10; i++){
            Producto producto = new Producto(i, "Papa" + i, 10 + i, 5, 100);

            catalogo.agregarProducto(producto);
        }

        SwingUtilities.invokeLater(() -> {
            InterfazListaProductos interfaz = new InterfazListaProductos(catalogo, carrito);
            interfaz.mostrarProductos();
        });
    }
}
