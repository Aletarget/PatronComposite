
package practica_compositei;

import javax.swing.SwingUtilities;

/**
 *
 * @author jorge malaver
 */

import ProductosConcretos.*;
import Vista.MainVista;
public class Practica_compositeI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //productos simples
        
      //Creacion de productos simples es decir uso de un nodo simple (hoja)  
      ProductoSimple ram4 =new ProductoSimple("Memoria 4GB", 23000, "Kisnton");
      ProductoSimple ram8 =new ProductoSimple("Memoria 8GB", 46000, "Kisnton");
      //Creacion de productos simples es decir uso de un nodo simple (hoja)
      ProductoSimple disco1 =new ProductoSimple("Disco duro 512MG", 520000, "Kisnton");
      ProductoSimple disco2 =new ProductoSimple("Disco diro 1TB", 680000, "Kisnton");
      //Creacion de producto simple (procesador) con uso de un nodo simple (hoja)
      ProductoSimple intel = new ProductoSimple("Procesador Intel 17", 300000, "Intel");
      
      // productos compuestos
      // Uso de un nodo compuesto para crear un producto compuesto a partir de ProductosCompuestos
      //Nodo Compuesto 1
      ProductosCompuestos Compersonal = new ProductosCompuestos("VALOR COMPUTADOR");
      //Nodo Compuesto 2
      ProductosCompuestos Compoficina = new ProductosCompuestos("VALOR COMPUTADOR");
      
      // Nodos compuestos
      // Nodo 1
      Compersonal.SumProductos(ram4);
      Compersonal.SumProductos(disco1);
      Compersonal.SumProductos(intel);
      
      Compoficina.SumProductos(ram8);
      Compoficina.SumProductos(disco2);
      Compoficina.SumProductos(intel);
      
      // paquete compuesto varios simples
      //Nodo raiz, este nodo contiene en este caso el precio total de los productos compuestos
      ProductosCompuestos Compcompleto = new ProductosCompuestos("VALOR COMPUTADOR");
      Compcompleto.SumProductos(Compersonal);
      Compersonal.SumProductos(Compoficina);
    //Cliente 1 (Ingresa su nombre y orden)
     Salida sal = new Salida(1 , "Sonia Jaramillo");
     sal.adicionProductos(ram4);
     sal.adicionProductos(disco1);
     sal.adicionProductos(intel);
   
     sal.imprimir();
    //Cliente 2 (Ingresa su nombre y orden)
     Salida sal1= new Salida(2, "Universidad Distrtital");
     sal1.adicionProductos(ram8);
     sal1.adicionProductos(disco2);
     sal1.adicionProductos(intel);
   
     sal1.imprimir();
      
      SwingUtilities.invokeLater(new Runnable(){

        @Override
        public void run() {
            new MainVista();
        }

      });
    }
    
}
