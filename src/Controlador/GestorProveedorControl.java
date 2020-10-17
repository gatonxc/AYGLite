package Controlador;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian Gato
 */
public class GestorProveedorControl implements ActionListener {
    
 Modelo.Gestorproveedor proveedoresModelo;
 Vista.ConsProveedorInternalFrame consultarProveedorVista;

 public GestorProveedorControl(Vista.ConsProveedorInternalFrame consultarProveedorVista){
 this.consultarProveedorVista=consultarProveedorVista;
 proveedoresModelo=new Modelo.Gestorproveedor();
 }

 public void actionPerformed(ActionEvent e){
     
     String []Titulos = {"Identificacion","","Nombre","Direccion","Telefono"};
     DefaultTableModel tmodelo;

 if(e.getSource().equals(consultarProveedorVista.btn_buscar)){
 
 String valor=consultarProveedorVista.txt_valor.getText();
 int parametro=0;

 if(consultarProveedorVista.rdb_identificacion.isSelected()){
 parametro=1;
 }
 if(consultarProveedorVista.rdb_nombre.isSelected()){
 parametro=2;
 }
 if(consultarProveedorVista.rdb_todos.isSelected()){
  parametro=3;
 }

 
 
 
 LinkedList<Modelo.Proveedor> proveedores=proveedoresModelo.getProveedorbyParametro(parametro, valor);
 String registro[]=new String[5];

 
 

 tmodelo=new DefaultTableModel();
 tmodelo.setColumnIdentifiers(Titulos);

 for(Modelo.Proveedor p:proveedores){
 registro[0]=p.getIdentificacion();
 registro[1]=p.getCreador();
 registro[2]=p.getNombres();
 registro[3]=p.getDireccion();
 registro[4]=p.getTelefono();
 tmodelo.addRow(registro);
 }
 consultarProveedorVista.tbl_datos.setModel(tmodelo);
 consultarProveedorVista.tbl_datos.getColumnModel().getColumn(1).setMaxWidth(0);
 consultarProveedorVista.tbl_datos.getColumnModel().getColumn(1).setMinWidth(0);
 consultarProveedorVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
 consultarProveedorVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
 }
 
 if(e.getSource().equals(consultarProveedorVista.btn_cerrar)){
     tmodelo=new DefaultTableModel();
     tmodelo.setColumnIdentifiers(Titulos);
     consultarProveedorVista.tbl_datos.setModel(tmodelo);
     consultarProveedorVista.dispose();
 }
}
    
}
