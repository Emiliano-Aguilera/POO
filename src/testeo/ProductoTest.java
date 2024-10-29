package testeo;

import negocio.Producto;
import org.junit.Before;
import org.junit.Test;
import testeo.mockObjects.MockProducto;

public class ProductoTest {

    Producto producto;

    @Before
    public void setUp() {
        producto = new MockProducto(1234, "PC", 100, 10, 10000);
    }

    @Test
    public void testActualizarStock(){
        System.out.println(producto.getStock());
        producto.actualizarStock(200);
        System.out.println(producto.getStock());
    }
}
