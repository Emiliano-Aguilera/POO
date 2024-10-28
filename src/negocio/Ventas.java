package negocio;

import java.util.HashMap;

public class Ventas {
    private final HashMap<Integer, Ticket> ventas;
    private int idTicket;

    public Ventas(){
        ventas = new HashMap<>();
        idTicket = 0;
    }

    public HashMap<Integer, Ticket> getVentas() {
        return ventas;
    }

    public void agregarTicket(Ticket ticket){
        ventas.put(ticket.getIdTicket(), ticket);
    }

    public int generarId(){
        return idTicket++;
    }
}
