package usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Catalogo;
import negocio.Carrito;

public class VentanaPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton botonComprar;
    private JButton botonAgregar;
    private JPanel ventanaSeleccion;
    private JLabel header;
    private JButton botonCatalogo;


    public VentanaPrincipal(Catalogo catalogo, Carrito carrito) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setContentPane(contentPane);

        pack();
        setLocationRelativeTo(null);

        botonComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InterfazListaProductos listaProductos = new InterfazListaProductos(VentanaPrincipal.this,
                        catalogo, carrito);
                listaProductos.setVisible(true);
            }
        });
        botonCatalogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazCatalogo ventanaCatalogo = new InterfazCatalogo(VentanaPrincipal.this, catalogo);
                ventanaCatalogo.setVisible(true);
            }
        });
    }
}


