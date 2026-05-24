
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author WEB1-32
 */
public class Compra {

    private int id;//Asignacion automatica, numeros consecutivos
    private static int cont;
    private String nombre;
    private String dir;
    private int[] date;//formato dia/mes/anyo
    private ArrayList cart;
    private ArrayList pCart;

    public Compra(String nombre, String dir, String date, ArrayList cart, ArrayList pCart) throws Exception {

        setId();
        try {
            this.nombre = setNombre(nombre);
            this.date = setDate(date);
        } catch (Exception ex) {
            System.out.println("Creation failure");
            throw ex;
        }
        this.dir = dir;
        //TODO check the lenght of both lists
        this.cart = cart;
        this.pCart = pCart;
    }

    public Compra(String nombre, String dir, String date) throws Exception {
        setId();
        try {
            this.nombre = setNombre(nombre);
            this.date = setDate(date);
        } catch (Exception ex) {
            System.out.println("Creation failure");
            throw ex;
        }
        this.dir = dir;
        this.cart = new ArrayList();
        this.pCart = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        upCont();
        this.id = this.cont;
    }

    public static void upCont() {
        Compra.cont += 1;
    }

    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) throws Exception {

        if (!nombre.isEmpty() || !nombre.isBlank()) {
            throw new Exception("Name cant be empty");
        } else {
            this.nombre = nombre;
            return nombre;
        }
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int[] getDate() {
        return date;
    }

    public int[] setDate(String date) throws Exception {

        String[] date2 = date.trim().split(" ");
        if (date2.length != 3) {
            throw new Exception("Invalid date, your date should be day/month/year sepparated by spaces");
        }
        for (int i = 0; i < date2.length; i++) {
            for (int j = 0; j < date2.length; j++) {
                char aux = date2[i].charAt(j);
                if (!Character.isDigit(aux)) {
                    throw new Exception("Date should be in numbers separated by spaces.");
                }
            }
        }

        int[] res = new int[3];

        for (int i = 0; i < date2.length; i++) {
            res[i] = Integer.parseInt(date2[i]);
        }
        return res;
    }

    public ArrayList getCart() {
        return cart;
    }

    public void setCart(ArrayList cart) {
        this.cart = cart;
    }

    public ArrayList getpCart() {
        return pCart;
    }

    public void setpCart(ArrayList pCart) {
        this.pCart = pCart;
    }

    public void anyadeProducto(String product, int price) {

        cart.add(product);
        pCart.add(price);

    }

    public boolean borrarProducto(String product) {

        Iterator<Integer> i = cart.iterator();
        int cont = 0;//Creamos un contador que nos permitira identificar la posicion
        boolean found = false;

        while (i.hasNext()) {//recoremos con iterator hasta encontrar el producto
            if (i.equals(product)) {
                cart.remove(cont);
                pCart.remove(cont);
                found = true;
            }
            cont++;
        }
        return found;
    }
    
    public String productoMasCaro(ArrayList<String> cart, ArrayList<Integer> pCart){
        
        int max = 0;
        String product = "";
        
        for (int i = 0; i < cart.size(); i++) {
            
            if(max < pCart.get(i)){
                product = cart.get(i);
                max = pCart.get(i);
            }
        }  
        return product + (" " + max);
    }

    //TODO complete method
    /*public String[] productosMasBaratosQue(){
        
    }*/
}
