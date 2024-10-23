package negocio.SistemaPago;

public class Efectivo implements MetodoPago{
    public double calcularTotal(double subtotal) {
        return subtotal * 0.9;
    }


    public void mostrarMetodoPago() {

    }
}
