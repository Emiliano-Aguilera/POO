package negocio.SistemaPago;

public class Debito implements MetodoPago{
    private final String nombre;

    public Debito(){
        this.nombre = "Debito";
    }
    public double calcularTotal(double subtotal) {
        return subtotal;

    }

    public String getNombre() {
        return nombre;
    }
}
