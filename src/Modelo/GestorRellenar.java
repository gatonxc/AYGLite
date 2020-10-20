package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Gato
 */
public class GestorRellenar {
    
 private static Connection conn;
    
 public GestorRellenar(){
  Recursos.Conexion conexion=new Recursos.Conexion("Localhost", "endocare", "root", "9109");
  conn=conexion.getConexion();  
 }
 
 public static ArrayList<String> llenar_facturas(){
     
     ArrayList<String> facturas= new ArrayList<String>();
     String sql="select * from factura_venta;";
     try {
     Statement st = conn.createStatement();
     ResultSet rs=st.executeQuery(sql);
     facturas.add("Seleccione una Opcion:");
         while(rs.next()){
             facturas.add(rs.getString("IdFactura"));
         }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
     return facturas;
    
}
     
 public static ArrayList<String> llenar_proveedor(){
     
     ArrayList<String> idproveedor= new ArrayList<String>();
     String sql="select * from proveedor;";
     try {
     Statement st = conn.createStatement();
     ResultSet rs=st.executeQuery(sql);
     idproveedor.add("Seleccione una Opcion:");
         while(rs.next()){
             idproveedor.add(rs.getString("IdProveedor"));
         }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
  return idproveedor;
    
}
 
  public static ArrayList<String> nom_proveedor(String id){
     
     ArrayList<String> nomproveedor= new ArrayList<String>();
     String sql="select NomProveedor from proveedor where IdProveedor="+id+";";
     try {
     Statement st = conn.createStatement();
     ResultSet rs=st.executeQuery(sql);
     nomproveedor.add("Seleccione una Opcion:");
         while(rs.next()){
             nomproveedor.add(rs.getString("NomProveedor"));
         }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
     return nomproveedor;
    
}
 
 public static ArrayList<String> llenar_cup(){
     
     ArrayList<String> cup= new ArrayList<String>();
     String sql="select * from cod_cups;";
     try {
     Statement st = conn.createStatement();
     ResultSet rs=st.executeQuery(sql);
     cup.add("Seleccione una Opcion:");
         while(rs.next()){
             cup.add(rs.getString("IdCup"));
         }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
  return cup;
    
}
 
 public static ArrayList<String> nom_cup(String id){
     
     ArrayList<String> nomcup= new ArrayList<String>();
     String sql="select NomCup from cod_cups where IdCup="+id+";";
     try {
     Statement st = conn.createStatement();
     ResultSet rs=st.executeQuery(sql);
     nomcup.add("Seleccione una Opcion:");
         while(rs.next()){
             nomcup.add(rs.getString("NomCup"));
         }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
  return nomcup;
    
}
 
 public static ArrayList<String> llenar_paciente(){
     
     ArrayList<String> paciente= new ArrayList<String>();
     String sql="select * from paciente;";
     try {
     Statement st = conn.createStatement();
     ResultSet rs=st.executeQuery(sql);
     paciente.add("Seleccione una Opcion:");
         while(rs.next()){
             paciente.add(rs.getString("IdPaciente"));
         }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
  return paciente;
    
}
 
  public static ArrayList<String> nom_paciente(String id){
     
     ArrayList<String> nompaciente= new ArrayList<String>();
     String sql="select NomPaciente from paciente where IdPaciente="+id+";";
     try {
     Statement st = conn.createStatement();
     ResultSet rs=st.executeQuery(sql);
     nompaciente.add("Seleccione una Opcion:");
         while(rs.next()){
             nompaciente.add(rs.getString("NomPaciente"));
         }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
  return nompaciente;
    
}
    
}
