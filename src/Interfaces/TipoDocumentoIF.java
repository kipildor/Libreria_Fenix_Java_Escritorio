
package Interfaces;

import Identidades.TipoDocumento;
import java.util.*;

public interface TipoDocumentoIF {
    
    public LinkedList<TipoDocumento> GetAllTipoDocumento();
    
    public TipoDocumento GetTipoDocumentoByID(int id);
    
    public boolean ExisteElID(int id);
    
    public int AgregarTipoDocumento(TipoDocumento tipo);
    
    public int ActualizarTipoDocumento(TipoDocumento tipo);
    
    public int ActualizarTipoDocumento(TipoDocumento tipo, int idAnt);
    
    public int BorrarTipoDocumento(int id);
    
       
}
