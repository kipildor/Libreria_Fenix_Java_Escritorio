
package Identidades;

public class Cliente {
    private int idcliente;
    private TipoDocumento tipodocumento;
    private long nrodocumento;
    private String razonsocial;
    private String email;
    private boolean borrado;

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public long getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(long nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Cliente() {
    }

    public Cliente(int idcliente, TipoDocumento tipodocumento, long nrodocumento, String razonsocial, String email, boolean borrado) {
        this.idcliente = idcliente;
        this.tipodocumento = tipodocumento;
        this.nrodocumento = nrodocumento;
        this.razonsocial = razonsocial;
        this.email = email;
        this.borrado = borrado;
    }
    
    
    
}
