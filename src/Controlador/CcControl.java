package Controlador;

import Modelo.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Julian Gato
 */
public class CcControl implements ActionListener {
    
 Vista.RegCcInternalFrame ccVista;
 Modelo.Cc ccModelo;
 Modelo.GestorCc gestorccModelo;
 
 public CcControl(Vista.RegCcInternalFrame ccVista){
 this.ccVista=ccVista;
 gestorccModelo=new Modelo.GestorCc();
 }

 @Override
 public void actionPerformed(ActionEvent e){
 if(e.getSource().equals(ccVista.RegistrarBtn)){
 String codigo="";
 String creador=Login.usuario;
 String proveedor=ccVista.txt_proveedor.getText();
 String factura=ccVista.txt_factura.getText();
 String descripcion=ccVista.txt_descripcion.getText();
 String subtotal=ccVista.txt_subtotal.getText();
 String impuesto=ccVista.txt_impuesto.getText();
 String total=ccVista.txt_total.getText();

 ccModelo= new Modelo.Cc(codigo,creador, proveedor, factura, descripcion, subtotal, impuesto, total);
 gestorccModelo.RegistrarCc(ccModelo);

 ccVista.txt_proveedor.setText("");
 ccVista.txt_factura.setText("");
 ccVista.txt_descripcion.setText("");
 ccVista.txt_subtotal.setText("");
 ccVista.txt_impuesto.setText("");
 ccVista.txt_total.setText("");
 
 ccVista.txt_proveedor.requestFocus();
 }
 if(e.getSource().equals(ccVista.NuevoBtn)){
     
 ccVista.txt_proveedor.setText("");
 ccVista.txt_factura.setText("");
 ccVista.txt_descripcion.setText("");
 ccVista.txt_subtotal.setText("");
 ccVista.txt_impuesto.setText("");
 ccVista.txt_total.setText("");
 

 ccVista.txt_proveedor.requestFocus();
 }
 if(e.getSource().equals(ccVista.CerrarBtn)){
     
 ccVista.txt_proveedor.setText("");
 ccVista.txt_factura.setText("");
 ccVista.txt_descripcion.setText("");
 ccVista.txt_subtotal.setText("");
 ccVista.txt_impuesto.setText("");
 ccVista.txt_total.setText("");
 ccVista.dispose();
 }
 }
    
}
