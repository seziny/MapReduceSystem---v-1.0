/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MapReduceServer.Abstract;

/**
 *
 * @author sohailabaset
 */
public interface Reducer {
    /**
	 * Returns this reducer's name.
	 *
	 * @return  Name.
	 */
	public String name();

	/**
	 * Run the given job in this reducer.
	 *
	 * @param  job  Job.
	 *
	 * @return  Overall job result returned by the job's <TT>jobResult()</TT>
	 *          method.
	 * @exception  Exception
	 *     A checked exception propagated from any task's <TT>map()</TT> method,
	 *     from the job's <TT>reduce()</TT> method, or from the job's
	 *     <TT>jobResult()</TT> method.
	 */
	public JobResult run(Job job)throws Exception;
		
    
}
