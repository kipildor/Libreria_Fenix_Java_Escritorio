package UI;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.*;


public class ColoresDePantallas {
    Color fondoMenuVerticalIzq = new Color(0, 0, 0);//Panel de Menú, el mismo se usa para el fondo de los botones
    Color fondoEscritorio = new Color(43, 42, 51, 200);//Panel Central
    //
    Color letraBoton = new Color(255, 255, 255);
    Color fondoBotonOver = new Color(4, 41, 67);
    Color letraBotonOver = new Color(186, 150, 5);
    //
    Color fondoEncabezadoPantalla = new Color(0, 0, 255);
    Color fondoBotonXCerrar = new Color(255, 0, 0);
    Color letraBotonXCerrar = new Color(255, 255, 255);
    Color fondoBotonXCerrarOver = new Color(0, 0, 0);
    Color letraBotonXCerrarOver = new Color(255, 255, 255);
    
    //Color fondoCuerpoPantalla = new Color(87, 94, 102);
    //Color fondoCuerpoPantalla = new Color(59, 70, 81);
    Color fondoCuerpoPantalla = new Color(43, 42, 51);
    Color letraLabelPantalla = new Color(255, 255, 255);
    Color fondoLabelPantalla = fondoCuerpoPantalla;//new Color(87, 94, 102);
    Color fondoBotonPantalla = new Color(251, 195, 24);
    Color letraBotonPantalla = new Color(28, 28, 28);
    Color bordeBotonPantalla = new Color(255, 205, 34);
    //Color fondoBotonPantallaOver = new Color(13,174, 247);//Celeste
    Color fondoBotonPantallaOver = new Color(255, 14, 101);//Rosa fuerte
    Color letraBotonPantallaOver = new Color(255, 255, 255);
    Color bordeBotonPantallaOver = new Color(23, 184, 255);
    
    //Color del borde de los paneles
    Color colorBordeDePanel1 = new Color(100, 100, 255);
    Color colorBordeDePanel2 = new Color(25, 255, 25);
    
    //Color de los label invisibles para detalles al hacer click en libro
    Color fondoLabelDetalles = new Color(43, 42, 51);
    Color letraLabelDetalles = new Color(255, 255, 255);
    
    //Color de paneles de Venta
    Color fondoPanelVenta1 = new Color(69, 71, 72);
    Color fondoPanelVenta2 = new Color(20, 20, 20);
    Color bordePanelVenta1 = new Color(200, 200, 200);
    Color bordePanelVenta2 = new Color(255, 255, 255);
    Border tipoDeBordePanel1 = new EtchedBorder(bordePanelVenta1, bordePanelVenta1);
    Border tipoDeBordePanel2 = new EtchedBorder(bordePanelVenta2, bordePanelVenta2);
    
    /*****************************************
     * ***************************************
     * **************************************/
     
    //PANELES (PNL)
    public void ColorMenuVerticalIzq(JPanel pnl){
        pnl.setBackground(fondoMenuVerticalIzq);
        pnl.setOpaque(true);
    }
    
    public void ColorFondoEscritorio(JPanel pnl){
        pnl.setBackground(fondoEscritorio);
        pnl.setOpaque(true);
    }
    
    public void ColorBarraVerticalChica(JPanel pnl){
        pnl.setBackground(fondoMenuVerticalIzq);
        pnl.setOpaque(true);
    }
    
    //BOTONES DEL TIPO LABEL (LBL)
    public void ColorDeBoton(JLabel lbl){//es el mismo del fondo del panel
        lbl.setBackground(fondoMenuVerticalIzq);
        lbl.setForeground(letraBoton);
        lbl.setOpaque(true);
        //lbl.setBorder(BorderFactory.createLineBorder(Color.blue,4));
    }
    
    public void ColorDeBotonOver(JLabel lbl){
        lbl.setBackground(fondoBotonOver);
        lbl.setForeground(letraBotonOver);
        //lbl.setBorder(BorderFactory.createLineBorder(Color.PINK,4));
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    
    
    //ENCABEZADO DE LA PANTALLA
    public void ColorDeEncabezadoDePantalla(JPanel pnl){
        pnl.setBackground(fondoEncabezadoPantalla);
        pnl.setOpaque(true);
    }
    
    public void ColorDeXParaCerrar(JLabel lbl){
        lbl.setBackground(fondoBotonXCerrar);
        lbl.setForeground(letraBotonXCerrar);
        lbl.setOpaque(true);
    }
    
    public void ColorDeXParaCerrarOver(JLabel lbl){
        lbl.setBackground(fondoBotonXCerrarOver);
        lbl.setForeground(letraBotonXCerrarOver);
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    //CUERPO DE LAS PANTALLAS
    public void ColorDeCuerpoDeLaPantalla(JPanel pnl){
        pnl.setBackground(fondoCuerpoPantalla);
        pnl.setOpaque(true);
    }
    
    public void ColorDeLabelDeLaPantalla(JLabel lbl){
        lbl.setBackground(fondoLabelPantalla);
        lbl.setForeground(letraLabelPantalla);
    }
    
    public void ColorDeLabelDeLaPantalla(JRadioButton rbtn){
        rbtn.setBackground(fondoLabelPantalla);
        rbtn.setForeground(letraLabelPantalla);
    }
    
    public void ColorDeLabelDeLaPantalla(JCheckBox chk){
        chk.setBackground(fondoLabelPantalla);
        chk.setForeground(letraLabelPantalla);
    }
    
    public void ColorDeBotonLabelPantalla(JLabel lbl){
        lbl.setBackground(fondoBotonPantalla);
        lbl.setForeground(letraBotonPantalla);
        lbl.setBorder(BorderFactory.createLineBorder(bordeBotonPantalla, 2));
        lbl.setOpaque(true);
        lbl.setIconTextGap(10);
        //lbl.setBorder();
    }
    
    public void ColorDeBotonLabelPantallaOver(JLabel lbl){
        lbl.setBackground(fondoBotonPantallaOver);
        lbl.setForeground(letraBotonPantallaOver);
        lbl.setBorder(BorderFactory.createLineBorder(bordeBotonPantallaOver, 2));
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public void Color2DeBotonLabelPantalla(JLabel lbl){
        lbl.setBackground(fondoBotonPantalla);
        lbl.setForeground(letraBotonPantalla);
        lbl.setBorder(BorderFactory.createLineBorder(bordeBotonPantalla, 2));
        lbl.setOpaque(true);
        lbl.setIconTextGap(10);
        //lbl.setBorder();
    }
    
    public void Color2DeBotonLabelPantallaOver(JLabel lbl){
        lbl.setBackground(fondoBotonPantallaOver);
        lbl.setForeground(letraBotonPantallaOver);
        lbl.setBorder(BorderFactory.createLineBorder(bordeBotonPantallaOver, 2));
        lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public void BordeDePanel1(JPanel pnl){
        pnl.setBorder(BorderFactory.createLineBorder(colorBordeDePanel1, 2));
    }
    
    public void BordeDePanel2(JPanel pnl){
        pnl.setBorder(BorderFactory.createLineBorder(colorBordeDePanel2, 2));
    }
    
    //Para los label de detalles de libro
    public void ColorLabelDeDetalles(JLabel lbl){
        lbl.setBackground(fondoLabelDetalles);
        lbl.setForeground(letraLabelDetalles);
    }
    
    //Paneles de Venta
    public void ColorDePanelEncabezadoVenta(JPanel pnl){
        pnl.setBackground(fondoPanelVenta1);
        pnl.setBorder(tipoDeBordePanel1);
    }
    public void ColorDePanelesVenta(JPanel pnl){
        pnl.setBackground(fondoPanelVenta2);
        pnl.setBorder(tipoDeBordePanel2);
    }
}
