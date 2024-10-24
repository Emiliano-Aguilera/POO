package negocio;

import usuario.InterfazListaProductos;
import usuario.InterfazMetodoPago;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Carrito{
    private HashMap<Integer, Item> itemsCargados;
    private double subtotal;
    private final Catalogo catalogo;


    private static final boolean SUCCESS = true;
    private static final boolean ERROR = false;


    public Carrito(Catalogo catalogo) {
        itemsCargados = new HashMap<>();
        this.catalogo = catalogo;
    }

    public boolean cargarProducto(Item itemPedido){
        boolean resultado = ERROR;

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

    public void eliminarProducto(Integer idItem){
        this.itemsCargados.remove(idItem);
        this.subtotal -= itemsCargados.get(idItem).getSubtotal();
    }

    public void vaciarCarrito(){
        itemsCargados.clear();
        subtotal = 0.0;
    }

    public void enviarCarrito(HashMap<Integer, JComboBox<Integer>> productosCantidad){
        for (Map.Entry<Integer, JComboBox<Integer>> entry : productosCantidad.entrySet()) {
            Integer codigoProducto = entry.getKey(); // Access the JLabel (Product code)

            JComboBox<Integer> comboBox = entry.getValue();  // Access the JComboBox (Selected quantity)
            Integer cantidadElegida = (Integer) comboBox.getSelectedItem();  // Get the selected quantity

            Item item = new Item(codigoProducto, cantidadElegida, catalogo);

            this.cargarProducto(item);
        }


        SwingUtilities.invokeLater(() -> {
            InterfazMetodoPago metodoPago = new InterfazMetodoPago(this.getSubtotal());
            int total = metodoPago.efectuarPago();
        });
    }

    private void actualizarStockProductos() {
        itemsCargados.forEach((idProducto, itemPedido) -> {
            Producto producto = catalogo.elegirProducto(idProducto);
            if (producto != null) {
                producto.actualizarStock(-itemPedido.getCantidad());
            } else {
                System.out.println("El producto choto " + idProducto + " no ta en el catalogo negro.");
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
