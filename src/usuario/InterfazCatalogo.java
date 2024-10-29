package usuario;

import negocio.Catalogo;
import negocio.Producto;
import negocio.SistemaPago.MetodoPago;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazCatalogo extends JDialog {
    private final ArrayList<Producto> productos;
    private JPanel contentPane;
    private JPanel panelDeProductos;
    private JButton botonModificarStock;
    private JTextField codigoInput;
    private JTextField stockInput;
    private JLabel labelCodigo;
    private JLabel labelStock;
    private JPanel scrollProductos;

    public InterfazCatalogo(JFrame parent, Catalogo catalogo) {
        super(parent, "Catálogo", true);
        productos = catalogo.obtenerProductos();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        mostrarCatalogo();

        botonModificarStock.addActionListener(_ -> {
            try {
                Producto producto = catalogo.elegirProducto(Integer.valueOf(codigoInput.getText()));
                int nuevoStock = Integer.parseInt(stockInput.getText());
                if(nuevoStock >= 0) {
                    catalogo.cambiarStock(producto.getCodigo(), nuevoStock);
                    mostrarCatalogo();
                    pack();
                    Mensaje mensaje = new Mensaje(InterfazCatalogo.this, "Stock actualizado satisfactoriamente.");
                    mensaje.setVisible(true);
                }else{
                    Mensaje error = new Mensaje(InterfazCatalogo.this, "El stock no puede ser negativo.");
                    error.setVisible(true);
                }
            }
            catch (Exception e){
                Mensaje error = new Mensaje(InterfazCatalogo.this, "Ingrese correctamente Codigo y Stock.");
                error.setVisible(true);
            }
        });

        setContentPane(contentPane);


        pack();
        setLocationRelativeTo(parent);  // Centrar ventana

    }

    public void mostrarCatalogo() {
        // Panel para los encabezados y los productos usando GridLayout
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(productos.size() + 1, 5, 10, 10));

        // Encabezados
        gridPanel.add(new JLabel("Código", SwingConstants.CENTER));
        gridPanel.add(new JLabel("Desc.", SwingConstants.CENTER));
        gridPanel.add(new JLabel("Stock", SwingConstants.CENTER));
        gridPanel.add(new JLabel("Stock Min.", SwingConstants.CENTER));
        gridPanel.add(new JLabel("Precio", SwingConstants.CENTER));

        // Datos de productos
        for (Producto producto : productos) {
            JLabel codigoProducto = new JLabel(String.valueOf(producto.getCodigo()), SwingConstants.CENTER);
            JLabel descripcionProducto = new JLabel(producto.getDescripcion(), SwingConstants.CENTER);
            JLabel stock = new JLabel(String.valueOf(producto.getStock()), SwingConstants.CENTER);
            JLabel stockMinimo = new JLabel(String.valueOf(producto.getStockMinimo()), SwingConstants.CENTER);
            JLabel precioProducto = new JLabel(String.valueOf(producto.getPrecio()), SwingConstants.CENTER);

            // Cambiar color si el stock es menor que el mínimo
            if (producto.getStock() < producto.getStockMinimo()) {
                codigoProducto.setForeground(Color.RED);
                descripcionProducto.setForeground(Color.RED);
                stock.setForeground(Color.RED);
                stockMinimo.setForeground(Color.RED);
                precioProducto.setForeground(Color.RED);
            }

            gridPanel.add(codigoProducto);
            gridPanel.add(descripcionProducto);
            gridPanel.add(stock);
            gridPanel.add(stockMinimo);
            gridPanel.add(precioProducto);
        }

        panelDeProductos.add(gridPanel, BorderLayout.CENTER);
    }
}

