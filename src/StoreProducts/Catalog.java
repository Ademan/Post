package StoreProducts;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre_000
 * @author Lowell Milliken
 */
// Lowell: made getUPCList public
//         Item is remote now so needed to put methods calls in try-catch blocks

public class Catalog {
    private static final int MAX_PRODUCTS = 100;
    
    private Item products[];   //the store's products, MAX 100
    private int numProducts;  //stores num products currently in catalog, also indicates new open space for addition of item
    private boolean productsInitialized = false; 
    private String[] UPCList;
    
    //DEFAULT CONSTRUCTOR
    Catalog(){
        this.products = new Item[MAX_PRODUCTS];
        this.numProducts = 0;  //first available stop = 0
        this.UPCList = new String[MAX_PRODUCTS];
    }
    
    //SECONDARY CONSTRUCTOR
    Catalog(Item newProducts[], int newNumProducts){
        
        if(newNumProducts > 100){ //exceeding max products
            System.out.println("ERROR: products list cannot exceed 100, will only take first 100.");
        }
        
        //inseart new products list
        for(int i = 0; i < MAX_PRODUCTS; i++){
            this.products[i] = newProducts[i];
            try {
                this.UPCList[this.numProducts] = newProducts[i].getItemUPC();
            } catch (RemoteException ex) {
                Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.numProducts +=1;
        }    
    }
    
    public int addProduct(Item newItem){
        if(this.numProducts < 100){
            this.products[this.numProducts] = newItem;
            this.products[this.numProducts].setItemID(this.numProducts);
            try {
                this.UPCList[this.numProducts] = newItem.getItemUPC();
            } catch (RemoteException ex) {
                Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.numProducts += 1;      //inc catalog size
            return 1;  //added succesfully
        }
        else{
            System.out.println("ERROR, catalog is full, did not add item");
            return -1;
        }
    }
    
    public void printCatalog(){
        System.out.printf("%10s%25s%10s\n", "UPC", "Description", "Price");
        System.out.println("--------------------------------------------------");
        Item itemToPrint;
        try {
            itemToPrint = new Item();
        } catch (RemoteException ex) {
            Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < this.numProducts; i++){
            itemToPrint = this.products[i];
            try {
                System.out.printf("%10s%25s%10s\n", itemToPrint.getItemUPC(), itemToPrint.getItemDescription(), itemToPrint.getItemPrice());
//            System.out.println()  
            } catch (RemoteException ex) {
                Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean UPCExists(String upc){
        for(int i = 0; i < this.numProducts; i++){
            try {
                if(upc.equalsIgnoreCase(this.products[i].getItemUPC())){
                    return true;
                }
            } catch (RemoteException ex) {
                Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public Item getItem(String upc){
        for(int i = 0; i < this.numProducts; i++){
            try {
                if(upc.equalsIgnoreCase(this.products[i].getItemUPC())){
                    return this.products[i];
                }
            } catch (RemoteException ex) {
                Logger.getLogger(Catalog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    //UPC list for GUI
    public String[] getUPCList(){
        String rUPCList[] = new String[this.numProducts]; //upc list to return
        
        //create UPC list with proper size (SHRINKING)
        for(int i = 0; i < this.numProducts; i++){
            rUPCList[i] = this.UPCList[i]; 
        }
        
        return rUPCList;
    }
    
    /**Makes sure catalog does not get init multiple times from same file
     * 
     */
    void productInitDone(){
        this.productsInitialized = true;
    }
    
}
