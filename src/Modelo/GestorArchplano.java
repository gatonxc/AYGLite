package Modelo;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Julian Gato
 */
public class GestorArchplano {
    
 private static Connection conn;
 
 public GestorArchplano(){
  Recursos.Conexion conexion=new Recursos.Conexion("Localhost", "endocare", "root", "9109");
  conn=conexion.getConexion();
 }
 
 public void RegistrarAp(ArchPlano ap){
     
     String CuentaDebito=ap.ctadb;
     String CuentaCredito=ap.ctacr;
     String CuentaImpuesto=ap.ctaimp;
     String Factura=ap.factura;
     String Proveedor="";
     String Codigo="";
     String Descripcion="";
     String subtotal="";
     String impuesto="";
     String total="";
     String sql="";
     
     
     sql = "select IdPacienteFactura,IdCupFactura,DesFactura,SubtotalFactura,ImpFactura,TotalFactura from factura_venta where IdFactura='"+Factura+"';";
     try {
         Statement st = conn.createStatement();
         ResultSet rs=st.executeQuery(sql);
         while(rs.next()){
             Proveedor=rs.getString("IdPacienteFactura");
             Codigo=rs.getString("IdCupFactura");
             Descripcion=rs.getString("DesFactura");
             subtotal=rs.getString("SubtotalFactura");
             impuesto=rs.getString("ImpFactura");
             total=rs.getString("TotalFactura");
         }
     } catch (SQLException ex) {
         Logger.getLogger(GestorArchplano.class.getName()).log(Level.SEVERE, null, ex);
     }
             // Se crea el libro
        Workbook workbook = new HSSFWorkbook ();

        // Se crea una hoja dentro del libro
        Sheet sheet = workbook.createSheet("Archivo Plano");


        String[] titulos = {"Cuenta","naturaleza","Factura", "Tercero","Producto","Descripcion", "Valor"};
        String[] debitos = {CuentaDebito,"Debito",Factura,Proveedor,Codigo,Descripcion,subtotal};
        String[] impuestos = {CuentaImpuesto,"Debito",Factura,Proveedor,Codigo,Descripcion,impuesto};
        String[] creditos = {CuentaCredito,"Credito",Factura,Proveedor,Codigo,Descripcion,total};
        
        // Se crea una fila dentro de la hoja
        Row fila = sheet.createRow(0);
        
        for (int i = 0; i < titulos.length; i++) {
            // Creamos una celda en esa fila, en la posicion 
            // indicada por el contador del ciclo
            Cell celda = fila.createCell(i);
            celda.setCellValue(titulos[i]);
        }
        
        fila = sheet.createRow(1);
        
        for (int i = 0; i < creditos.length; i++) {
            // Creamos una celda en esa fila, en la
            // posicion indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            celda.setCellValue(creditos[i]);
        }
        
        fila = sheet.createRow(2);
        for (int i = 0; i < debitos.length; i++) {
            // Creamos una celda en esa fila, en la
            // posicion indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            celda.setCellValue(debitos[i]);
        }
        
        if(impuesto.equals("0")){
        }else{
        fila = sheet.createRow(3);
        
        for (int i = 0; i < impuestos.length; i++) {
            // Creamos una celda en esa fila, en la
            // posicion indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            celda.setCellValue(impuestos[i]);
        }
        }
        // Se salva el libro.
        try {
        FileOutputStream out = new FileOutputStream("Factura"+Factura+".xls");
        workbook.write(out);
        out.close();
        JOptionPane.showMessageDialog(null,"factura "+Factura+" exportada exitosamente");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
 }
    
   
