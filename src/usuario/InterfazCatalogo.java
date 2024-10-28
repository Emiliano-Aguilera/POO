package usuario;

import negocio.Catalogo;
import negocio.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazCatalogo extends JDialog {
    private final ArrayList<Producto> productos;
    private JPanel contentPane;

    public InterfazCatalogo(JFrame parent, Catalogo catalogo){
        super(parent, "Catalogo", true);
        productos = catalogo.obtenerProductos();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        mostrarCatalogo();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        setContentPane(contentPane);

        pack();

        // La ubicacion se pone al final, para que se centre con las dimensiones finales
        setLocationRelativeTo(parent);

    }

    public void mostrarCatalogo(){
        for (Producto producto : productos) {
            JPanel productoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel codigoProducto = new JLabel(String.valueOf(producto.getCodigo()));
            JLabel descripcionProducto = new JLabel(producto.getDescripcion());
            JLabel stock = new JLabel(String.valueOf(producto.getStock()));
            JLabel stockMinimo = new JLabel(String.valueOf(producto.getStockMinimo()));
            JLabel precioProducto = new JLabel(String.valueOf(producto.getPrecio()));

            if (producto.getStock() < producto.getStockMinimo()){
                // Make background visible
                productoPanel.setOpaque(true);
                // Change to red text on yellow background
                productoPanel.setForeground(Color.RED);
                productoPanel.setBackground(Color.WHITE);
            }

            // añadir datos del producto a el panel del producto
            productoPanel.add(precioProducto);
            productoPanel.add(descripcionProducto);
            productoPanel.add(stock);
            productoPanel.add(stockMinimo);
            productoPanel.add(precioProducto);

            contentPane.add(productoPanel);
        }
    }
}
