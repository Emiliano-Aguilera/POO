package negocio;

import javax.xml.catalog.CatalogManager;

public class Item {
    private int codigoProducto;
    private int cantidad;
    private double subtotal;
    Catalogo catalogo;

    public Item(int codigoProducto, int cantidad, Catalogo catalogo){
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
        this.catalogo = catalogo;
    }

    private double calcularSubtotal(){
        double precioProducto = catalogo.elegirProducto(codigoProducto).getPrecio();
        return(precioProducto * cantidad);
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
