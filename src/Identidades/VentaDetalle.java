
package Identidades;

public class VentaDetalle {
    //private int idventasdetalle;
    private Venta venta;
    private Libro libro;
    private int cantidad;
    private double preciovta;

//    public int getIdventasdetalle() {
//        return idventasdetalle;
//    }
//
//    public void setIdventasdetalle(int idventasdetalle) {
//        this.idventasdetalle = idventasdetalle;
//    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciovta() {
        return preciovta;
    }

    public void setPreciovta(double preciovta) {
        this.preciovta = preciovta;
    }

    public VentaDetalle() {
    }

//    public VentaDetalle(int idventasdetalle, Venta venta, Libro libro, int cantidad, double preciovta) {
//        this.idventasdetalle = idventasdetalle;
//        this.venta = venta;
//        this.libro = libro;
//        this.cantidad = cantidad;
//        this.preciovta = preciovta;
//    }

    public VentaDetalle(Venta venta, Libro libro, int cantidad, double preciovta) {
        this.venta = venta;
        this.libro = libro;
        this.cantidad = cantidad;
        this.preciovta = preciovta;
    }
    
    
}
