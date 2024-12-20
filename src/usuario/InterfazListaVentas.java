package usuario;

import negocio.Catalogo;
import negocio.SistemaPago.Credito;
import negocio.Ticket;
import negocio.Ticket;
import negocio.Ventas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazListaVentas extends JDialog {
    private final ArrayList<Ticket> listaVentas;
    private JPanel contentPane;
    private JPanel panelVentas;
    private JPanel panelDeProductos;
    private JButton botonModificarStock;
    private JTextField codigoInput;
    private JTextField stockInput;
    private JLabel labelCodigo;
    private JLabel labelStock;

    public InterfazListaVentas(JFrame parent, Ventas ventas) {
        super(parent, "Ventas", true);
        this.listaVentas = ventas.getListaVentas();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        mostrarVentas();

        setContentPane(contentPane);
        
        pack();
        setLocationRelativeTo(parent);  // Centrar ventana
    }

    public void mostrarVentas() {
        // Panel para los encabezados y los listaVentas usando GridLayout
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(listaVentas.size() + 1, 5, 40, 10));

        // Encabezados
        gridPanel.add(new JLabel("ID Ticket", SwingConstants.LEFT));
        gridPanel.add(new JLabel("Fecha", SwingConstants.LEFT));
        gridPanel.add(new JLabel("Metodo Pago", SwingConstants.LEFT));
        gridPanel.add(new JLabel("Subtotal", SwingConstants.LEFT));
        gridPanel.add(new JLabel("Total", SwingConstants.LEFT));

        // Datos de listaVentas
        for (Ticket ticket : listaVentas) {
            JLabel idTicket = new JLabel(String.valueOf(ticket.getIdTicket()));
            JLabel fecha = new JLabel(String.valueOf(ticket.getFecha()));

            String stringMetodoPago = ticket.getMetodoDePago().getNombre();

            if("Credito".equals(stringMetodoPago)){
                Credito credito = (Credito) ticket.getMetodoDePago();
                stringMetodoPago += " : " + credito.getCuotas();
            }

            JLabel metodoDePago = new JLabel(stringMetodoPago);

            JLabel subtotal = new JLabel(String.valueOf(ticket.getSubtotal()));
            JLabel total = new JLabel(String.valueOf(ticket.getTotal()));

            gridPanel.add(idTicket);
            gridPanel.add(fecha);
            gridPanel.add(metodoDePago);
            gridPanel.add(subtotal);
            gridPanel.add(total);
        }

        panelVentas.add(gridPanel, BorderLayout.CENTER);
    }
}
