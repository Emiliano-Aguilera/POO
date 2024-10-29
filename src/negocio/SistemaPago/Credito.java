package negocio.SistemaPago;

import java.io.Serializable;

public class Credito implements MetodoPago, Serializable {
    private final int cuotas;

    private final String nombre;

    public Credito(int cuotas){
        this.cuotas = cuotas;
        this.nombre = "Credito";
    }

    public double calcularTotal(double subtotal){
        return switch (cuotas) {
            case 2 -> subtotal * 1.06;
            case 3 -> subtotal * 1.12;
            case 6 -> subtotal * 1.2;
            default -> 0;
        };
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuotas(){
        return this.cuotas;
    }
}
