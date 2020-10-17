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
public class Gestorpaciente {
 private static LinkedList<Paciente> pacientes;
 private static Connection conn;
 public Gestorpaciente(){
  Recursos.Conexion conexion=new Recursos.Conexion("Localhost", "endocare", "root", "9109");
  conn=conexion.getConexion();  
 //pacientes=new LinkedList<Paciente>();
 }

 public void RegistrarPacientes(Paciente paciente){
     
 PreparedStatement pst;
 try {
 pst = conn.prepareStatement("insert into paciente values(?,?,?,?,?,?)");
 pst.setString(1,paciente.getIdentificacion());
 pst.setString(2,paciente.getCreador());
 pst.setString(3,paciente.getNombres().toUpperCase());
 pst.setString(4,paciente.getApellidos().toUpperCase());
 pst.setString(5,paciente.getDireccion().toUpperCase());
 pst.setString(6,paciente.getTelefono());
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null,"Paciente Registrado");
 } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null,"No Registrado");
 Logger.getLogger(Gestorpaciente.class.getName()).log(Level.SEVERE, null, ex);
 }    
 //pacientes.add(paciente);
 }
 
 public LinkedList<Paciente> getPacientebyParametro(int parametro, String valor){
 LinkedList<Paciente> resultado=new LinkedList<Paciente>();
 String sql="";
 //for(Paciente pac:pacientes)
 //{
 switch(parametro){
case 1: //if(pac.getIdentificacion().equals(valor))
sql="select * from paciente where IdPaciente="+valor+";";
//resultado.add(pac);
break;
case 2: //if(pac.getNombres().equals(valor))
sql="select * from paciente where NomPaciente='"+valor+"';";
//resultado.add(pac);
break;
case 3: //if(pac.getApellidos().equals(valor))
sql="select * from paciente where ApellPaciente='"+valor+"';";
//resultado.add(pac);
break;
case 4:
    sql="select * from paciente";
 }
//}
try {
    Statement st = conn.createStatement();
    ResultSet rs=st.executeQuery(sql);
         while(rs.next()){
             resultado.add(new Paciente(rs.getString("IdPaciente"),rs.getString("IdFacturadorPac"),rs.getString("NomPaciente"),rs.getString("ApellPaciente"),rs.getString("DirPaciente"),rs.getString("TelPaciente")));
         }
 }catch(Exception e){
 JOptionPane.showMessageDialog(null, e.getMessage());
 }
 return resultado;
}
}
