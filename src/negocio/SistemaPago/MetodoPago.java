package negocio.SistemaPago;

public interface MetodoPago {
    public double calcularTotal(double subtotal);
    public int getCuotas();

}
