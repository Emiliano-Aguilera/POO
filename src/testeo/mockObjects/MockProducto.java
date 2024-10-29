package testeo.mockObjects;

import negocio.Producto;

public class MockProducto extends Producto {

    public MockProducto() {
        super(0, "", 0, 0, 0);
    }

    public MockProducto(Integer codigo, String descripcion, int stock, int stockMin, double precio) {
        super(codigo, descripcion, stock, stockMin, precio);
    }

}
