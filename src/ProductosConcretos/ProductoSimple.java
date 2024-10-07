
package ProductosConcretos;

/**
 *
 * @author jorge malaver
 */
import Component.ProductoAbstracto;

// ESTE COMPONENTE SON LAS HOJAS YA QUE SON EL NODO MAS SIMPLE QUE NO TIENE HIJOS Y SOLO ALMACENA UN PRECIO Y UN STRING QUE DEFINE LA MARCA

public class ProductoSimple extends ProductoAbstracto{
    
    String marca;
    double precio;
    public ProductoSimple(String nom, double pres, String marca) {
        super(nom, pres);
        this.marca=marca;
        this.precio=pres;
    }
    @Override
    public double getprecio(){
        return precio;
    }
            
    @Override
    public void setprecio(double pres){
        
        this.precio=pres;
    }
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String mar){
        
        this.marca=mar;
    }
} // fin clase ProductoSimple se adiciona un nuevo atributo llamado marca
