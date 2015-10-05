/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MapReduceServer.Abstract;

import java.io.Serializable;

/**
 *
 * @author sohailabaset
 */
public interface JobResult extends Serializable{
public Object GetResult();    
public void Aggregate(Object subResult);
}
