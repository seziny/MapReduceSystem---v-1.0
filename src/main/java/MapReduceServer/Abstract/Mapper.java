/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MapReduceServer.Abstract;

/**
 *
 * @author sohailabaset
 */
public interface Mapper {
    // Exported operations.


	/**
	 * Run the given task in this mapper.
	 *
	 * @param  task  Task.
	 *
	 * @return  Task result returned by the task's <TT>map()</TT> method.
     * @throws Exception A checked exception propagated from the task's <TT>map()</TT> method.
	 */
	public TaskResult map(Task task);
		

}
