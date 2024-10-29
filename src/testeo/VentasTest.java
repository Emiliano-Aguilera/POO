package testeo;

import negocio.*;
import negocio.SistemaPago.*;
import org.junit.*;
import java.time.LocalDate;
import java.util.HashMap;

public class VentasTest {

    private Ticket ticket;
    private Ventas ventas;

    @Before
    public void setUp() {
        LocalDate fecha = LocalDate.of(2020, 1, 8);
        ventas = new Ventas();
        ticket = new Ticket(1, new HashMap<Integer, Item>(), fecha, new Efectivo(), 1000, 900);
    }

    @Test
    public void testCargarTicket() {
        ventas.agregarTicket(ticket);
        HashMap<Integer, Ticket> ventasTotales = ventas.getVentas();
        System.out.println(ventasTotales.isEmpty());
    }


}
