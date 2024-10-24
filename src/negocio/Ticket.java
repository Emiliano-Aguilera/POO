package negocio;

import java.util.HashMap;

public class Ticket {
    private Integer idTicket;
    private int fecha;
    private int metodoDePago;

    private double subtotal;
    private double total;

    private HashMap<Integer, Item> productos;

    public Ticket(Integer idTicket, HashMap<Integer, Item> productos, int fecha,
                  int metodoDePago, double subtotal, double total){
        this.idTicket = idTicket;
        this.productos = productos;
        this.fecha = fecha;
        this.metodoDePago = metodoDePago;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(int metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public HashMap<Integer, Item> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Integer, Item> productos) {
        this.productos = productos;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }
}
