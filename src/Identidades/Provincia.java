
package Identidades;

public class Provincia {
    private int idprovincia;
    private String nombre;
    private String abreviatura;

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Provincia() {
    }

    public Provincia(int idprovincia, String nombre, String abreviatura) {
        this.idprovincia = idprovincia;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }
    //Creado para tener el objeto Provincia que precisa 
    //Localidad, para cargarse en los combos
    public Provincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }
    
    //Creado para tener el Objeto Provincia que precisa 
    //Direccion, para cargar la grilla
    public Provincia(int idprovincia, String nombre) {
        this.idprovincia = idprovincia;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
