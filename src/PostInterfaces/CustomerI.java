/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PostInterfaces;

import java.rmi.RemoteException;

/**
 *
 * @author Lowell Milliken
 */
public interface CustomerI  extends java.rmi.Remote {
    /**
     * Returns the customer's name
     * @return name
     */
    public String getName() throws RemoteException;
}
