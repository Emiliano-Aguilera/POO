package negocio;

import java.util.HashMap;

public class Ventas {
    HashMap<Integer, Ticket> ventas = new HashMap<>();

    public HashMap<Integer, Ticket> getVentas() {
        return ventas;
    }
}
