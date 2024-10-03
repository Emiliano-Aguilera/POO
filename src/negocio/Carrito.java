package negocio;

import java.util.ArrayList;

public class Carrito extends DetalleVenta{

    public Carrito(int idVenta, ArrayList<PedidoProducto> Productos, int fecha, int metodoDePago, double subtotal, double total) {
        super(idVenta, Productos, fecha, metodoDePago, subtotal, total);
    }


}
