package libreria001;

import DAO.LibroDAO;
import Identidades.*;
import UI.LoginUI;

public class Libreria001 {

    
    public static void main(String[] args) {
        /*
        Usuario usu = new Usuario(0, "Leandro", "1234");
        
        System.out.println("Nombre: " + usu.getNombre() +"\nContraseña: " + usu.getContrasenia());
        
        TipoDocumento tipod_cli_01 = new TipoDocumento(96, "DNI");
        Cliente cli = new Cliente(1, tipod_cli_01, 23456789, "Kamisama", "kamisama@aol.com", false);
        
        System.out.println("Cliente "+cli.getRazonsocial()+"\nDocumento: "+cli.getTipodocumento().getDescripcion()+" "+cli.getNrodocumento()+
                "\nE-mail: "+cli.getEmail());
    
        System.out.println("\n************************\n");
        Provincia pro_1 = new Provincia(6, "Capital Federal", "CABA");
        Localidad loc_1 = new Localidad(13654, "Mataderos", "comuna 2", pro_1);
        Direccion dir_1 = new Direccion(23456790, "Murgiondo", 505, 0, "A", loc_1, pro_1);
        
        System.out.println("Dirección:\nCalle: "+dir_1.getCalle()+"\nNúmero: "+dir_1.getNumero()+
                "\nLocalidad: "+dir_1.getLocalidad().getNombre()+", "+dir_1.getProvincia().getNombre());
        */
        
        LoginUI log = new LoginUI();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        /*
        LibroDAO liDAO = new LibroDAO();
        Libro li = new Libro();
        li = liDAO.GetLibroByID(1);
        */
    }
    
}
