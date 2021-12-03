
package Identidades;

public class Localidad {
    private long idlocalidad;
    private String nombre;
    private String nom_departamento;
    private Provincia provincia;

    public long getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(long idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNom_departamento() {
        return nom_departamento;
    }

    public void setNom_departamento(String nom_departamento) {
        this.nom_departamento = nom_departamento;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Localidad() {
    }

    public Localidad(long idlocalidad, String nombre, String nom_departamento, Provincia provincia) {
        this.idlocalidad = idlocalidad;
        this.nombre = nombre;
        this.nom_departamento = nom_departamento;
        this.provincia = provincia;
    }
    
    public Localidad(long idlocalidad, String nombre) {
        this.idlocalidad = idlocalidad;
        this.nombre = nombre;
    }
    
    //Creado para tener el Objeto Localidad que precisa 
    //Direccion, para cargar la grilla
    public Localidad(long idlocalidad, String nombre, String nom_departamento) {
        this.idlocalidad = idlocalidad;
        this.nombre = nombre;
        this.nom_departamento = nom_departamento;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
