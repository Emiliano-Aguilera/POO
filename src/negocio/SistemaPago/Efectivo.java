package negocio.SistemaPago;

public class Efectivo implements MetodoPago{
    int cuotas = 1;

    public double calcularTotal(double subtotal) {
        return subtotal * 0.9;
    }

    public int getCuotas(){
        return this.cuotas;
    }

}
