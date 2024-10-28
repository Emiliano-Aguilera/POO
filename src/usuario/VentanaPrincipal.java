package usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Catalogo;
import negocio.Carrito;

public class VentanaPrincipal extends Component {
    private JPanel panel1;
    private JButton botonComprar;
    private JButton botonAgregar;
    private JPanel ventanaSeleccion;
    private JLabel header;


    public VentanaPrincipal(Catalogo catalogo, Carrito carrito) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame ventanaPrincipal = new JFrame("Tienda Online");
        ventanaPrincipal.setContentPane(panel1);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.pack();
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setVisible(true);


        botonComprar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                InterfazListaProductos listaProductos = new InterfazListaProductos(catalogo, carrito);
                listaProductos.setVisible(true);
            }
        });
    }
}


