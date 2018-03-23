/*
 * Pnp Class
 * "Priority non-preemptive"
 * Extension of Process.
 * Includes additional methods:
 * 			setPriority() and getPriority()
 * 			compareTo() overrides super class method, allowing to sort by priority
 */

public class Pnp extends Process implements Comparable<Pnp>
{

	private int priority;
	
	/*
	 * Sets priority.
	 * @param priority the process priority.
	 */
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	/*
	 * Returns priority.
	 * @return priority the process priority.
	 */
	public int getPriority()
	{
		return priority;
	}
	
	/*
	 * Overrides the Process compareTo() method.
	 * Compares process priority.
	 * @return integer the lowest (actually, highest) priority.
	 */
	@Override
    public int compareTo(Pnp compareProc) 
    {
        int comparePriority=(compareProc).getPriority();
        /* For Ascending order*/
        return this.priority-comparePriority;
        //For Descending order do like this
        //return comparePriority-this.priority;
    }
	
	/*
	 * Overrides Process toString() method.
	 * Returns Pnp information.
	 * @return string containing Pnp information.
	 */
	@Override 
	public String toString()
	{
		return getID() + " " + getTimeStamp() + " " + getBurst() + " " + getPriority();
	}

}
