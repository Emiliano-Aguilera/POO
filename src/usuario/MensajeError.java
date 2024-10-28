package usuario;

import javax.swing.*;

public class MensajeError extends JDialog {
    private JPanel contentPane;
    private JLabel mensaje;

    public MensajeError(JDialog parent, String mensaje){
        super(parent, "Error!", true);

        this.mensaje.setText(mensaje);

        setContentPane(contentPane);
        pack();

        setLocationRelativeTo(parent);
    }
}
