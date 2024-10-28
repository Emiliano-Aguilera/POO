package negocio;

import negocio.SistemaPago.MetodoPago;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Carrito implements Serializable {
    private HashMap<Integer, Item> itemsCargados;
    private double subtotal;
    private final Catalogo catalogo;
    private final Ventas ventas;

    public Carrito(Catalogo catalogo, Ventas ventas) {
        itemsCargados = new HashMap<>();
        this.catalogo = catalogo;
        this.ventas = ventas;
    }

    public void cargarProducto(Item itemPedido){
        Producto productoACargar = catalogo.elegirProducto(itemPedido.getCodigoProducto());

        Item itemCargado = itemsCargados.get(itemPedido.getCodigoProducto());

        int cantACargar = itemPedido.getCantidad();

        if(itemCargado != null){
            int cantVieja = itemCargado.getCantidad();
            int cantNueva = cantVieja + cantACargar;

            if(productoACargar.getStock() >= cantNueva){
                this.subtotal += itemPedido.getSubtotal();

                itemCargado.setCantidad(cantNueva);
            }
        }else{
            if(productoACargar.getStock() >= cantACargar) {
                itemsCargados.put(itemPedido.getCodigoProducto(), itemPedido);

                this.subtotal += itemPedido.getSubtotal();
            }
        }
    }

    public void eliminarProducto(Integer idItem){
        this.itemsCargados.remove(idItem);
        this.subtotal -= itemsCargados.get(idItem).getSubtotal();
    }

    public void vaciarCarrito(){
        itemsCargados.clear();
        subtotal = 0.0;
    }

    public Ticket enviarCarrito(MetodoPago metodoPago, double total){
        int idTicket = ventas.generarId();
        LocalDate fecha = LocalDate.now();
        Ticket ticket = new Ticket(idTicket, getItemsCargados(), fecha, metodoPago, this.subtotal, total);
        ventas.agregarTicket(ticket);
        actualizarStockProductos();

        return ticket;
    }

    private void actualizarStockProductos() {
        itemsCargados.forEach((idProducto, itemPedido) -> {
            Producto producto = catalogo.elegirProducto(idProducto);
            if (producto != null) {
                producto.actualizarStock(-itemPedido.getCantidad());
            } else {
                System.out.println("El producto " + idProducto + " no esta en el catalogo");
            }
        });
    }


    public HashMap<Integer, Item> getItemsCargados() {
        return itemsCargados;
    }

    public void setItemsCargados(HashMap<Integer, Item> itemsCargados) {
        this.itemsCargados = itemsCargados;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
