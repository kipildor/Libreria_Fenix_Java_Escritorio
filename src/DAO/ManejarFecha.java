package DAO;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.*;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.JOptionPane;

public class ManejarFecha {
    
//    public Date castFechaParaBDD(Date fecha){
//        String fechaNa;
//        try {
//            SimpleDateFormat formato = new SimpleDateFormat("yyy-MM-dd");
//            fechaNa = formato.format(fecha);
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error con la fecha. (Err:"+e+")");
//            fechaNa = null;
//        }
//        Date date = Date.valueOf(fechaNa);
//        //Date.va
//        return date;
//    }
//    
//        java.util.Date utilDate = new java.util.Date();
//        System.out.println("java.util.Date is : " + utilDate);
//        java.sql.Date sqlDate = convert(utilDate);
//        System.out.println("java.sql.Date is : " + sqlDate);
//        DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
//        System.out.println("dateFormated date is : " + df.format(utilDate));
    
    public java.sql.Date fechaUtilToSql(java.util.Date fechaU) {
        java.sql.Date fechaSQL = new java.sql.Date(fechaU.getTime());
        return fechaSQL;
    }
    
//    public String formatearFechaAddMMyyyy__(LocalDate fechaOrig){
//        String patron = "dd/MM/yyyy";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(patron);
//        return fechaOrig.format(dtf);
//    }
    
    public String formatearFechaAddMMyyyy(Date fechaToConvertir) {
        String fecha = "";
        try {
            //SimpleDateFormat formatoOrigen = new SimpleDateFormat("yyyy/MM/dd");
            //String fechaOriginal = (String)(fechaToConvertir);
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
//            Date date = formatoOrigen.parse(fechaOriginal);
            //fecha = formatoSalida.format(fechaToConvertir);
            fecha = formatoSalida.format(fechaToConvertir);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "(Err:"+e+")");
        }
        return fecha;
    }
    
//    public Date ggg(){
//        String fechaNa;
//        try {
//            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//            fechaNa = formato.format(user.getFecha_nac());
//        } catch (Exception ex) {
//            System.out.println("error de Fecha" + ex);
//            fechaNa = null;
//        }
//        Date date = Date.valueOf(fechaNa);
//        
//    }
}
