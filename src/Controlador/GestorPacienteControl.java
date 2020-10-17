package Controlador;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Julian Gato
 */
public class GestorPacienteControl implements ActionListener {
    
    

 Modelo.Gestorpaciente pacientesModelo;
 Vista.ConsPacienteInternalFrame consultarPacienteVista;

 public GestorPacienteControl(Vista.ConsPacienteInternalFrame consultarPacienteVista){
 this.consultarPacienteVista=consultarPacienteVista;
 pacientesModelo=new Modelo.Gestorpaciente();
 }

 public void actionPerformed(ActionEvent e){
     
     String []Titulos = {"Identificacion","","Nombre","Apellidos","Direccion","Telefono"};
     DefaultTableModel tmodelo;

 if(e.getSource().equals(consultarPacienteVista.btn_buscar)){
 
 String valor=consultarPacienteVista.txt_valor.getText();
 int parametro=0;

 if(consultarPacienteVista.rdb_identificacion.isSelected()){
 parametro=1;
 }
 if(consultarPacienteVista.rdb_nombres.isSelected()){
 parametro=2;
 }
 if(consultarPacienteVista.rdb_apellidos.isSelected()){
 parametro=3;
 }
 if(consultarPacienteVista.rdb_todos.isSelected()){
 parametro=4;
 }
 
 
 LinkedList<Modelo.Paciente> pacientes=pacientesModelo.getPacientebyParametro(parametro, valor);
 String registro[]=new String[6];

 
 

 tmodelo=new DefaultTableModel();
 tmodelo.setColumnIdentifiers(Titulos);

 for(Modelo.Paciente p:pacientes){
 registro[0]=p.getIdentificacion();
 registro[2]=p.getNombres();
 registro[3]=p.getApellidos();
 registro[4]=p.getDireccion();
 registro[5]=p.getTelefono();
 tmodelo.addRow(registro);
 }
 consultarPacienteVista.tbl_datos.setModel(tmodelo);
 consultarPacienteVista.tbl_datos.getColumnModel().getColumn(1).setMaxWidth(0);
 consultarPacienteVista.tbl_datos.getColumnModel().getColumn(1).setMinWidth(0);
 consultarPacienteVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
 consultarPacienteVista.tbl_datos.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
 }
 
 if(e.getSource().equals(consultarPacienteVista.btn_cerrar)){
     tmodelo=new DefaultTableModel();
     tmodelo.setColumnIdentifiers(Titulos);
     consultarPacienteVista.tbl_datos.setModel(tmodelo);
     consultarPacienteVista.dispose();
 }
}
}