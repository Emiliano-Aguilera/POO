package negocio.SistemaPago;

public interface MetodoPago {
    public double calcularTotal(double subtotal);
    public String getNombre();
}
