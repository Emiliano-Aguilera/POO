package negocio;

import java.util.HashMap;

public class Ventas {
    private HashMap<Integer, Ticket> ventas;

    public Ventas(){
        ventas = new HashMap<>();
    }
    public HashMap<Integer, Ticket> getVentas() {
        return ventas;
    }
}
