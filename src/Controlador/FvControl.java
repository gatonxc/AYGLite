package Controlador;

import Modelo.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 *
 * @author Julian Gato
 */
public class FvControl implements ActionListener,ItemListener {
    
 Vista.RegFvInternalFrame fvVista;
 Modelo.Fv fvModelo;
 Modelo.Gestorfv gestorfvModelo;
 Modelo.GestorRellenar rellenarModelo;
 
 public FvControl(Vista.RegFvInternalFrame fvVista){
 this.fvVista=fvVista;
 gestorfvModelo=new Modelo.Gestorfv();
 }
 
 @Override
 public void actionPerformed(ActionEvent e){
 if(e.getSource().equals(fvVista.RegistrarBtn)){
 String codigo="";
 String paciente=fvVista.jcb_paciente.getSelectedItem().toString();
 String creador=Login.usuario;
 String Cup=fvVista.jcb_cup.getSelectedItem().toString();
 String descripcion=fvVista.txt_descripcion.getText();
 String subtotal=fvVista.txt_subtotal.getText();
 String impuesto=fvVista.txt_impuesto.getText();
 String total=fvVista.txt_total.getText();

 fvModelo= new Modelo.Fv(codigo,paciente,creador,Cup, descripcion, subtotal, impuesto, total);
 gestorfvModelo.RegistrarFv(fvModelo);

 fvVista.jcb_paciente.setSelectedItem(1);
 fvVista.jcb_cup.setSelectedItem(1);
 fvVista.txt_descripcion.setText("");
 fvVista.txt_subtotal.setText("");
 fvVista.txt_impuesto.setText("");
 fvVista.txt_total.setText("");
 
 fvVista.jcb_paciente.requestFocus();
 }
 if(e.getSource().equals(fvVista.NuevoBtn)){
     
 fvVista.jcb_paciente.setSelectedItem(1);
 fvVista.jcb_cup.setSelectedItem(1);
 fvVista.txt_descripcion.setText("");
 fvVista.txt_subtotal.setText("");
 fvVista.txt_impuesto.setText("");
 fvVista.txt_total.setText("");
 

 fvVista.jcb_paciente.requestFocus();
 }
 if(e.getSource().equals(fvVista.CerrarBtn)){
     
 fvVista.jcb_paciente.setSelectedItem(1);
 fvVista.jcb_cup.setSelectedItem(1);
 fvVista.txt_descripcion.setText("");
 fvVista.txt_subtotal.setText("");
 fvVista.txt_impuesto.setText("");
 fvVista.txt_total.setText("");
 fvVista.dispose();
 }
 }
 
 @Override
 public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(fvVista.jcb_paciente)) {
            if(fvVista.jcb_paciente.getSelectedIndex()==0){
                fvVista.lbl_paciente.setText("");
            }else{
            String id=fvVista.jcb_paciente.getSelectedItem().toString();
            ArrayList<String> nompaciente= new ArrayList<String>();
            nompaciente=rellenarModelo.nom_paciente(id);
            fvVista.lbl_paciente.setText(nompaciente.get(1));
            }
        }
        if (e.getSource().equals(fvVista.jcb_cup)) {
            if(fvVista.jcb_cup.getSelectedIndex()==0){
                fvVista.lbl_cup.setText("");
            }else{
            String id=fvVista.jcb_cup.getSelectedItem().toString();
            ArrayList<String> nomcup= new ArrayList<String>();
            nomcup=rellenarModelo.nom_cup(id);
            fvVista.lbl_cup.setText(nomcup.get(1));
            }
        }
    }
    
}
