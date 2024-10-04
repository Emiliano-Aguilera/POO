package negocio;

import negocio.SistemaPago.MetodoPago;

import java.util.HashMap;

public class Carrito{

    private HashMap<Integer, Item> itemsCargados;
    private MetodoPago metodoPago;
    private double subtotal;
    private final Catalogo catalogo;


    private static final Boolean SUCCESS = true;
    private static final Boolean ERROR = false;


    public Carrito(Catalogo catalogo) {
        itemsCargados = new HashMap<>();
        this.catalogo = catalogo;
    }

    public Boolean cargarProducto(Item itemPedido){
        Boolean resultado = ERROR;

        Producto productoACargar = catalogo.elegirProducto(itemPedido.getCodigoProducto());

        Item itemCargado = itemsCargados.get(itemPedido.getCodigoProducto());

        int cantACargar = itemPedido.getCantidad();

        if(itemCargado != null){
            int cantVieja = itemCargado.getCantidad();
            int cantNueva = cantVieja + cantACargar;

            if(productoACargar.getStock() >= cantNueva){
                this.subtotal += itemPedido.getSubtotal();

                itemCargado.setCantidad(cantNueva);

                resultado = SUCCESS;
            }
        }else{
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
        subtotal = 0.0;
        metodoPago = null;
    }

    private void actualizarStockProductos(){
        itemsCargados.forEach((idProducto, itemPedido) -> {
            catalogo.elegirProducto(idProducto).actualizarStock(-itemPedido.getCantidad());
        });
    }

    public HashMap<Integer, Item> getItemsCargados() {
        return itemsCargados;
    }

    public void setItemsCargados(HashMap<Integer, Item> itemsCargados) {
        this.itemsCargados = itemsCargados;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

//    public Carrito(HashMap<Integer, PedidoProducto> itemsCargados, MetodoPago metodoPago, double subtotal) {
//        this.itemsCargados = itemsCargados;
//        this.metodoPago = metodoPago;
//        this.subtotal = subtotal;
//    }

//    public Carrito enviarCarrito(){
//        HashMap<Integer, PedidoProducto> itemsCargadosTmp = this.itemsCargados;
//        MetodoPago metodoPagoTmp = this.metodoPago;
//        double subtotalTmp = this.subtotal;
//
//        actualizarStockProductos();
//
//        return new Carrito(itemsCargadosTmp, metodoPagoTmp, subtotalTmp);
//    }
}
