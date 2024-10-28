package negocio.SistemaPago;

public class Credito implements MetodoPago{
    private final int cuotas;

    public Credito(int cuotas){
        this.cuotas = cuotas;
    }

    public double calcularTotal(double subtotal){
        return switch (cuotas) {
            case 2 -> subtotal * 1.06;
            case 3 -> subtotal * 1.12;
            case 6 -> subtotal * 1.2;
            default -> 0;
        };
    }


    public void mostrarMetodoPago() {

    }

    public int getCuotas(){
        return this.cuotas;
    }
}
