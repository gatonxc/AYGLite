package Controlador;
import Modelo.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Julian Gato
 */
public class CupsControl implements ActionListener {
 Vista.RegcupsInternalFrame cupsVista;
 Modelo.Cups cupsModelo;
 Modelo.Gestorcups gestorcupsModelo;
 
 public CupsControl(Vista.RegcupsInternalFrame cupsVista){
 this.cupsVista=cupsVista;
 gestorcupsModelo=new Modelo.Gestorcups();
 }

 @Override
 public void actionPerformed(ActionEvent e){
 if(e.getSource().equals(cupsVista.RegistrarBtn)){
     
 String codigo="";
 String nombre=cupsVista.txt_nombre.getText();
 String descripcion=cupsVista.txt_descripcion.getText();
 String costo=cupsVista.txt_costo.getText();
 String creador=Login.usuario;
 cupsModelo= new Modelo.Cups(codigo,creador, nombre, descripcion, costo);
 gestorcupsModelo.RegistrarCups(cupsModelo);
 cupsVista.txt_nombre.setText("");
 cupsVista.txt_descripcion.setText("");
 cupsVista.txt_costo.setText("");

 cupsVista.txt_nombre.requestFocus();
 }
 if(e.getSource().equals(cupsVista.NuevoBtn)){
     
 cupsVista.txt_nombre.setText("");
 cupsVista.txt_descripcion.setText("");
 cupsVista.txt_costo.setText("");

 cupsVista.txt_nombre.requestFocus();
 }
 if(e.getSource().equals(cupsVista.CerrarBtn)){

 cupsVista.txt_nombre.setText("");
 cupsVista.txt_descripcion.setText("");
 cupsVista.txt_costo.setText("");
 cupsVista.dispose();
 }
 }
}
