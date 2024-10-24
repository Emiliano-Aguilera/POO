package negocio;

public class Producto {
    private Integer codigo;
    private String descripcion;
    private int stock;
    private int stockMinimo;
    private double precio;

    public Producto(Integer codigo, String descripcion, int stock, int stockMinimo, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.precio = precio;
    }

    public void actualizarStock(int cantidad){
        this.stock += cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }
}
