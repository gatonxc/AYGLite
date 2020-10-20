package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Julian Gato
 */
public class ApControl implements ActionListener {
    
 Vista.RegApInternalFrame apVista;
 Modelo.ArchPlano apModelo;
 Modelo.GestorArchplano gestorapModelo;
 
 public ApControl(Vista.RegApInternalFrame apVista){
 this.apVista=apVista;
 gestorapModelo=new Modelo.GestorArchplano();
 }
 
 @Override
 public void actionPerformed(ActionEvent e){
 
 if(e.getSource().equals(apVista.ExportarBtn)){
 String CuentaDebito=apVista.txt_debito.getText();
 String CuentaCredito=apVista.txt_credito.getText();
 String Factura=apVista.jcb_factura.getSelectedItem().toString();
 String CuentaImpuesto=apVista.txt_impuesto.getText();
 String Proveedor="";
 String Codigo="";
 String Descripcion="";
 String subtotal="";
 String impuesto="";
 String total="";
 

 apModelo= new Modelo.ArchPlano(CuentaDebito,CuentaCredito,CuentaImpuesto,Factura,Proveedor,Codigo,Descripcion,subtotal,impuesto,total);
 gestorapModelo.RegistrarAp(apModelo);
 }
 if(e.getSource().equals(apVista.CerrarBtn)){
 
 apVista.dispose();
 }
    
}
}
