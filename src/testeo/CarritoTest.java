package testeo;

import negocio.*;
import negocio.SistemaPago.*;
import org.junit.*;
import testeo.mockObjects.MockProducto;

import java.util.HashMap;

public class CarritoTest {

    private Catalogo catalogo;
    private Item item;
    private Carrito carrito;
    private Ventas ventas;

    @Before
    public void setUp() {
        ventas = new Ventas();
        catalogo = new Catalogo();
        carrito = new Carrito(catalogo, ventas);
        MockProducto producto = new MockProducto(12, "Pc", 100, 20, 12000);
        catalogo.agregarProducto(producto);
        item = new Item(producto.getCodigo(), 20, catalogo);
    }

    @Test
    public void cargarProducto() {
        carrito.cargarProducto(item);
        HashMap<Integer, Item> carritoCargado = carrito.getItemsCargados();
        System.out.println(carritoCargado.isEmpty());
    }
    
    @Test 
    public void enviarCarrito() {
        carrito.cargarProducto(item);
        MetodoPago Efectivo = new Efectivo();
        Ticket ticketDevuelto = carrito.enviarCarrito(Efectivo, 240000);
        System.out.println(ticketDevuelto.getMetodoDePago().getNombre());
    }

    @Test
    public void vaciarCarrito() {
        carrito.cargarProducto(item);
        carrito.vaciarCarrito();
        HashMap<Integer, Item> carritoCargado = carrito.getItemsCargados();
        System.out.println(carritoCargado.isEmpty());
    }

}
