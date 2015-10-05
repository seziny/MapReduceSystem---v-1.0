/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapReduceServer.Implementation;

import MapReduceServer.Abstract.TaskResult;
import RSS.model.FeedMessage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sohailabaset
 */
public class RssTaskResult implements TaskResult {
    
    private FeedMessage msg=null;
    private List<String> relatedKeywords=null;
    
    public RssTaskResult(FeedMessage msg)
    {
    this.msg=msg;
    this.relatedKeywords=new ArrayList();
    }
    
    @Override
    public void Aggregate(Object SubResult)
    {
        relatedKeywords.add(SubResult.toString());
    }

    @Override
    public Object GetResult() {
        return this;
    }

    /**
     * @return the msg
     */
    public FeedMessage GetMsg() {
        return msg;
    }

    /**
     * @return the relatedKeywords
     */
    public List<String> GetRelatedKeywords() {
        return relatedKeywords;
    }
}
