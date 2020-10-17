package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Julian Gato
 */
public class GestorCupsControl implements ActionListener {
    
    Modelo.Gestorcups cupsModelo;
    Vista.ConsCupsInternalFrame consultarCupsVista;
    
 public GestorCupsControl(Vista.ConsCupsInternalFrame consultarCupsVista){
 this.consultarCupsVista=consultarCupsVista;
 cupsModelo=new Modelo.Gestorcups();
 }

 public void actionPerformed(ActionEvent e){
     
     String []Titulos = {"Codigo","","Nombre","Descripcion","Costo"};
     DefaultTableModel tmodelo;

 if(e.getSource().equals(consultarCupsVista.btn_buscar)){
 
 String valor=consultarCupsVista.txt_valor.getText();
 int parametro=0;

 if(consultarCupsVista.rdb_identificacion.isSelected()){
 parametro=1;
 }
 if(consultarCupsVista.rdb_nombre.isSelected()){
 parametro=2;
 }
 if(consultarCupsVista.rdb_todos.isSelected()){
 parametro=3;
 }
    
 
 LinkedList<Modelo.Cups> cups=cupsModelo.getCupsbyParametro(parametro, valor);
 String registro[]=new String[5];

 
 

 tmodelo=new DefaultTableModel();
 tmodelo.setColumnIdentifiers(Titulos);

 for(Modelo.Cups c:cups){
 registro[0]=c.getCodigo();
 registro[1]=c.getCreador();
 registro[2]=c.getNombre();
 registro[3]=c.getDescripcion();
 registro[4]=c.getCosto();
 tmodelo.addRow(registro);
 }
 consultarCupsVista.tbl_datos.setModel(tmodelo);
 consultarCupsVista.tbl_datos.getColumnModel().getColumn(1).setMaxWidth(0);
 consultarCupsVista.tbl_datos.getColumnModel().getColumn(1).setMinWidth(0);
 consultarCupsVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
 consultarCupsVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
 }
 
 if(e.getSource().equals(consultarCupsVista.btn_cerrar)){
     tmodelo=new DefaultTableModel();
     tmodelo.setColumnIdentifiers(Titulos);
     consultarCupsVista.tbl_datos.setModel(tmodelo);
     consultarCupsVista.dispose();
 }
}
 }
