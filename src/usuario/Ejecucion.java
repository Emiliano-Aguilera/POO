package usuario;

import negocio.*;
import negocio.SistemaPago.Efectivo;
import negocio.SistemaPago.MetodoPago;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;

public class Ejecucion{
    public static void main(String[] args) {
        Catalogo catalogo = Catalogo.recuperarse();
        Ventas ventas = Ventas.recuperarse();
        Carrito carrito = new Carrito(catalogo, ventas);

        for(int i = 0; i < 10; i++){
            Producto producto = new Producto(i, "Papa" + i, 10 + i, 5, 100);
            catalogo.agregarProducto(producto);
        }
        ventas.agregarTicket(new Ticket(1, new HashMap<Integer, Item>(), LocalDate.now(), new Efectivo(), 10, 100));

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(catalogo, carrito, ventas);
            ventanaPrincipal.setVisible(true);
        });

        catalogo.guardarse();
        System.out.println(ventas.guardarse());
    }
}
