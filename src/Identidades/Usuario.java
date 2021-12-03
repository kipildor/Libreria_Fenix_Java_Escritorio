
package Identidades;

public class Usuario {
    private int idusuario;
    private String nombre;
    private String contrasenia;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario(){
        
    }
    
    public Usuario(int idusuario, String nombre, String contrasenia) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }



}
