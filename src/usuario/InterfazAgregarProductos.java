package usuario;

import exceptions.ErrorCargaException;
import negocio.Catalogo;
import negocio.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazAgregarProductos {
    private JPanel panel1;
    private JTextField descripcion;
    private JTextField stock;
    private JTextField stockMin;
    private JTextField precio;
    private JComboBox botonAgregar;
    private Catalogo catalogo;
    public InterfazAgregarProductos(Catalogo catalogo){
        this.catalogo = catalogo;
        botonAgregar.addActionListener(_ -> {
            try {
                    agregarProducto();
                }
            catch (ErrorCargaException _) {

                }
        });
    }
    private void agregarProducto() throws ErrorCargaException {
        // Verificar si algún campo está vacío
        if (descripcion.getText().isEmpty() ||
                stock.getText().isEmpty() ||
                stockMin.getText().isEmpty() ||
                precio.getText().isEmpty()) {

            throw new ErrorCargaException();
        }
            // Capturar los datos ingresados
            String descripcionTexto = descripcion.getText();
            int stockActual = Integer.parseInt(stock.getText());
            int stockMinimo = Integer.parseInt(stockMin.getText());
            double precioProducto = Double.parseDouble(precio.getText());

            // Crear el producto y agregarlo al catálogo
            Producto producto = new Producto(catalogo.getIdItem(), descripcionTexto, stockActual, stockMinimo, precioProducto);
            catalogo.agregarProducto(producto);

            // Limpiar los campos
            limpiarCampos();

            // Mostrar mensaje de éxito
    }

    private void limpiarCampos() {
        descripcion.setText("");
        stock.setText("");
        stockMin.setText("");
        precio.setText("");
    }
}
