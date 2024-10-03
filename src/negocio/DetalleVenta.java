package negocio;

import java.util.ArrayList;

public class DetalleVenta {
    protected int idVenta;
    protected ArrayList<PedidoProducto> Productos;
    protected int fecha;
    protected int metodoDePago;
    protected double subtotal;
    protected double total;

    public DetalleVenta(int idVenta, ArrayList<PedidoProducto> Productos, int fecha, int metodoDePago, double subtotal, double total){
        this.idVenta = idVenta;
        this.Productos = Productos;
        this.fecha = fecha;
        this.metodoDePago = metodoDePago;
        this.subtotal = subtotal;
        this.total = total;
    }
}
