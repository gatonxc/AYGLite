package Controlador;
import Modelo.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Julian Gato
 */
public class ProveedorControl implements ActionListener {
 Vista.RegProveedorInternalFrame proveedorVista;
 Modelo.Proveedor proveedorModelo;
 Modelo.Gestorproveedor gestorproveedorModelo;
 
 public ProveedorControl(Vista.RegProveedorInternalFrame proveedorVista){
 this.proveedorVista=proveedorVista;
 gestorproveedorModelo=new Modelo.Gestorproveedor();
 }
 
 @Override
 public void actionPerformed(ActionEvent e){
 if(e.getSource().equals(proveedorVista.RegistrarBtn)){
 String identificacion=proveedorVista.txt_identificacion.getText();
 String creador=Login.usuario;
 String nombres=proveedorVista.txt_nombres.getText();
 String direccion=proveedorVista.txt_direccion.getText();
 String telefono=proveedorVista.txt_telefono.getText();
 proveedorModelo= new Modelo.Proveedor(identificacion,creador, nombres, direccion, telefono);
 gestorproveedorModelo.RegistrarProveedor(proveedorModelo);
 proveedorVista.txt_identificacion.setText("");
 proveedorVista.txt_nombres.setText("");
 proveedorVista.txt_direccion.setText("");
 proveedorVista.txt_telefono.setText("");

 proveedorVista.txt_identificacion.requestFocus();
 }
 if(e.getSource().equals(proveedorVista.NuevoBtn)){
     
 proveedorVista.txt_identificacion.setText("");
 proveedorVista.txt_nombres.setText("");
 proveedorVista.txt_direccion.setText("");
 proveedorVista.txt_telefono.setText("");

 proveedorVista.txt_identificacion.requestFocus();
 }
 if(e.getSource().equals(proveedorVista.CerrarBtn)){
     
 proveedorVista.txt_identificacion.setText("");
 proveedorVista.txt_nombres.setText("");
 proveedorVista.txt_direccion.setText("");
 proveedorVista.txt_telefono.setText("");
 proveedorVista.dispose();
 }
 }
    
}
