package negocio.SistemaPago;

public class Debito implements MetodoPago{
    int cuotas = 1;

    public double calcularTotal(double subtotal) {
        return subtotal;
    }

    public int getCuotas(){
        return this.cuotas;
    }

}
