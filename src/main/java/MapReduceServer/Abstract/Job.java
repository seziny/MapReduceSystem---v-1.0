/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapReduceServer.Abstract;

import java.io.Serializable;

/**
 *
 * @author sezin
 */
public interface Job extends Serializable{
    // Exported operations.


	/**
	 * Combine (reduce) the given task result into this job's overall result.
	 *
	 * @param  taskResult  Task result.
	 *
	 * @exception  Exception
	 *     The <TT>reduce()</TT> method may throw any checked exception.
	 */
	public void reduce
		(TaskResult taskResult)
		throws Exception;

	/**
	 * Get this job's overall result. This method should not be called until
	 * <TT>reduce()</TT> has been called for all the task results.
	 *
	 * @return  Overall job result.
	 *
	 * @exception  Exception
	 *     The <TT>jobResult()</TT> method may throw any checked exception.
	 */
	public JobResult jobResult()
		throws Exception;
}
