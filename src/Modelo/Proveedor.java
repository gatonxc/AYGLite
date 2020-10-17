package Modelo;

/**
 *
 * @author Julian Gato
 */
public class Proveedor {
    
    private String identificacion;
    private String creador;
    private String nombres;
    private String direccion;
    private String telefono;
    
    public Proveedor(String id,String cr, String nom, String dir, String tel) {
       identificacion=id;
       creador=cr;
       nombres=nom;
       direccion=dir;
       telefono=tel;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
