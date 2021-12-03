package UI;

import java.awt.Image;
import java.awt.Toolkit;

public class Imagenes {
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Images/LogoSoloCuadrado_64x64.png"));
        return retValue;
    }
    
//    public void imagenEnBarra(){
//        setIconImage(getIconImage());
//    }
}
