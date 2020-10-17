package Recursos;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Julian Gato
 */
public class Conexion {
private String driver,url, ip, bd, usr,pass;
public Connection conexion;
public Conexion(String ip, String bd, String usr,String pass){
 driver="com.mysql.jdbc.Driver";
 this.bd=bd;
 this.usr=usr;
 this.pass=pass;
 this.ip=ip;
 url="jdbc:mysql://"+ip+":3306/"+bd;
 try{
 Class.forName(driver).newInstance();
 conexion=DriverManager.getConnection(url,usr,pass);
 }catch(Exception ex){
 JOptionPane.showMessageDialog(null,"Error de conexion a la base de datos "+ex);
 System.exit(0);
 }
}
public Connection getConexion(){
 return conexion;
}
public Connection CerrarConexion() throws SQLException{
 conexion.close();
 conexion=null;
 return conexion;
}
}