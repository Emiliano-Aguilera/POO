package negocio.SistemaPago;

public class Credito implements MetodoPago{
    int cuotas;

    public Credito(int cuotas){
        this.cuotas = cuotas;
    }

    public double calcularTotal(double subtotal){
        double total = 0;

        switch (cuotas){
            case 2:
                total = subtotal * 1.06;
            case 3:
                total = subtotal * 1.12;
            case 6:
                total = subtotal * 1.2;
        }

        return total;
    }


    public void mostrarMetodoPago() {

    }

    public int getCuotas(){
        return this.cuotas;
    }
}
