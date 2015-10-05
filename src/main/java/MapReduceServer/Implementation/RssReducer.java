/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MapReduceServer.Implementation;

import MapReduceServer.Abstract.Job;
import MapReduceServer.Abstract.JobResult;
import MapReduceServer.Abstract.Mapper;
import MapReduceServer.Abstract.Reducer;
import MapReduceServer.Abstract.Task;
import MapReduceServer.Abstract.TaskResult;
import RSS.model.FeedMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;


/**
 *
 * @author sohailabaset
 */
public class RssReducer implements Reducer{

    Map<Mapper,Task> mapperTaskCollection=null;
    public String name() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JobResult run(Job job) throws Exception
    {
        RssJob rssJob=(RssJob) job;
        RssMapper mapper=null;
        
        try 
        {
            for(FeedMessage msg: rssJob.getFeed().getMessages())
            {
                mapper= new RssMapper();
                rssJob.reduce(mapper.map(new RssTask(msg,rssJob.getkeywords())));
            }
         }
        catch(Exception e)
        {}
        
        return rssJob.jobResult();
    }
    
    private boolean RecieveJob()
    {
         // TCP Sockets should be used to recieve the work
        
        return true;
    }
    
    }    
    

