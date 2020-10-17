package Modelo;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Gato
 */
public class Gestorcups {
 private static LinkedList<Cups> cups;
 private static Connection conn;
 public Gestorcups(){
  Recursos.Conexion conexion=new Recursos.Conexion("Localhost", "endocare", "root", "9109");
  conn=conexion.getConexion();  
 
 }
 public void RegistrarCups(Cups cups){
     
 PreparedStatement pst;
  
 try {
 pst = conn.prepareStatement("insert into cod_cups values(?,?,?,?,?)");
 pst.setString(1,"0");
 pst.setString(2,cups.getCreador());
 pst.setString(3,cups.getNombre().toUpperCase());
 pst.setString(4,cups.getDescripcion().toUpperCase());
 pst.setString(5,cups.getCosto());
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Codigo Cups Registrado");
 } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null,"No Registrado");
 Logger.getLogger(Gestorcups.class.getName()).log(Level.SEVERE, null, ex);
 }    

 }
 
 public LinkedList<Cups> getCupsbyParametro(int parametro, String valor){
 LinkedList<Cups> resultado=new LinkedList<Cups>();
 String sql="";
 
 //{
 switch(parametro){
case 1: //if(pac.getIdentificacion().equals(valor))
sql="select * from cod_cups where IdCup="+valor+";";
//resultado.add(pac);
break;
case 2: //if(pac.getNombres().equals(valor))
sql="select * from cod_cups where NomCup='"+valor+"';";
//resultado.add(pac);
break;
case 3:
    sql="select * from cod_cups";
 }
//}
try {
    Statement st = conn.createStatement();
    ResultSet rs=st.executeQuery(sql);
         while(rs.next()){
             resultado.add(new Cups(rs.getString("IdCup"),rs.getString("IdContableCup"),rs.getString("NomCup"),rs.getString("DesCup"),rs.getString("CostoCup")));
         }
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e.getMessage());
 }
 return resultado;
}
    
}
