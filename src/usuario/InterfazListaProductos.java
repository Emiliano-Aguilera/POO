package usuario;

import negocio.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazListaProductos extends JDialog {
    private JPanel contentPane;   // Main content panel
    private JPanel productPanel;  // Panel to hold product items

    public InterfazListaProductos(JFrame parent, ArrayList<Producto> productos) {
        super(parent, "Agregar Producto", true);

        setSize(400, 300); // Set size for the new window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent); // Center the window

        // Initialize the content pane and product panel
        contentPane = new JPanel(new BorderLayout());
        productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS)); // Use BoxLayout to stack items vertically

        // Loop through the products and add available items to the panel
        for (Producto item : productos) {
            if (item.getStock() > 0) {
                // Create a panel for each product item
                JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                // Create a label for the product description
                JLabel label = new JLabel(item.getDescripcion());
                itemPanel.add(label);

                // Create a button for the product
                JButton button = new JButton("Select");
                button.addActionListener(e -> {

                });
                itemPanel.add(button);

                // Add the item panel to the main product panel
                productPanel.add(itemPanel);
            }
        }

        // Add the product panel to a JScrollPane for scrolling capabilities
        JScrollPane scrollPane = new JScrollPane(productPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER); // Add scrollPane to the center of the content pane

        setContentPane(contentPane); // Set the content pane
        setVisible(true); // Show the dialog after setting the content pane
    }
}
