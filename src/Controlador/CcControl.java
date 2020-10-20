package Controlador;

import Modelo.GestorRellenar;
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
public class CcControl implements ActionListener,ItemListener {
    
 Vista.RegCcInternalFrame ccVista;
 Modelo.Cc ccModelo;
 Modelo.GestorCc gestorccModelo;
 Modelo.GestorRellenar rellenarModelo;
 
 public CcControl(Vista.RegCcInternalFrame ccVista){
 this.ccVista=ccVista;
 gestorccModelo=new Modelo.GestorCc();
 }

 @Override
 public void actionPerformed(ActionEvent e){
 if(e.getSource().equals(ccVista.RegistrarBtn)){
 String codigo="";
 String creador=Login.usuario;
 String proveedor=ccVista.jcb_proveedor.getSelectedItem().toString();
 String factura=ccVista.jcb_factura.getSelectedItem().toString();
 String descripcion=ccVista.txt_descripcion.getText();
 String subtotal=ccVista.txt_subtotal.getText();
 String impuesto=ccVista.txt_impuesto.getText();
 String total=ccVista.txt_total.getText();

 ccModelo= new Modelo.Cc(codigo,creador, proveedor, factura, descripcion, subtotal, impuesto, total);
 gestorccModelo.RegistrarCc(ccModelo);

 ccVista.jcb_proveedor.setSelectedItem(1);
 ccVista.jcb_factura.setSelectedItem(1);
 ccVista.txt_descripcion.setText("");
 ccVista.txt_subtotal.setText("");
 ccVista.txt_impuesto.setText("");
 ccVista.txt_total.setText("");
 
 ccVista.jcb_proveedor.requestFocus();
 }
 if(e.getSource().equals(ccVista.NuevoBtn)){
     
 ccVista.jcb_proveedor.setSelectedItem(1);
 ccVista.jcb_factura.setSelectedItem(1);
 ccVista.txt_descripcion.setText("");
 ccVista.txt_subtotal.setText("");
 ccVista.txt_impuesto.setText("");
 ccVista.txt_total.setText("");
 

 ccVista.jcb_proveedor.requestFocus();
 }
 if(e.getSource().equals(ccVista.CerrarBtn)){
     
 ccVista.jcb_proveedor.setSelectedItem(1);
 ccVista.jcb_factura.setSelectedItem(1);
 ccVista.txt_descripcion.setText("");
 ccVista.txt_subtotal.setText("");
 ccVista.txt_impuesto.setText("");
 ccVista.txt_total.setText("");
 ccVista.dispose();
 }
 }
 
 @Override
 public void itemStateChanged(ItemEvent e) {
        if (e.getSource().equals(ccVista.jcb_proveedor)) {
            if(ccVista.jcb_proveedor.getSelectedIndex()==0){
                ccVista.lbl_proveedor.setText("");
            }else{
            String id=ccVista.jcb_proveedor.getSelectedItem().toString();
            ArrayList<String> nomproveedor= new ArrayList<String>();
            nomproveedor=rellenarModelo.nom_proveedor(id);
            ccVista.lbl_proveedor.setText(nomproveedor.get(1));
            }
        }
    }
    
}
