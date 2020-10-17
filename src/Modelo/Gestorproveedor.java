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
public class Gestorproveedor {
    
 private static LinkedList<Proveedor> proveedor;
 private static Connection conn;
 public Gestorproveedor(){
  Recursos.Conexion conexion=new Recursos.Conexion("Localhost", "endocare", "root", "9109");
  conn=conexion.getConexion();  
 //pacientes=new LinkedList<Paciente>();
 }

 public void RegistrarProveedor(Proveedor proveedor){
     
 PreparedStatement pst;
 try {
 pst = conn.prepareStatement("insert into proveedor values(?,?,?,?,?)");
 pst.setString(1,proveedor.getIdentificacion());
 pst.setString(2,proveedor.getCreador());
 pst.setString(3,proveedor.getNombres().toUpperCase());
 pst.setString(4,proveedor.getDireccion().toUpperCase());
 pst.setString(5,proveedor.getTelefono());
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Proveedor Registrado");
 } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null,"No Registrado");
 Logger.getLogger(Gestorproveedor.class.getName()).log(Level.SEVERE, null, ex);
 }    
 //pacientes.add(paciente);
 }
 
 public LinkedList<Proveedor> getProveedorbyParametro(int parametro, String valor){
 LinkedList<Proveedor> resultado=new LinkedList<Proveedor>();
 String sql="";
 //for(Paciente pac:pacientes)
 //{
 switch(parametro){
case 1: //if(pac.getIdentificacion().equals(valor))
sql="select * from proveedor where IdProveedor="+valor+";";
//resultado.add(pac);
break;
case 2: //if(pac.getNombres().equals(valor))
sql="select * from proveedor where NomProveedor='"+valor+"';";
//resultado.add(pac);
break;
case 3:
    sql="select * from proveedor";
 }
//}
try {
    Statement st = conn.createStatement();
    ResultSet rs=st.executeQuery(sql);
         while(rs.next()){
             resultado.add(new Proveedor(rs.getString("IdProveedor"),rs.getString("IdContableProveedor"),rs.getString("NomProveedor"),rs.getString("DirProveedor"),rs.getString("TelProveedor")));
         }
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e.getMessage());
 }
 return resultado;
}
    
}
