/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapReduceServer.Implementation;


import MapReduceServer.Abstract.JobResult;
import MapReduceServer.Abstract.TaskResult;
import RSS.model.FeedMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sohailabaset
 */
public class RssJobResult implements JobResult{
    
    private List<TaskResult> taskResults=null;
    
    public RssJobResult()
    {
    this.taskResults= new ArrayList();
    }
    
    public List<TaskResult> GetTaskResults()
    {
    return taskResults;
    }

    @Override
    public void Aggregate(Object subResult) {
     this.taskResults.add((RssTaskResult) subResult );
    }

    @Override
    public Object GetResult() {
        Map<FeedMessage,List<String>> relatedMessages=new HashMap();
        for(TaskResult result:this.taskResults)
        {
            RssTaskResult parsedResult=(RssTaskResult)result;
            relatedMessages.put(parsedResult.GetMsg(),parsedResult.GetRelatedKeywords());
        }
        return relatedMessages;
    }
}
