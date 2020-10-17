package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Gato
 */
public class Gestorlogin {
    
 private static Connection conn;
 public Gestorlogin(){
  Recursos.Conexion conexion=new Recursos.Conexion("localhost", "endocare", "root", "9109");
  conn=conexion.getConexion(); 
 }
 
 public boolean login(int parametro,Login usr){
     
PreparedStatement pst;
ResultSet rs;
if (parametro==1){
String sql= "select IdContable,PassContable from contabilidad where IdContable = ?";
    try{
        pst=conn.prepareStatement(sql);
        pst.setString(1, usr.getUsuario());
        rs=pst.executeQuery();
        
        if(rs.next()){
            if(usr.getContraseña().equals(rs.getString(2))){
                usr.setUsuario(rs.getString(1));  
                return true;
            }else{
                return false;
            }
        }
        return false;
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,e);       
        return false;
    }
 }
 if (parametro==2){
     String sql= "select IdFacturador,PassFacturador from facturador where IdFacturador = ?";
    try{
        pst=conn.prepareStatement(sql);
        pst.setString(1, usr.getUsuario());
        rs=pst.executeQuery();
        
        if(rs.next()){
            if(usr.getContraseña().equals(rs.getString(2))){
                usr.setUsuario(rs.getString(1));  
                return true;
            }else{
                return false;
            }
        }
        return false;
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null,e);       
        return false;
    }
 }
     return false;
 }
}
