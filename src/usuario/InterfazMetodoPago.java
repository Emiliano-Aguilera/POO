package usuario;

import javax.swing.*;
import java.awt.*;

public class InterfazMetodoPago extends JDialog {
    private double subtotal;
    private JRadioButton efectivo;
    private JRadioButton debito;
    private JRadioButton credito;
    private JButton confirmarPago;

    public InterfazMetodoPago(JFrame parent, double subtotal) {
        super(parent, "Seleccione Método de Pago", true);  // Configuración de JDialog modal
        this.subtotal = subtotal;

        setSize(300, 200);
        setLayout(new GridLayout(4, 1));

        confirmarPago = new JButton("Confirmar Pago");

        // Agrupar los botones de opción
        ButtonGroup metodoPagoGroup = new ButtonGroup();
        metodoPagoGroup.add(efectivo);
        metodoPagoGroup.add(debito);
        metodoPagoGroup.add(credito);

        // Añadir componentes a la ventana
        add(efectivo);
        add(debito);
        add(credito);
        add(confirmarPago);

        confirmarPago.addActionListener(e -> {
            // Aquí puedes añadir la lógica para confirmar el pago
            dispose();  // Cerrar el diálogo después de confirmar el pago
        });

        setLocationRelativeTo(parent); // Centrar el diálogo sobre la ventana principal
    }
}

