/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PostInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lowell Milliken
 */
public interface ItemI extends Remote {
    
    
        //GETTERS
    public String getItemDescription()throws RemoteException;
    
    public String getItemUPC()throws RemoteException;
    
    public double getItemPrice()throws RemoteException;
}
