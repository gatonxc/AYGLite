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

public class Gestorfv {
    
 private static LinkedList<Fv> fv;
 private static Connection conn;
 
 public Gestorfv(){
  Recursos.Conexion conexion=new Recursos.Conexion("Localhost", "endocare", "root", "9109");
  conn=conexion.getConexion();  
 
 }
 
 public void RegistrarFv(Fv fv){
     
 PreparedStatement pst;
 try {
 pst = conn.prepareStatement("insert into factura_venta values(?,?,?,?,?,?,?,?)");
 pst.setString(1,"0");
 pst.setString(2,fv.getPaciente());
 pst.setString(3,fv.getCreador());
 pst.setString(4,fv.getCup());
 pst.setString(5,fv.getDescripcion().toUpperCase());
 pst.setString(6,fv.getSubtotal());
 pst.setString(7,fv.getImpuesto());
 pst.setString(8,fv.getTotal());
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Factura de venta Registrada");
 } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null,"No Registrada");
 Logger.getLogger(Gestorcups.class.getName()).log(Level.SEVERE, null, ex);
 }    

 }
 
 public LinkedList<Fv> getFvbyParametro(int parametro, String valor){
 LinkedList<Fv> resultado=new LinkedList<Fv>();
 String sql="";
 
 //{
switch(parametro){
case 1: //if(pac.getIdentificacion().equals(valor))
sql="select * from factura_venta where IdFactura="+valor+";";
//resultado.add(pac);
break;
case 2: //if(pac.getNombres().equals(valor))
sql="select * from factura_venta where IdPacienteFactura='"+valor+"';";
//resultado.add(pac);
break;
case 3: //if(pac.getNombres().equals(valor))
sql="select * from factura_venta where IdFacturadorFactura='"+valor+"';";
//resultado.add(pac);
break;
case 4:
    sql="select * from factura_venta";
 }
//}
try {
    Statement st = conn.createStatement();
    ResultSet rs=st.executeQuery(sql);
         while(rs.next()){
             resultado.add(new Fv(rs.getString("IdFactura"),rs.getString("IdPacienteFactura"),rs.getString("IdFacturadorFactura"),rs.getString("IdCupFactura"),rs.getString("DesFactura"),rs.getString("SubtotalFactura"),rs.getString("ImpFactura"),rs.getString("TotalFactura")));
         }
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e.getMessage());
 }
 return resultado;
}
    
}
