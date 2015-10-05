/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MapReduceServer.Implementation;

import MapReduceServer.Abstract.Mapper;
import MapReduceServer.Abstract.Task;
import MapReduceServer.Abstract.TaskResult;
import RSS.model.FeedMessage;

/**
 *
 * @author sohailabaset
 */
public class RssMapper implements Mapper{


    public String name() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TaskResult map(Task task) {
        RssTask rssTask=(RssTask) task;
        RssTaskResult rssTaskResult=new RssTaskResult(rssTask.msg);
        for(String keyword: rssTask.keywords)
        {
        if(IsRelavant(rssTask.msg, keyword))
            rssTaskResult.Aggregate(keyword);
        }
        return rssTaskResult;
    }
    
    private boolean IsRelavant(FeedMessage msg,String keyword)
    {
    return msg.getTitle().contains(keyword);
    }
    
}
