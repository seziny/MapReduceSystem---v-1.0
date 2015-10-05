/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapReduceServer.Implementation;

import MapReduceServer.Abstract.*;
import RSS.model.Feed;
import java.util.List;


/**
 *
 * @author sohailabaset
 */
public class RssJob implements Job {

    private Feed feed=null;
    private List<String> keywords=null;
    private JobResult result=null;
    
    public RssJob(Feed feed,List<String> keywords)
    {
        this.feed=feed;
        this.keywords=keywords;
        result= new RssJobResult();
    }
    public List<String> getkeywords()
    {
    return keywords;
    }
    public Feed getFeed()
    {
    return feed;
    }

    @Override
    public void reduce(TaskResult taskResult) throws Exception {
      RssTaskResult rssResult= (RssTaskResult)taskResult;
      if(! rssResult.GetRelatedKeywords().isEmpty())
          result.Aggregate(rssResult);
      
    }

    @Override
    public JobResult jobResult() throws Exception {
      return result;
    }

  


    
}
