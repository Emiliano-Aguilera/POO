package negocio;


public class Item {
    private Integer codigoProducto;
    private int cantidad;
    private double subtotal;
    private Catalogo catalogo;

    public Item(Integer codigoProducto, int cantidad, Catalogo catalogo){
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.catalogo = catalogo;
        this.subtotal = calcularSubtotal();
    }

    private double calcularSubtotal(){
        double precioProducto = catalogo.elegirProducto(codigoProducto).getPrecio();
        return(precioProducto * cantidad);
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
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
