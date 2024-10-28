package usuario;

import negocio.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class InterfazListaProductos extends JFrame {
    private JPanel contentPane;
    private JButton botonPagar;
    private final JPanel panelDeProductos;
    private final ArrayList<Producto> productos;
    private final HashMap<Integer, JComboBox<Integer>> codigosCantidad;

    public InterfazListaProductos(Catalogo catalogo, Carrito carrito) {
        this.productos = catalogo.obtenerProductos();
        this.codigosCantidad = new HashMap<>();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelDeProductos = new JPanel();
        panelDeProductos.setLayout(new BoxLayout(panelDeProductos, BoxLayout.Y_AXIS));

        contentPane.add(panelDeProductos, BorderLayout.CENTER);
        contentPane.add(botonPagar, BorderLayout.SOUTH);

        setContentPane(contentPane);

        setVisible(true);
        pack();

        // La ubicacion se pone al final, para que se centre con las dimensiones finales
        setLocationRelativeTo(null);

        botonPagar.addActionListener(_ -> {
            codigosCantidad.forEach((codigo, comboBox) -> {
                if(comboBox.getItemAt(comboBox.getSelectedIndex()) > 0) {
                    Item item = new Item(codigo, comboBox.getSelectedIndex(), catalogo);
                    carrito.cargarProducto(item);
                }
            });

            double subtotal = carrito.getSubtotal();

            resetComboBox();

            // Open payment method window
            InterfazMetodoPago metodoPagoDialog = new InterfazMetodoPago(InterfazListaProductos.this, subtotal, carrito, catalogo);
            metodoPagoDialog.setVisible(true);
        });
    }

    public void mostrarProductos(){
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

        JScrollPane scrollPane = new JScrollPane(panelDeProductos);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    public void resetComboBox(){
        codigosCantidad.forEach((codigo, comboBox) -> {
            if(comboBox.getItemAt(comboBox.getSelectedIndex()) > 0) {
                comboBox.setSelectedIndex(0);
            }
        });
    }
}

