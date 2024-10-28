package usuario;
import negocio.Catalogo;
import negocio.Producto;
import negocio.SistemaPago.Credito;
import negocio.Ticket;

import javax.swing.*;
import java.awt.*;

public class InterfazTicket extends JDialog{
    private JPanel contentPane;
    private JLabel idTicket;
    private JLabel fecha;
    private JLabel subtotal;
    private JLabel total;
    private JLabel metodoPago;
    private JPanel panelCuotas;
    private JPanel panelProductos;
    private JScrollPane scrollProductos;

    Catalogo catalogo;

    public InterfazTicket(JFrame parent, Ticket ticket, Catalogo catalogo){
        super(parent, "Ticket", true);
        this.catalogo = catalogo;

        this.idTicket.setText("ID Ticket: " + ticket.getIdTicket());
        this.fecha.setText("Fecha: " + ticket.getFecha());
        this.subtotal.setText("Subtotal: " + String.format("%.2f", ticket.getSubtotal()));
        this.metodoPago.setText("Metodo de pago: " + ticket.getMetodoDePago().getNombre());

        if(ticket.getMetodoDePago().getNombre().equals("Credito")){
            JLabel cuotas = new JLabel();
            Credito credito = (Credito) ticket.getMetodoDePago();

            cuotas.setText("Cuotas: " + credito.getCuotas());

            panelCuotas.add(cuotas);
            panelCuotas.revalidate();
        }

        this.total.setText("Total: " + String.format("%.2f", ticket.getTotal()));

        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));

        ticket.getItems().forEach((_, item) -> {
            JPanel productoPanel = new JPanel();
            productoPanel.setLayout(new FlowLayout());

            Producto producto = catalogo.elegirProducto(item.getCodigoProducto());

            JLabel descripcion = new JLabel();
            descripcion.setText(producto.getDescripcion());
            productoPanel.add(descripcion);

            JLabel precioUnidad = new JLabel();
            precioUnidad.setText(String.valueOf(producto.getPrecio()));
            productoPanel.add(precioUnidad);

            JLabel cantidad = new JLabel();
            cantidad.setText(String.valueOf(item.getCantidad()));
            productoPanel.add(cantidad);

            JLabel subtotal = new JLabel();
            subtotal.setText(String.valueOf(item.getSubtotal()));
            productoPanel.add(subtotal);

            panelProductos.add(productoPanel);
        });

        contentPane.revalidate();
        contentPane.setVisible(true);

        add(contentPane);
        pack();
        setLocationRelativeTo(parent);
    }
}