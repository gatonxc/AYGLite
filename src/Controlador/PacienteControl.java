package Controlador;
import Modelo.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Julian Gato
 */
public class PacienteControl implements ActionListener {  
 Vista.RegpacienteInternalFrame pacienteVista;
 Modelo.Paciente pacienteModelo;
 Modelo.Gestorpaciente gestorpacienteModelo;
 
 public PacienteControl(Vista.RegpacienteInternalFrame pacienteVista){
 this.pacienteVista=pacienteVista;
 gestorpacienteModelo=new Modelo.Gestorpaciente();
 }
 
 @Override
 public void actionPerformed(ActionEvent e){
 if(e.getSource().equals(pacienteVista.RegistrarBtn)){
 String identificacion=pacienteVista.txt_identificacion.getText();
 String creador=Login.usuario;
 String nombres=pacienteVista.txt_nombres.getText();
 String apellidos=pacienteVista.txt_apellidos.getText();
 String direccion=pacienteVista.txt_direccion.getText();
 String telefono=pacienteVista.txt_telefono.getText();
 pacienteModelo= new Modelo.Paciente(identificacion,creador,nombres, apellidos, direccion, telefono);
 gestorpacienteModelo.RegistrarPacientes(pacienteModelo);
 pacienteVista.txt_identificacion.setText("");
 pacienteVista.txt_nombres.setText("");
 pacienteVista.txt_apellidos.setText("");
 pacienteVista.txt_direccion.setText("");
 pacienteVista.txt_telefono.setText("");

 pacienteVista.txt_identificacion.requestFocus();
 }
 if(e.getSource().equals(pacienteVista.NuevoBtn)){
     
 pacienteVista.txt_identificacion.setText("");
 pacienteVista.txt_nombres.setText("");
 pacienteVista.txt_apellidos.setText("");
 pacienteVista.txt_direccion.setText("");
 pacienteVista.txt_telefono.setText("");

 pacienteVista.txt_identificacion.requestFocus();
 }
 if(e.getSource().equals(pacienteVista.CerrarBtn)){
     
 pacienteVista.txt_identificacion.setText("");
 pacienteVista.txt_nombres.setText("");
 pacienteVista.txt_apellidos.setText("");
 pacienteVista.txt_direccion.setText("");
 pacienteVista.txt_telefono.setText("");
 pacienteVista.dispose();
 }
 }
}