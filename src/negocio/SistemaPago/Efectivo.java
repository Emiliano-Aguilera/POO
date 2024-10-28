package negocio.SistemaPago;

public class Efectivo implements MetodoPago{
    private final String nombre;

    public Efectivo(){
        this.nombre = "Efectivo";
    }

    public double calcularTotal(double subtotal) {
        return subtotal * 0.9;
    }

    public String getNombre() {
        return nombre;
    }
}
