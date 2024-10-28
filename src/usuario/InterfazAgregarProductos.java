package usuario;

import exceptions.ErrorCargaException;
import negocio.Catalogo;
import negocio.Producto;

import javax.swing.*;

public class InterfazAgregarProductos extends JDialog {
    private JPanel contentPane;
    private JButton botonAgregar;
    private JTextField descripcion;
    private JTextField stock;
    private JTextField stockMin;
    private JTextField precio;
    private Catalogo catalogo;
    public InterfazAgregarProductos(JFrame parent ,Catalogo catalogo){
        super(parent, "Agregar Productos", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setContentPane(contentPane);
        this.catalogo = catalogo;
        botonAgregar.addActionListener(_ -> {
            try {
                agregarProducto();
                Mensaje mensaje = new Mensaje(InterfazAgregarProductos.this,"Se cargo correctamente el producto");
                mensaje.setVisible(true);
            }
            catch (ErrorCargaException _) {
                Mensaje error = new Mensaje(InterfazAgregarProductos.this,"No se cargo correctamente el producto");
                error.setVisible(true);
            }
        });
        pack();
        setLocationRelativeTo(parent);

    }
    private void agregarProducto() throws ErrorCargaException {
        try {
            String descripcionTexto = descripcion.getText();
            int stockActual = Integer.parseInt(stock.getText());
            int stockMinimo = Integer.parseInt(stockMin.getText());
            double precioProducto = Double.parseDouble(precio.getText());

            // Crear el producto y agregarlo al catálogo
            Producto producto = new Producto(catalogo.getIdItem(), descripcionTexto, stockActual, stockMinimo, precioProducto);
            catalogo.agregarProducto(producto);

            // Limpiar los campos
            limpiarCampos();
        }
        catch (NullPointerException _) {
            throw new ErrorCargaException();
        }

    }

    private void limpiarCampos() {
        descripcion.setText("");
        stock.setText("");
        stockMin.setText("");
        precio.setText("");
    }
}

