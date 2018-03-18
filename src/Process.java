
public class Process {

	private int burst, id, priority, timestamp;

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

	public void setPriority(int priority)
	{
		this.priority = priority;
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

	public int getPriority()
	{
		return priority;
	}


}
