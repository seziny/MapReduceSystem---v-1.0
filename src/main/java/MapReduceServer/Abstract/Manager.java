/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MapReduceServer.Abstract;

import java.rmi.*;

/**
 *
 * @author sohailabaset
 */
public interface Manager extends Remote{
    
  public JobResult Handle(Job j)throws RemoteException;  
    
}
