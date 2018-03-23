

public abstract class Process //implements Comparable
{

	protected int id, timestamp, burst;
	
	/*
	 * Method to set process ID.
	 * @param id the process ID.
	 */
	public void setID(int id)
	{
		this.id = id;
	}
	
	/*
	 * Sets time stamp.
	 * @param timestamp the process time stamp/entry time.
	 */
	public void setTimeStamp(int timestamp)
	{
		this.timestamp = timestamp;
	}

	/*
	 * Sets the burst.
	 * @param burst the process burst time.
	 */
	public void setBurst(int burst)
	{
		this.burst = burst;
	}


	/*
	 * Returns process ID.
	 * @return id the process ID.
	 */
	public int getID()
	{
		return id;
	}

	/*
	 * Returns timestamp.
	 * @return timestamp the process time stamp/entry time.
	 */
	public int getTimeStamp()
	{
		return timestamp;
	}

	/*
	 * Returns burst.
	 * @return burst the process burst time.
	 */
	public int getBurst()
	{
		return burst;
	}

	/*
	 * Compares nothing, to nothing.
	 * Returns 0.
	 * @param compareProc a comparison object. 
	 */
	public int compareTo(Process compareProc) {
		return 0;
	}

	/*
	 * Overrides toString() method.
	 * Returns string containing Process information.
	 * @return string the process information.
	 */
	@Override 
	public String toString()
	{
		return getID() + " " + getTimeStamp() + " " + getBurst();
	}


	


}
