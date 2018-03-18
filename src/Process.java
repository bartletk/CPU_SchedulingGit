
public class Process //implements Comparable
{

	private int id, timestamp;
	protected int burst;
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public void setTimeStamp(int timestamp)
	{
		this.timestamp = timestamp;
	}

	public void setBurst(int burst)
	{
		this.burst = burst;
	}


	public int getID()
	{
		return id;
	}

	public int getTimeStamp()
	{
		return timestamp;
	}

	public int getBurst()
	{
		return burst;
	}

	public int compareTo(Pnp compareProc) {
		return 0;
	}

	public int compareTo(Sjnnp compareBurst)
	{
		return 0;
	}



	


}
