package negocio;

import java.util.HashMap;

public class Ventas {
    private final HashMap<Integer, Ticket> ventas;

    public Ventas(){
        ventas = new HashMap<>();
    }

    public HashMap<Integer, Ticket> getVentas() {
        return ventas;
    }

    public void agregarTicket(Ticket ticket){
        ventas.put(ticket.getIdTicket(), ticket);
    }
}
