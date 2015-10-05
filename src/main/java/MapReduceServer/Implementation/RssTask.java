/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapReduceServer.Implementation;

import MapReduceServer.Implementation.RssTaskResult;
import MapReduceServer.Abstract.*;
import RSS.model.FeedMessage;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sohailabaset
 */
public class RssTask implements Task {

    FeedMessage msg=null;
    List<String> keywords=null;
    
    public RssTask(FeedMessage msg,List<String> keywords)
    {
    this.msg=msg;
    this.keywords=keywords;  
    }
    

    

    
}
