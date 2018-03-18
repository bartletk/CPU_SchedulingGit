
public class Sjnnp extends Process implements Comparable<Sjnnp> 
{

	@Override
    public int compareTo(Pnp compareProc) 
    {
        int compareBurst=(compareProc).getBurst();
        /* For Ascending order*/
        return this.burst-compareBurst;
        //For Descending order do like this
        //return comparePriority-this.priority;
    }

}
