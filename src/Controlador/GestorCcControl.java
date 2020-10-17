package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian Gato
 */
public class GestorCcControl implements ActionListener  {
    
    Modelo.GestorCc ccModelo;
    Vista.ConsCcInternalFrame consultarCcVista;
    
 public GestorCcControl(Vista.ConsCcInternalFrame consultarCcVista){
 this.consultarCcVista=consultarCcVista;
 ccModelo=new Modelo.GestorCc();
 }
 
 public void actionPerformed(ActionEvent e){
     
 
 String registro[]=new String[8];
 DefaultTableModel tmodelo;

 String []Titulos = {"Codigo","","Proveedor","Factura","Descripcion","Subtotal","Impuesto","Total"};

 if(e.getSource().equals(consultarCcVista.btn_buscar)){
 
 String valor=consultarCcVista.txt_valor.getText();
 int parametro=0;

 if(consultarCcVista.rbd_identificacion.isSelected()){
 parametro=1;
 }
 if(consultarCcVista.rbd_proveedor.isSelected()){
 parametro=2;
 }
 if(consultarCcVista.rbd_factura.isSelected()){
 parametro=3;
 }
 if(consultarCcVista.rbd_todos.isSelected()){
 parametro=4;
 }
    
 
 LinkedList<Modelo.Cc> cc=ccModelo.getCcbyParametro(parametro, valor);
 

 tmodelo=new DefaultTableModel();
 tmodelo.setColumnIdentifiers(Titulos);

 for(Modelo.Cc c:cc){
 registro[0]=c.getCodigo();
 registro[1]=c.getCreador();
 registro[2]=c.getProveedor();
 registro[3]=c.getFactura();
 registro[4]=c.getDescripcion();
 registro[5]=c.getSubtotal();
 registro[6]=c.getImpuesto();
 registro[7]=c.getTotal();
 tmodelo.addRow(registro);
 }
 consultarCcVista.tbl_datos.setModel(tmodelo);
 consultarCcVista.tbl_datos.getColumnModel().getColumn(1).setMaxWidth(0);
 consultarCcVista.tbl_datos.getColumnModel().getColumn(1).setMinWidth(0);
 consultarCcVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
 consultarCcVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
 }
 
 if(e.getSource().equals(consultarCcVista.btn_cerrar)){
     
     tmodelo=new DefaultTableModel();
     tmodelo.setColumnIdentifiers(Titulos);
     consultarCcVista.tbl_datos.setModel(tmodelo);
     consultarCcVista.dispose();
 }
}
    
}
