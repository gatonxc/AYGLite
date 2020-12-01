package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Julian Gato
 */
public class LoginControl implements ActionListener {
    
 Vista.LoginJFrame loginVista;
 Vista.PrincipalJFrame principalVista;
 Modelo.Login loginModelo;
 Modelo.Gestorlogin gestorloginModelo;
 
 public LoginControl(Vista.LoginJFrame loginVista){
 this.loginVista=loginVista;
 gestorloginModelo=new Modelo.Gestorlogin();
 }
 
 
 @Override
 public void actionPerformed(ActionEvent e){
     
 if(e.getSource().equals(loginVista.btn_ingresar)){
 int parametro=0;
 if(loginVista.rdb_contabilidad.isSelected()){
 parametro=1;
 }
 if(loginVista.rdb_facturador.isSelected()){
 parametro=2;
 }
 String usuario=loginVista.txt_user.getText();
 String contraseña=loginVista.txt_contraseña.getText();
 loginModelo= new Modelo.Login(usuario, contraseña,parametro);
 gestorloginModelo.login(parametro,loginModelo);
 principalVista=new Vista.PrincipalJFrame();
 if(!usuario.isEmpty()&&!contraseña.isEmpty()){
     
     loginModelo.setUsuario(usuario);
     loginModelo.setContraseña(contraseña);
     
     if(gestorloginModelo.login(parametro,loginModelo)){
         JOptionPane.showMessageDialog(null, "Datos correctos ");
          loginVista.setVisible(false);
          principalVista.setVisible(true);
     }else{
         JOptionPane.showMessageDialog(null, "Datos Incorrectos");
     }
 }else{
     JOptionPane.showMessageDialog(null, "Por favor ingresar Credenciales");
 }
 }
 if(e.getSource().equals(loginVista.btn_salir)){
     System.exit(0);
 }
 }
}
