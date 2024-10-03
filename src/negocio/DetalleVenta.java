package negocio;

import java.util.ArrayList;
import java.util.HashMap;

public class DetalleVenta {
    protected int idVenta;
    protected HashMap<Integer, PedidoProducto> productos = null;
    protected int fecha;
    protected int metodoDePago;
    protected int cuotas;
    protected double subtotal;
    protected double total;

    public DetalleVenta(int idVenta, HashMap<Integer, PedidoProducto> productos, int fecha, int metodoDePago, int cuotas, int subtotal, double total){
        this.idVenta = idVenta;
        this.productos = productos;
        this.fecha = fecha;
        this.metodoDePago = metodoDePago;
        this.subtotal = subtotal;
        this.cuotas = cuotas;
        this.total = total;
    }

    public DetalleVenta(int idVenta, int fecha, double subtotal, double total){
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
    }
}
