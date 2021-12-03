
package Identidades;

public class Direccion {
    private long iddireccion;
    private String calle;
    private int numero;
    private int piso;
    private String departamento;
    private Localidad localidad;
    private Provincia provincia;

    public long getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(long iddireccion) {
        this.iddireccion = iddireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Direccion() {
    }

    public Direccion(long iddireccion, String calle, int numero, int piso, String departamento, Localidad localidad, Provincia provincia) {
        this.iddireccion = iddireccion;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.departamento = departamento;
        this.localidad = localidad;
        this.provincia = provincia;
    }
    
    
}
