package negocio;

import negocio.SistemaPago.Credito;
import negocio.SistemaPago.Debito;
import negocio.SistemaPago.Efectivo;
import negocio.SistemaPago.MetodoPago;

import java.util.HashMap;

public class Carrito extends DetalleVenta{
    public static final Boolean SUCCESS = true;
    public static final Boolean ERROR = false;

    HashMap<Integer, PedidoProducto> itemsCargados;
    MetodoPago metodoPago;
    int cuotas;

    public Carrito(int idVenta, int fecha, double subtotal, double total) {
        super(idVenta, fecha, subtotal, total);
        itemsCargados = new HashMap<>();
    }

    public Boolean cargarProducto(PedidoProducto itemPedido){
        Boolean resultado = ERROR;

        Catalogo catalogo = Catalogo.obtenerInstancia();

        Producto productoACargar = catalogo.elegirProducto(itemPedido.getCodigoProducto());

        PedidoProducto itemCargado = itemsCargados.get(itemPedido.getCodigoProducto());

        int cantACargar = itemPedido.getCantidad();

        if(itemCargado != null){
            int cantVieja = itemCargado.getCantidad();
            int cantNueva = cantVieja + cantACargar;

            if(productoACargar.getStock() >= cantNueva){
                this.subtotal += itemPedido.getSubtotal();

                itemCargado.setCantidad(cantNueva);

                resultado = SUCCESS;
            }
        }
        else{
            if(productoACargar.getStock() >= cantACargar) {
                itemsCargados.put(itemPedido.getCodigoProducto(), itemPedido);

                this.subtotal += itemPedido.getSubtotal();

                resultado = SUCCESS;
            }
        }
        return resultado;
    }

    public void eliminarProducto(int idPedido){
        this.itemsCargados.remove(idPedido);
        this.subtotal -= itemsCargados.get(idPedido).getSubtotal();
    }

    public void vaciarCarrito(){
        itemsCargados.clear();
    }

    private void calcularTotal(){
        this.total = this.metodoPago.calcularTotal(this.subtotal);
    }

    private void actualizarStockProductos(){
        Catalogo catalogo = Catalogo.obtenerInstancia();

        itemsCargados.forEach((idProducto, itemPedido) -> {
            catalogo.elegirProducto(idProducto).actualizarStock(-itemPedido.getCantidad());
        });
    }

    public DetalleVenta enviarCarrito(){
        calcularTotal();
        actualizarStockProductos();
        return new DetalleVenta(this.idVenta, this.itemsCargados, this.fecha,
                this.metodoDePago, this.cuotas, this.subtotal, this.total);
    }

    public HashMap<Integer, PedidoProducto> getItemsCargados() {
        return itemsCargados;
    }

    public void setItemsCargados(HashMap<Integer, PedidoProducto> itemsCargados) {
        this.itemsCargados = itemsCargados;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
