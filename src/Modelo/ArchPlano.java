package Modelo;

/**
 *
 * @author Julian Gato
 */
public class ArchPlano {
    
    public String factura;
    public String ctadb;
    public String ctacr;
    public String Proveedor;
    public String Codigo;
    public String Descripcion;
    public String Valor;
    
    public ArchPlano(String db, String cr,String fact,String pro,String Cod,String Desc,String Vr) {
        
       factura=fact;
       ctadb=db;
       ctacr=cr;
       Proveedor=pro;
       Codigo=Cod;
       Descripcion=Desc;
       Valor=Vr;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
    
    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getCtadb() {
        return ctadb;
    }

    public void setCtadb(String ctadb) {
        this.ctadb = ctadb;
    }

    public String getCtacr() {
        return ctacr;
    }

    public void setCtacr(String ctacr) {
        this.ctacr = ctacr;
    }
    
}
