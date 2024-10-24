package usuario;

import javax.swing.*;

public class InterfazMetodoPago extends JFrame {
    int subtotal;
    private JRadioButton efectivo;
    private JRadioButton debito;
    private JRadioButton credito;

    public void InterfazListaProductos(int subtotal){
        this.subtotal = subtotal;
    }
}
