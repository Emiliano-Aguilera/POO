package usuario;

import negocio.*;
import negocio.SistemaPago.Efectivo;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;

public class Ejecucion{
    public static void main(String[] args) {
        Catalogo catalogo = Catalogo.recuperarse();
        Ventas ventas = Ventas.recuperarse();
        Carrito carrito = new Carrito(catalogo, ventas);

        ventas.agregarTicket(new Ticket(1, new HashMap<>(), LocalDate.now(), new Efectivo(), 10, 100));

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(catalogo, carrito, ventas);
            ventanaPrincipal.setVisible(true);
        });
    }
}
