package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import datos.*;

public class Ventas implements Serializable {
    private final HashMap<Integer, Ticket> ventas;
    private int idTicket;

    public Ventas(){
        ventas = new HashMap<>();
        idTicket = 0;
    }

    public HashMap<Integer, Ticket> getVentas() {
        return ventas;
    }

    public ArrayList<Ticket> getListaVentas(){
        return new ArrayList<>(ventas.values());
    }

    public void agregarTicket(Ticket ticket){
        ventas.put(ticket.getIdTicket(), ticket);
    }

    public int generarId(){
        return idTicket++;
    }

    public static Ventas recuperarse(){
        Ventas ventas=(Ventas)DatosVentas.recuperar();
        if(ventas == null)
            ventas = new Ventas();
        return ventas;
    }

    public boolean guardarse(){
        return DatosVentas.guardar(this);
    }
}
