package testeo;

import negocio.*;
import org.junit.*;
import testeo.mockObjects.*;

import java.util.ArrayList;

public class CatalogoTest {
    private Catalogo catalogo;

    @Before
    public void setUp() {
        catalogo = new Catalogo();
    }

    @Test
    public void testAgregarProducto() {
        MockProducto p = new MockProducto();
        catalogo.agregarProducto(p);
        ArrayList<Producto> productos = catalogo.obtenerProductos();
        System.out.println(productos.isEmpty());
    }

    @Test
    public void testSacarProducto() {
        MockProducto p = new MockProducto();
        catalogo.agregarProducto(p);
        ArrayList<Producto> productos = catalogo.obtenerProductos();
        System.out.println(productos.getFirst().getCodigo());
        catalogo.sacarProducto(0);
        ArrayList<Producto> productos2 = catalogo.obtenerProductos();
        System.out.println(productos2.isEmpty());
    }

}
