package negocio;

import negocio.SistemaPago.MetodoPago;

import java.time.LocalDate;
import java.util.HashMap;

public class Ticket {
    private Integer idTicket;
    private LocalDate fecha;
    private MetodoPago metodoDePago;

    private double subtotal;
    private double total;

    private HashMap<Integer, Item> productos;

    public Ticket(Integer idTicket, HashMap<Integer, Item> productos, LocalDate fecha,
                  MetodoPago metodoDePago, double subtotal, double total){
        this.idTicket = idTicket;
        this.productos = productos;
        this.fecha = fecha;
        this.metodoDePago = metodoDePago;
        this.subtotal = subtotal;
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoPago metodoDePago) {
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
