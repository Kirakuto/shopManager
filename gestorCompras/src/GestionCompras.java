
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivegu
 */
public class GestionCompras {
    
    ArrayList<Compra> listaCompra;

    public GestionCompras() {
        
        this.listaCompra = new ArrayList<Compra>();
        
    }
    /**
     * lea por teclado, usando Scanner, el
    valor para cada atributo necesario, instancie un objeto de Compra y lo almacene en
    listaCompras. No podrá haber 2 compras con el mismo nombre y fecha. Es decir,
    no puede haber compras a un mismo proveedor el mismo día. Se lanzará la
    excepción RuntimeException en caso de intentar crear una compra repetida.
     */
    public void creaCompra() throws Exception{
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduzca el nombre de su compra");
        String nPurchase = sc.nextLine();
        while(nPurchase.isEmpty() || nPurchase.isBlank()){
            System.out.println("Por favor, introduzca el nombre de su compra");
            nPurchase = sc.nextLine();
        }
        
        System.out.println("Introduzca la direccion");
        String nDir = sc.nextLine();
        while(nDir.isEmpty() || nDir.isBlank()){
            System.out.println("Por favor, introduzca una direccion");
            nDir = sc.nextLine();
        }
        
        System.out.println("Introduzca la fecha en formato DD MM AA separado por un espacio");
        String nDate = sc.nextLine();
        while(nDate.isEmpty() || nDate.isBlank()){
            System.out.println("Por favor, una fecha");
            nDate = sc.nextLine();
        }
        
        for (Compra compra : listaCompra) {
            
            if(compra.getNombre().equals(nPurchase) && compra.getDate().equals(nDate)){
                throw new RuntimeException("Compra repetida, elija otras opciones");
            }
        }
        
        listaCompra.add(new Compra(nPurchase,nDir,nDate));
        
    }
    
    /**
     *  dado un mes y un año, pasados
     como parámetro, devuelve un tipo GestionCompras sólo con las compras realizadas
     en dicho mes y año.
     * @param date 
     */
    public void getCompraMes(int month,int year){
        
        
        
    }
}
