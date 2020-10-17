package Controlador;

import Modelo.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Julian Gato
 */
public class FvControl implements ActionListener {
    
 Vista.RegFvInternalFrame fvVista;
 Modelo.Fv fvModelo;
 Modelo.Gestorfv gestorfvModelo;
 
 public FvControl(Vista.RegFvInternalFrame fvVista){
 this.fvVista=fvVista;
 gestorfvModelo=new Modelo.Gestorfv();
 }
 
 @Override
 public void actionPerformed(ActionEvent e){
 if(e.getSource().equals(fvVista.RegistrarBtn)){
 String codigo="";
 String paciente=fvVista.txt_paciente.getText();
 String creador=Login.usuario;
 String Cup=fvVista.txt_cup.getText();
 String descripcion=fvVista.txt_descripcion.getText();
 String subtotal=fvVista.txt_subtotal.getText();
 String impuesto=fvVista.txt_impuesto.getText();
 String total=fvVista.txt_total.getText();

 fvModelo= new Modelo.Fv(codigo,paciente,creador,Cup, descripcion, subtotal, impuesto, total);
 gestorfvModelo.RegistrarFv(fvModelo);

 fvVista.txt_paciente.setText("");
 fvVista.txt_cup.setText("");
 fvVista.txt_descripcion.setText("");
 fvVista.txt_subtotal.setText("");
 fvVista.txt_impuesto.setText("");
 fvVista.txt_total.setText("");
 
 fvVista.txt_paciente.requestFocus();
 }
 if(e.getSource().equals(fvVista.NuevoBtn)){
     
 fvVista.txt_paciente.setText("");
 fvVista.txt_cup.setText("");
 fvVista.txt_descripcion.setText("");
 fvVista.txt_subtotal.setText("");
 fvVista.txt_impuesto.setText("");
 fvVista.txt_total.setText("");
 

 fvVista.txt_paciente.requestFocus();
 }
 if(e.getSource().equals(fvVista.CerrarBtn)){
     
 fvVista.txt_paciente.setText("");
 fvVista.txt_cup.setText("");
 fvVista.txt_descripcion.setText("");
 fvVista.txt_subtotal.setText("");
 fvVista.txt_impuesto.setText("");
 fvVista.txt_total.setText("");
 fvVista.dispose();
 }
 }
    
}
