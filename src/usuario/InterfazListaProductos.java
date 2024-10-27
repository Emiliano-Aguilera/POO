package usuario;

import negocio.Carrito;
import negocio.Catalogo;
import negocio.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InterfazListaProductos extends JFrame {
    private JPanel contentPane;
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

        botonPagar = new JButton("Pagar"); // Inicialización del botón

        productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcular el subtotal del carrito
                int subtotal = calcularSubtotal();

                // Abrir la ventana de método de pago como JDialog
                InterfazMetodoPago metodoPagoDialog = new InterfazMetodoPago(InterfazListaProductos.this, subtotal);
                metodoPagoDialog.setVisible(true); // Mostrar el diálogo modal
            }
        });

        contentPane = new JPanel(new BorderLayout());
        contentPane.add(productPanel, BorderLayout.CENTER);
        contentPane.add(botonPagar, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setVisible(true);
        pack();
    }

    public void mostrarProductos(){
        for (Producto producto : productos) {
            if (producto.getStock() > 0) {
                JPanel productoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel descripcionProducto = new JLabel(producto.getDescripcion());
                productoPanel.add(descripcionProducto);

                JComboBox<Integer> cantidad = new JComboBox<>();
                for (int i = 0; i <= producto.getStock(); i++) {
                    cantidad.addItem(i);
                }

                productoPanel.add(cantidad);
                productPanel.add(productoPanel);

                productosCantidad.put(producto.getCodigo(), cantidad);
            }
        }

        JScrollPane scrollPane = new JScrollPane(productPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    private int calcularSubtotal() {
        int subtotal = 0;
        for (Map.Entry<Integer, JComboBox<Integer>> entry : productosCantidad.entrySet()) {
            int cantidad = (int) entry.getValue().getSelectedItem();
            Producto producto = catalogo.elegirProducto(entry.getKey());
            if (producto != null) {
                subtotal += cantidad * producto.getPrecio();
            }
        }
        return subtotal;
    }
}

