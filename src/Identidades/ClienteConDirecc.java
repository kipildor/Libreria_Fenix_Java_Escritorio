package Identidades;

public class ClienteConDirecc extends Cliente {
    private Direccion direccion;

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public ClienteConDirecc(Direccion direccion) {
        this.direccion = direccion;
    }

    public ClienteConDirecc(int idcliente, TipoDocumento tipodocumento, long nrodocumento, String razonsocial, String email, boolean borrado, Direccion direccion) {
        super(idcliente, tipodocumento, nrodocumento, razonsocial, email, borrado);
        this.direccion = direccion;
    }

    public ClienteConDirecc() {
    }
    
    
}
