package usuario;

import negocio.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfazListaProductos extends JDialog {
    private JPanel contentPane;
    private JButton botonPagar;
    private final JPanel panelDeProductos;
    private ArrayList<Producto> productos;
    private final HashMap<Integer, JComboBox<Integer>> codigosCantidad;

    public InterfazListaProductos(JFrame parent, Catalogo catalogo, Carrito carrito) {
        super(parent, "Seleccion de Productos", true);

        this.productos = catalogo.obtenerProductos();
        this.codigosCantidad = new HashMap<>();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        panelDeProductos = new JPanel();
        panelDeProductos.setLayout(new BoxLayout(panelDeProductos, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelDeProductos);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        contentPane.add(botonPagar, BorderLayout.SOUTH);

        mostrarProductos();

        setContentPane(contentPane);

        pack();

        // La ubicacion se pone al final, para que se centre con las dimensiones finales
        setLocationRelativeTo(parent);
        botonPagar.addActionListener(_ -> {
            codigosCantidad.forEach((codigo, comboBox) -> {
                if(comboBox.getItemAt(comboBox.getSelectedIndex()) > 0) {
                    Item item = new Item(codigo, comboBox.getSelectedIndex(), catalogo);
                    carrito.cargarProducto(item);
                }
            });

            double subtotal = carrito.getSubtotal();

            // Open payment method window
            InterfazMetodoPago metodoPagoDialog = new InterfazMetodoPago(InterfazListaProductos.this,
                                                                    subtotal, carrito, catalogo);
            metodoPagoDialog.setVisible(true);

            this.productos = catalogo.obtenerProductos();
            mostrarProductos();
            pack();
        });
    }

    public void mostrarProductos(){
        panelDeProductos.removeAll();
        for (Producto producto : productos) {
            if (producto.getStock() > 0) {
                JPanel productoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel descripcionProducto = new JLabel(producto.getDescripcion());
                JLabel precioProducto = new JLabel(String.valueOf(producto.getPrecio()));

                JComboBox<Integer> cantidad = new JComboBox<>();
                for (int i = 0; i <= producto.getStock(); i++) {
                    cantidad.addItem(i);
                }
                // añadir datos del producto a el panel del producto
                productoPanel.add(descripcionProducto);
                productoPanel.add(cantidad);
                productoPanel.add(precioProducto);

                // añadir panel de producto al panel de productos
                panelDeProductos.add(productoPanel);

                codigosCantidad.put(producto.getCodigo(), cantidad);
            }
        }
    }
}

