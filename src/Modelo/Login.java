/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Julian Gato
 */
public class Login {


    public static String usuario;
    public static String contraseña;
    public static Integer parametro;
    
    public Login(String usr,String pass,Integer par) {
       usuario=usr;
       contraseña=pass;
       parametro=par;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public static Integer getParametro() {
        return parametro;
    }

    public static void setParametro(Integer aParametro) {
        parametro = aParametro;
    }
    
     
    
}
