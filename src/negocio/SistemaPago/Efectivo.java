package negocio.SistemaPago;

import java.io.Serializable;

public class Efectivo implements MetodoPago, Serializable {
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
