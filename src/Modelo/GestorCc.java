/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Gato
 */
public class GestorCc {
    
 private static LinkedList<Cc> cc;
 private static Connection conn;
 
 public GestorCc(){
  Recursos.Conexion conexion=new Recursos.Conexion("Localhost", "endocare", "root", "9109");
  conn=conexion.getConexion();  
 
 }
 
 public void RegistrarCc(Cc cc){
     
 PreparedStatement pst;
 try {
 pst = conn.prepareStatement("insert into cuenta_cobro values(?,?,?,?,?,?,?,?)");
 pst.setString(1,"0");
 pst.setString(2,cc.getCreador());
 pst.setString(3,cc.getProveedor());
 pst.setString(4,cc.getFactura());
 pst.setString(5,cc.getDescripcion().toUpperCase());
 pst.setString(6,cc.getSubtotal());
 pst.setString(7,cc.getImpuesto());
 pst.setString(8,cc.getTotal());
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Cuenta de cobro Registrada");
 } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null,"No Registrada");
 Logger.getLogger(Gestorcups.class.getName()).log(Level.SEVERE, null, ex);
 }    

 }
 
 public LinkedList<Cc> getCcbyParametro(int parametro, String valor){
 LinkedList<Cc> resultado=new LinkedList<Cc>();
 String sql="";
 
 //{
switch(parametro){
case 1: //if(pac.getIdentificacion().equals(valor))
sql="select * from cuenta_cobro where IdCuentaCobro="+valor+";";
//resultado.add(pac);
break;
case 2: //if(pac.getNombres().equals(valor))
sql="select * from cuenta_cobro where IdProveedorCtaCobro='"+valor+"';";
//resultado.add(pac);
break;
case 3: //if(pac.getNombres().equals(valor))
sql="select * from cuenta_cobro where IdFacturaCtaCobro='"+valor+"';";
//resultado.add(pac);
break;
case 4:
    sql="select * from cuenta_cobro";
 }
//}
try {
    Statement st = conn.createStatement();
    ResultSet rs=st.executeQuery(sql);
         while(rs.next()){
             resultado.add(new Cc(rs.getString("IdCuentaCobro"),rs.getString("IdContableCtaCobro"),rs.getString("IdProveedorCtaCobro"),rs.getString("IdFacturaCtaCobro"),rs.getString("DesCtaCobro"),rs.getString("SubtotalCtaCobro"),rs.getString("ImpCtaCobro"),rs.getString("TotalCtaCobro")));
         }
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e.getMessage());
 }
 return resultado;
}
    
}
