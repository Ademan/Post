/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.server;

import PostInterfaces.RemoteArrayAccessor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Lowell Milliken
 */
public class RemoteArrayAccessorImpl<T> extends UnicastRemoteObject
        implements RemoteArrayAccessor {

    T [] array;
    
    public RemoteArrayAccessorImpl(T [] array) throws RemoteException {
        this.array = array;
    }
    
    @Override
    public T get(int i) throws RemoteException {
        return array[i];
    }
    
    public int getLength() {
        return array.length;
    }
    
}
