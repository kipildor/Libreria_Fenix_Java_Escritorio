
package Identidades;

public class TipoDocumento {
    private int idtipodocumento;
    private String descripcion;

    public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDocumento() {
    }

    public TipoDocumento(int idtipodocumento, String descripcion) {
        this.idtipodocumento = idtipodocumento;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
}
