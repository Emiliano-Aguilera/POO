package negocio;

import negocio.SistemaPago.Credito;
import negocio.SistemaPago.Debito;
import negocio.SistemaPago.Efectivo;

import java.util.HashMap;

public class Carrito extends DetalleVenta{
    public static final int EFECTIVO = 0;
    public static final int DEBITO = 1;
    public static final int CREDITO = 2;

    HashMap<Integer, PedidoProducto> productos;
    int metodoPago;

    public Carrito(int idVenta, int fecha, double subtotal, double total) {
        super(idVenta, fecha, subtotal, total);
        productos = new HashMap<>();
    }

    public void cargarProducto(PedidoProducto producto){
        this.productos.put(producto.getIdPedido(), producto);
        this.subtotal += producto.getSubtotal();
    }

    public void eliminarProducto(int idPedido){
        this.subtotal -= productos.get(idPedido).getSubtotal();

        this.productos.remove(idPedido);
    }

    public void vaciarCarrito(){
        productos.clear();
    }

    public void elegirMetodoPago(int metodoPago){
        this.metodoPago = metodoPago;
    }

    private double calcularTotal(int cuotas){
        this.cuotas = cuotas;
        double total = 0.0;

        switch (this.metodoPago){
            case DEBITO:
                Debito debito = new Debito();

                total = debito.calcularTotal(this.subtotal);
            case CREDITO:
                Credito credito = new Credito(cuotas);

                total = credito.calcularTotal(this.subtotal);
            case EFECTIVO:
                Efectivo efectivo = new Efectivo();

                total = efectivo.calcularTotal(this.subtotal);
        }

        return total;
    }
}
