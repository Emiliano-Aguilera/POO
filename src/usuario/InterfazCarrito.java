package usuario;

import negocio.Carrito;
import negocio.Catalogo;
import negocio.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class InterfazCarrito extends JFrame {
    private JPanel contentPane;
    private JLabel Titulo;
    private JButton botonAgregar;
    private Catalogo catalogo;

    public InterfazCarrito(Catalogo catalogo) {
        this.catalogo = catalogo;
        setTitle("TPOPOO");
        setLookAndFeel();
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        setVisible(true);

        centrarVentana(this);

        // Add action listener to the button
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the button is clicked
                accionBotonAgregar();
            }
        });
    }

    private void centrarVentana(JFrame frame) {
        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the new x and y coordinates for the center of the screen
        int x = (screenSize.width - frame.getPreferredSize().width) / 2;
        int y = (screenSize.height - frame.getPreferredSize().height) / 2;

        // Set the location of the frame
        frame.setLocation(x, y);
    }


    private void accionBotonAgregar() {
        InterfazListaProductos listaProductos = new InterfazListaProductos(this,
                catalogo.obtenerProductos());
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
