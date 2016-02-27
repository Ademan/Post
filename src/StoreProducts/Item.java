package StoreProducts;

import PostInterfaces.ItemI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
// Lowell: Item is now remote (able)
public class Item extends UnicastRemoteObject implements ItemI {
    
    String description;
    String UPC;
    double price;
    int ID;
    
    
    Item() throws RemoteException{
        
        this.description = "no description";
        this.UPC = "0000";
        this.price = 0.0;
        this.ID = 0;
    }

    Item(String newUPC, String newDescr, double newPrice, int newID) 
            throws RemoteException{

        this.description = newDescr;
        this.UPC = newUPC;
        this.price = newPrice;
        this.ID = newID;
    }
    
    //GETTERS
    public String getItemDescription()throws RemoteException{
        
        return this.description;
    }
    
    public String getItemUPC()throws RemoteException{
        
        return this.UPC;
       
    }
    
    public double getItemPrice()throws RemoteException{
        
        return this.price;
    }
    
    int getItemID(){
        
        return this.ID;
    }
    
    //SETTERS - return 1 if successful
    int setItemDescription(String newDescr){
        
        this.description = newDescr;
        
        return 1; //success
    }
    
    int setItemUPC(String newUPC){
        
        this.UPC = newUPC;
        
        return 1; //success
    }
    
    int setItemPrice(double newPrice){
        
        this.price = newPrice;
        
        return 1; //success
    }
    
    int setItemID(int newID){
        
        this.ID = newID;
        
        return 1; //success
    }

    /**
     * Add toString method to print formatted item objects
     * @return 
     * @Author asouza
     */
    @Override
    public String toString(){
        String itm = "";
         itm = String.format("%-6s %-30s $%-4.2f\n", this.UPC,this.description,this.price);        
        return itm;
    }
}
