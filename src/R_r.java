/*
 * R_r Class
 * "Round-Robin"
 */
public class R_r extends Process implements Comparable<R_r> 
{

	private int tat, wt;
	
	/*
	 * Overrides Process compareTo()
	 * Returns whichever object has the smaller burst time.
	 * @return integer the shortest burst time.
	 */
	@Override
	public int compareTo(R_r compareProc) 
    {
        int compareBurst=(compareProc).getBurst();
        		/* For Ascending order*/
        return this.burst-compareBurst;
		        //For Descending order do like this;
		        //return comparePriority-this.priority;
    }
	
	public int getTat()
	{
		return tat;
	}
	
	
	public void setTat(int tat)
	{
		this.tat = tat;
	}
	

}
