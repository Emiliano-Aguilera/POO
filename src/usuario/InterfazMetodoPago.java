package usuario;

import negocio.Carrito;
import negocio.SistemaPago.Credito;
import negocio.SistemaPago.Debito;
import negocio.SistemaPago.Efectivo;
import negocio.SistemaPago.MetodoPago;

import javax.swing.*;
import java.awt.*;

public class InterfazMetodoPago extends JDialog {
    private double total;

    private JPanel botonPanel;
    private JPanel mainPanel;
    private JPanel radioPanel;
    private JPanel radioLabel;
    private JPanel contentPane;
    private JRadioButton debito;
    private JRadioButton credito;
    private JRadioButton efectivo;
    private JButton botonPagar;
    private JLabel labelSubtotal;
    private JComboBox cuotas;
    private JLabel labelTotal;

    public InterfazMetodoPago(JFrame parent, double subtotal, Carrito carrito) {
        super(parent, "Seleccione Método de Pago", true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use BorderLayout as the main layout
        setLayout(new BorderLayout(10, 10));

        labelSubtotal.setText("Subtotal: " + String.format("%.2f", subtotal));


        ButtonGroup metodoPagoGroup = new ButtonGroup();

        metodoPagoGroup.add(efectivo);
        metodoPagoGroup.add(debito);
        metodoPagoGroup.add(credito);

        add(contentPane);

        setLocationRelativeTo(parent);
        pack();
        setSize(300, 300);
        setResizable(false);

        final MetodoPago[] metodoPago = new MetodoPago[1];

        efectivo.addActionListener(e -> {
            metodoPago[0] = new Efectivo();
            total = metodoPago[0].calcularTotal(subtotal);
            this.labelTotal.setText("Total: " + String.valueOf(total));
        });
        debito.addActionListener(e -> {
            metodoPago[0] = new Debito();
            total = metodoPago[0].calcularTotal(subtotal);
            this.labelTotal.setText("Total: " + String.valueOf(total));
        });
        credito.addActionListener(e -> {
            metodoPago[0] = new Credito(Integer.parseInt((String) this.cuotas.getItemAt(this.cuotas.getSelectedIndex())));
            total = metodoPago[0].calcularTotal(subtotal);
            this.labelTotal.setText("Total: " + String.valueOf(total));
        });
        cuotas.addActionListener(e -> {
            credito.setSelected(true);
            metodoPago[0] = new Credito(Integer.parseInt((String) this.cuotas.getItemAt(this.cuotas.getSelectedIndex())));
            total = metodoPago[0].calcularTotal(subtotal);
            this.labelTotal.setText("Total: " + String.valueOf(total));
        });

        botonPagar.addActionListener(e -> {
            carrito.enviarCarrito(this.total, metodoPago[0], this.total);
            dispose();

        });
    }
}

