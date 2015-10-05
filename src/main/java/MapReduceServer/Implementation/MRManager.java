/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MapReduceServer.Implementation;

import MapReduceServer.Abstract.Job;
import MapReduceServer.Abstract.JobResult;
import MapReduceServer.Abstract.Manager;
import MapReduceServer.Abstract.Reducer;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;
import java.io.*;
import java.util.*;



/**
 *
 * @author sohailabaset
 */
public class MRManager extends UnicastRemoteObject implements Manager, Unreferenced {
   
   private static int port=1199; 
   private static String  ManagerName="MapReduceManager";
   public MRManager()throws RemoteException
   {
  
   } 
   
   public static void main(String args[]) throws Exception
   {  
         MRManager server= new MRManager();
         Registry reg = LocateRegistry.createRegistry(port);
         reg.rebind(ManagerName, server);
         System.out.println("MapReduce server is running now");
   } 

    @Override  
   public JobResult Handle(Job job) throws RemoteException{
//       Socket reducerSocket= null;
//       PrintWriter out= null;
//       BufferedReader in= null;
//       BufferedReader stdIn= null;
//       String reducerName="localhost";
//       int ReducerPort=4443;
//        try {
//            reducerSocket = new Socket(reducerName, ReducerPort);
//            out = new PrintWriter(reducerSocket.getOutputStream(), true);
//           
//            // TO DO: change input stream
//            //stdIn = new BufferedReader(new InputStreamReader(System.in));
//            //String fromServer;
//            //String fromUser;
//            
//            System.out.println("Assigning the job to a reducer");
//            out.print(j);
//            out.flush();
//            out.close();
//           
//            reducerSocket.close();
//        } catch (java.net.UnknownHostException e) {
//            System.err.println("Unknown host: ");
//          System.exit(1);
//        } catch (IOException e) {
//          
//                System.err.println("No server found!");
//               System.exit(1);
//        }
//        return  null;
        
        
       Reducer reducer= FindReducer();
       JobResult jobResult=null;
       try{
        jobResult= reducer.run(job);
       }
       catch(Exception ex)
       {}
       return jobResult;
       
       
       
    }
    
    private boolean Assign(Reducer r,Job j)
    {
    return true;
    }
    
    private Reducer FindReducer()
    {
    return new RssReducer();
    }

    @Override
    public void unreferenced() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
