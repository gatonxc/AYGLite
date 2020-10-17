package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian Gato
 */
public class GestorFvControl implements ActionListener {
    
 Modelo.Gestorfv fvModelo;
 Vista.ConsFvInternalFrame consultarFvVista;
    
 public GestorFvControl(Vista.ConsFvInternalFrame consultarFvVista){
 this.consultarFvVista=consultarFvVista;
 fvModelo=new Modelo.Gestorfv();
 }
 
 public void actionPerformed(ActionEvent e){
     
     String []Titulos = {"Factura","Paciente","","Cup","Descripcion","Subtotal","Impuesto","Total"};
     DefaultTableModel tmodelo;

 if(e.getSource().equals(consultarFvVista.btn_buscar)){
 
 String valor=consultarFvVista.txt_valor.getText();
 int parametro=0;

 if(consultarFvVista.rbd_factura.isSelected()){
 parametro=1;
 }
 if(consultarFvVista.rbd_paciente.isSelected()){
 parametro=2;
 }
 if(consultarFvVista.rbd_facturador.isSelected()){
 parametro=3;
 }
 if(consultarFvVista.rbd_todos.isSelected()){
 parametro=4;
 }
    
 
 LinkedList<Modelo.Fv> fv=fvModelo.getFvbyParametro(parametro, valor);
 String registro[]=new String[9];

 
 

 tmodelo=new DefaultTableModel();
 tmodelo.setColumnIdentifiers(Titulos);

 for(Modelo.Fv f:fv){
 registro[0]=f.getFactura();
 registro[1]=f.getCreador();
 registro[2]=f.getPaciente();
 registro[3]=f.getCup();
 registro[4]=f.getDescripcion();
 registro[5]=f.getSubtotal();
 registro[6]=f.getImpuesto();
 registro[7]=f.getTotal();
 tmodelo.addRow(registro);
 }
 consultarFvVista.tbl_datos.setModel(tmodelo);
 consultarFvVista.tbl_datos.getColumnModel().getColumn(2).setMaxWidth(0);
 consultarFvVista.tbl_datos.getColumnModel().getColumn(2).setMinWidth(0);
 consultarFvVista.tbl_datos.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(0);
 consultarFvVista.tbl_datos.getTableHeader().getColumnModel().getColumn(2).setMinWidth(0);
 }
 
 if(e.getSource().equals(consultarFvVista.btn_cerrar)){
     tmodelo=new DefaultTableModel();
     tmodelo.setColumnIdentifiers(Titulos);
     consultarFvVista.tbl_datos.setModel(tmodelo);
     consultarFvVista.dispose();
 }
}
 
 }