package Interfaces;

import Identidades.Tema;
import java.util.*;

public interface TemaIF {
    
    public int AddTema(Tema tema);
    
    public LinkedList<Tema> GetAllTemas();
    
    public Tema GetTemaByID(int id);
    
    public int ModificarTema(Tema tema);
    
    public int BorrarTema(int id);
}
