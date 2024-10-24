package usuario;

import negocio.Carrito;
import negocio.Catalogo;
import negocio.Item;
import negocio.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InterfazListaProductos extends JFrame {
    private JPanel contentPane;   // Main content panel
    private JButton botonPagar;
    private JPanel productPanel;
    private ArrayList<Producto> productos;
    private Catalogo catalogo;
    private HashMap<Integer, JComboBox<Integer>> productosCantidad;
    
    
    public InterfazListaProductos(Catalogo catalogo, Carrito carrito) {
        this.catalogo = catalogo;
        this.productos = catalogo.obtenerProductos();
        this.productosCantidad = new HashMap<>();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack productos vertically


        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrito.enviarCarrito(productosCantidad);
            }
        });
        setContentPane(contentPane); // Set the content pane
        setVisible(true); // Show the dialog after setting the content pane
    }
    public void mostrarProductos(){
        // Loop through the products and add available productos to the panel
        for (Producto producto : productos) {
            if (producto.getStock() > 0) {
                // Create a panel for each product producto
                JPanel productoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                // Create a label for the product description
                JLabel descripcionProducto = new JLabel(producto.getDescripcion());
                productoPanel.add(descripcionProducto);

                // Create a button for the product
                JComboBox<Integer> cantidad = new JComboBox<>();

                for (int i = 0; i <= producto.getStock(); i++) {
                    cantidad.addItem(i);
                }

                productoPanel.add(cantidad);

                // Add the producto panel to the main product panel
                productPanel.add(productoPanel);

                productosCantidad.put(producto.getCodigo(), cantidad);
            }
        }
        // Add the product panel to a JScrollPane for scrolling capabilities
        JScrollPane scrollPane = new JScrollPane(productPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        pack();
    }
}
