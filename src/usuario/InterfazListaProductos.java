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
    private final JPanel panelDeProductos;
    private final ArrayList<Producto> productos;
    private final Catalogo catalogo;

    public InterfazListaProductos(Catalogo catalogo, Carrito carrito) {
        this.catalogo = catalogo;
        this.productos = catalogo.obtenerProductos();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelDeProductos = new JPanel();
        panelDeProductos.setLayout(new BoxLayout(panelDeProductos, BoxLayout.Y_AXIS));

        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                // Calcular el subtotal del carrito
                double subtotal = carrito.getSubtotal();

                // Abrir la ventana de método de pago como JDialog
                InterfazMetodoPago metodoPagoDialog = new InterfazMetodoPago(InterfazListaProductos.this, subtotal);
                metodoPagoDialog.setVisible(true); // Mostrar el diálogo modal
            }
        });
        contentPane.add(panelDeProductos, BorderLayout.CENTER);
        contentPane.add(botonPagar, BorderLayout.SOUTH);

        setContentPane(contentPane);

        setVisible(true);
        pack();
        // La ubicacion se pone al final, para que se centre con las dimensiones finales
        setLocationRelativeTo(null);
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
            }
        }

        JScrollPane scrollPane = new JScrollPane(panelDeProductos);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        pack();
    }

    //private double calcularSubtotal() {
    //    double subtotal = 0;
    //
    //    for (Map.Entry<Integer, JComboBox<Integer>> entry : productosCantidad.entrySet()) {
    //        int cantidad = (int) entry.getValue().getSelectedItem();
    //        Producto producto = catalogo.elegirProducto(entry.getKey());
    //        if (producto != null) {
    //            subtotal += cantidad * producto.getPrecio();
    //        }
    //    }
    //    return subtotal;
    //}
}

