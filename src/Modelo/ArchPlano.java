package Modelo;

/**
 *
 * @author Julian Gato
 */
public class ArchPlano {

   
    public String factura;
    public String ctadb;
    public String ctacr;
    public String ctaimp;
    public String Proveedor;
    public String Codigo;
    public String Descripcion;
    public String subtotal;
    public String impuesto;
    public String total;
    
    public ArchPlano(String db, String cr,String imto,String fact,String pro,String Cod,String Desc,String sub,String imp,String tot) {
        
       factura=fact;
       ctadb=db;
       ctacr=cr;
       ctaimp=imto;
       Proveedor=pro;
       Codigo=Cod;
       Descripcion=Desc;
       subtotal=sub;
       impuesto=imp;
       total=tot;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getTotal() {
        return total;
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
    
    public String getCtaimp() {
        return ctaimp;
    }

    public void setCtaimp(String ctaimp) {
        this.ctaimp = ctaimp;
    }
    
    public void setTotal(String total) {
        this.total = total;
    }
    
}
