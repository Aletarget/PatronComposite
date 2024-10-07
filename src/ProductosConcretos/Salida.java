
package ProductosConcretos;

/**
 *
 * @author jorge malaver
 */

// agrega productos para la venta

import Component.ProductoAbstracto;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Salida {
    private long ordenI;
    private String Cliente;
    //private Calendar fecha;
    //private List productos = new ArrayList();
    
    private List< ProductoAbstracto > productos =new ArrayList<ProductoAbstracto>();
    
    public Salida(long orden, String cliente){
        super();
        this.ordenI=orden;
        this.Cliente=cliente;
    }
    
    public long getorden(){
        
        return ordenI;
        
    }
    
    public void  setorden(long orden){
        
        this.ordenI=orden;
    }
    
    public String getcliente(){
        return Cliente;
    }
    
    public void setcliente(String cliente){
        this.Cliente=cliente;
    }
    
    public List<ProductoAbstracto> getproductos(){
        
        return productos;
    }
    
    public void setproductos(List<ProductoAbstracto> productos){
        
        this.productos=productos;
    }
    
    public double getprecio(){
         double pres=0;
        for(ProductoAbstracto sum : productos){
          pres += sum.getprecio();
         }
         return pres;
    }
    
    public void adicionProductos(ProductoAbstracto produ){
       
        productos.add(produ);
    }
    
    
      public void eliminarProductos(ProductoAbstracto produ){
       
        productos.add(produ);
    }   
  
    public String imprimir() {
        NumberFormat formato = new DecimalFormat("####.00");
        String textoBase = "";
        
        // Concatenando cadenas
        textoBase += "\n====================================\nOrden........" + ordenI;
        textoBase += "\nCliente..." + Cliente;
        textoBase += "\nProductos...........";
    
        // Iterar sobre los productos
        for (ProductoAbstracto sum : productos) {
            textoBase += "\n" + sum.getnombre() + "......." + formato.format(sum.getprecio());
        }
    
        textoBase += "\n";
        textoBase += "Total Compra   :" + formato.format(getprecio());
        
        // Imprimir el texto generado
        System.out.println(textoBase);
    
        return textoBase;
    }
        
}// fin lista
