/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapReduceClient;

/**
 *
 * @author sezin
 */

import MapReduceServer.Implementation.RssJob;
import MapReduceServer.Implementation.RssJobResult;
import MapReduceServer.Abstract.Job;
import MapReduceServer.Abstract.JobResult;
import MapReduceServer.Abstract.Manager;
import java.io.IOException;
import RSS.model.Feed;
import RSS.model.FeedMessage;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MRClient implements Remote {
   
    String hostName=null;
    String managerName=null;
    int port=0;
    
  
    private Manager InitializeRMI()
    {
        hostName = "localhost";
        port=1199; 
        managerName="MapReduceManager";
        String serverUrl=  "//" + hostName +":"+port+ "/"+ managerName; // server name in URL format
        Manager manager=null;
        try
        {
            manager =(Manager) Naming.lookup(serverUrl);
        }
        catch(MalformedURLException malUrlEx)
        {
        System.out.println("Malformed URL exception should be handled");
        }
        catch(NotBoundException e)
        {
        System.out.println("Unbound exception should be handled");
        }
        catch(RemoteException remoteEx)
        {
        System.out.println("Remote Exception should be handled");
        }
        
        return manager;
        }
    
    public  Map<FeedMessage,List<String>>  Filter(Feed feed,List<String> keywords) throws Exception
    {
//       Map<FeedMessage,List<String>> map= new HashMap();
//        for(FeedMessage msg: feed.getMessages())
//        {
//        map.put(msg,new ArrayList<String>());
//        }
//       return map;
        Manager manager=InitializeRMI();
        if(manager==null)
             throw new Exception("could not connect to manager");
        Job jobToHandle=new RssJob(feed,keywords);
        JobResult result=manager.Handle(jobToHandle);
 
         Map<FeedMessage,List<String>>  relatedMessages=( Map<FeedMessage,List<String>> ) ((RssJobResult) result).GetResult();
        
        return relatedMessages;
    }
}
