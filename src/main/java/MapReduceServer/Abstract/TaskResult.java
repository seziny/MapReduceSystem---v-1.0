/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapReduceServer.Abstract;

import java.io.Serializable;

/**
 *
 * @author sohailabaset
 */
public interface TaskResult extends Serializable{
    
    public Object GetResult();
    public void Aggregate(Object subResult);
}
