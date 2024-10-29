package usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import negocio.Catalogo;
import negocio.Carrito;
import negocio.Ventas;

public class VentanaPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton botonComprar;
    private JButton botonAgregar;
    private JPanel ventanaSeleccion;
    private JLabel header;
    private JButton botonCatalogo;
    private JButton botonVentas;


    public VentanaPrincipal(Catalogo catalogo, Carrito carrito, Ventas ventas) {
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
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazAgregarProductos ventanaAgregar = new InterfazAgregarProductos(VentanaPrincipal.this, catalogo);
                ventanaAgregar.setVisible(true);
            }
        });
        botonVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazListaVentas ventanaVentas = new InterfazListaVentas(VentanaPrincipal.this, ventas);
                ventanaVentas.setVisible(true);
            }
        });

    }
}


