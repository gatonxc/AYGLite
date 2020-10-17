package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Julian Gato
 */
public class ApControl implements ActionListener {
    
 Vista.ArchPlanoInternalFrame apVista;
 Modelo.ArchPlano apModelo;
 Modelo.GestorArchplano gestorapModelo;
 
 public ApControl(Vista.ArchPlanoInternalFrame apVista){
 this.apVista=apVista;
 gestorapModelo=new Modelo.GestorArchplano();
 }
 
 @Override
 public void actionPerformed(ActionEvent e){
 
 if(e.getSource().equals(apVista.ExportarBtn)){
 String CuentaDebito=apVista.txt_debito.getText();
 String CuentaCredito=apVista.txt_credito.getText();
 String Factura=apVista.txt_factura.getText();
 String Proveedor="";
 String Codigo="";
 String Descripcion="";
 String Valor="";
 

 apModelo= new Modelo.ArchPlano(CuentaDebito,CuentaCredito,Factura,Proveedor,Codigo,Descripcion,Valor);
 gestorapModelo.RegistrarAp(apModelo);
 }
 if(e.getSource().equals(apVista.CerrarBtn)){
 
 apVista.dispose();
 }
    
}
}
