
package Identidades;

import java.util.*;

public class Venta {
    private int idventas;
    private long nrocomprobante;
    private Date fecha;
    private Cliente cliente;
    private double montototal;

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public long getNrocomprobante() {
        return nrocomprobante;
    }

    public void setNrocomprobante(long nrocomprobante) {
        this.nrocomprobante = nrocomprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getMontototal() {
        return montototal;
    }

    public void setMontototal(double montototal) {
        this.montototal = montototal;
    }

    public Venta() {
    }

    public Venta(int idventas, long nrocomprobante, Date fecha, Cliente cliente, double montototal) {
        this.idventas = idventas;
        this.nrocomprobante = nrocomprobante;
        this.fecha = fecha;
        this.cliente = cliente;
        this.montototal = montototal;
    }
    
    
}
