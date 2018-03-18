

public class Pnp extends Process implements Comparable<Pnp>
{

	private int priority;
	
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	@Override
    public int compareTo(Pnp compareProc) 
    {
        int comparePriority=(compareProc).getPriority();
        /* For Ascending order*/
        return this.priority-comparePriority;
        //For Descending order do like this
        //return comparePriority-this.priority;
    }
	
	@Override 
	public String toString()
	{
		return getID() + " " + getTimeStamp() + " " + getBurst() + " " + getPriority();
	}

}
