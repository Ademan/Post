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
public interface RemoteArrayAccessor<T> extends Remote {
    public T get(int i)throws RemoteException; 
    public int getLength() throws RemoteException;
}
