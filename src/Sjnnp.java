/*
 * Sjnnp Class
 * "Shortest job next, non-preemptive."
 * Extension of Process.
 * Overrides super class compareTo() method to sort based on burst size.
 */
public class Sjnnp extends Process implements Comparable<Sjnnp> 
{

	/*
	 * Overrides Process compareTo()
	 * Returns whichever object has the smaller burst time.
	 * @return integer the shortest burst time.
	 */
	@Override
    public int compareTo(Sjnnp compareProc) 
    {
        int compareBurst=(compareProc).getBurst();
        		/* For Ascending order*/
        return this.burst-compareBurst;
		        //For Descending order do like this;
		        //return comparePriority-this.priority;
    }

}
