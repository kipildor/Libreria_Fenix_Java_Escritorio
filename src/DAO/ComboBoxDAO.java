package DAO;

import Identidades.Tema;
import javax.swing.JComboBox;

public class ComboBoxDAO {
    
    public void TemaSetSelectItemByCampo(int idT, JComboBox<Tema> cmbFiltrarTema) {
        int itemsDelCombo = cmbFiltrarTema.getItemCount();
        for (int i = 0; i < itemsDelCombo; i++) {
            if((((Tema)cmbFiltrarTema.getItemAt(i)).getIdtema()) == idT){
                cmbFiltrarTema.setSelectedIndex(i);
                break;
            }
        }
        //return;
    }
    
    public void TemaSetSelectItemByCampo(JComboBox<Tema> cmb){
        
    }
}
