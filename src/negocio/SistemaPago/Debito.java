package negocio.SistemaPago;

import java.io.Serializable;

public class Debito implements MetodoPago, Serializable {
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
