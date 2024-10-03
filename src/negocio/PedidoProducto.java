package negocio;

public class PedidoProducto {
    private int idPedido;
    private int codigoProducto;
    private int cantidad;
    private double subtotal;

    public PedidoProducto(int idPedido, int codigoProducto, int cantidad){
        this.idPedido = idPedido;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }

    private double calcularSubtotal(){
        Catalogo catalogo = Catalogo.obtenerInstancia();

        double precioProducto = catalogo.elegirProducto(codigoProducto).getPrecio();

        return(precioProducto * cantidad);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
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
