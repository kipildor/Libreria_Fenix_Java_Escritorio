package Identidades;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagenFondo extends JPanel{
    private Image img;
    private URL fondo;
    private ImageIcon imgLbl;//para label
    private Icon icono;//para label
    private String ruta = "";
    
//    public void PanelFondo(String ruta){
//        fondo = this.getClass().getResource(ruta);
//        //img = new ImageIcon(fondo).getImage();
//        
//    }
    
    public ImagenFondo(){
    }

    public ImagenFondo(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void paint(Graphics g) {
        img = new ImageIcon(getClass().getResource(ruta)).getImage();
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
    /**** El código de arriba *************
     * En la clase/frame que use la imagen debemos colocar:
     * 1_De manera global
     *      Panel p;
     * 
     * 2_y en el cuerpo principal
     *      Container contenedor = getContentPane();//¿Puede ir en este archivos???     
     * 
     *      p = new Panel();
     *      contenedor.add(p);
     **************************************/
    /***** El código de abajo ******************
     * En la clase/frame que tiene el label que debe llevar la imagen colocamos:
     * 1_En el cuerpo principal siendo, para este ejemplo, lblObjetivo el label que debe 
     * llevar la imagen y src/imagenes/pergamino.jpg la ruta de la imagen:
     *      this.pintarImagenEnLabel(this.lblObjetivo, "src/imagenes/pergamino.jpg");
     *******************************************/
    public void pintarImagenEnLabel(JLabel lblImg, String ruta){
        this.imgLbl = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imgLbl.getImage().getScaledInstance(
                        lblImg.getWidth(),
                        lblImg.getHeight(),
                        Image.SCALE_DEFAULT
                )
        );
        lblImg.setIcon(this.icono);
        lblImg.setOpaque(false);
        this.repaint();
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public URL getFondo() {
        return fondo;
    }

    public void setFondo(URL fondo) {
        this.fondo = fondo;
    }

    public ImageIcon getImgLbl() {
        return imgLbl;
    }

    public void setImgLbl(ImageIcon imgLbl) {
        this.imgLbl = imgLbl;
    }

    public Icon getIcono() {
        return icono;
    }

    public void setIcono(Icon icono) {
        this.icono = icono;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
