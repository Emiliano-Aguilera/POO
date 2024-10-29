package testeo;

import negocio.*;
import org.junit.*;
import testeo.mockObjects.MockProducto;

public class ItemTest {

    private Catalogo catalogo;
    private Item item;
    private Item item2;

    @Before
    public void setUp() {
        catalogo = new Catalogo();
        MockProducto producto = new MockProducto();
        catalogo.agregarProducto(producto);
        item = new Item(producto.getCodigo(), 0, catalogo);
        MockProducto producto2 = new MockProducto(12, "Pc", 100, 20, 12000);
        catalogo.agregarProducto(producto2);
        item2 = new Item(producto2.getCodigo(), 20, catalogo);
    }

    @Test
    public void calcularSubtotal() {
        System.out.println(item.getSubtotal());
        System.out.println(item2.getSubtotal());
    }

}
