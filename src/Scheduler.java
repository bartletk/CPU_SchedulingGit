import java.util.*;
import java.io.*;


public class Scheduler {

	
	
	//@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		/*main needs to take in txt
		 * 				check
		 * then determine which method to call, case statement?
		 * 		check
		 * calls relevant method
		 * relevant method will read rest of txt
		 * should read in individual elements
		 * 		then method will call submethod to print out   
		 */
		
		try 
		{
			Scanner scan = new Scanner(new File("in.txt"));
			String algo = scan.next();
			algo = scan.nextLine().trim();
			switch(algo)
			{
				case "fcfs": processFCFS(scan, algo);
					break;
				case "pnp": processPNP(scan, algo);
					break;
				case "sjnnp":processSJNNP(scan, algo);
					break;
				case "rr": processRR(scan, algo);
					break;
				default: System.out.println("Invalid data entered");
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

	private static void processFCFS(Scanner scanF, String algo)
	{
		int count= 0;
		Queue<Process> q = new LinkedList<Process>();
		Process p;
		try 
		{
			while (scanF.hasNext())
			{	p = new Process();
				scanF.next();
				p.setID(scanF.nextInt());
				p.setTimeStamp(scanF.nextInt());
				p.setBurst(scanF.nextInt());
				q.add(p);
				count++;
			}			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		printFCFS(q, count, algo);
	}

	
	/*private static void processPNP(Scanner scanF, String algo)
	{
		int priority;
		int count = 0;
		LinkedList<Process> q = new LinkedList<Process>();
		Process p;
		try 
		{
			while (scanF.hasNext())
			{	

				p = new Process();
				scanF.next();
				p.setID(scanF.nextInt());
				p.setTimeStamp(scanF.nextInt());
				p.setBurst(scanF.nextInt());
				p.setPriority(scanF.nextInt());
				count++;
				if (q.size() == 0)
					q.add(p);
				else
				{
					for (int x = 0; x < q.size(); x++)
					{
						priority = p.getPriority();
						if(priority < q.get(x).getPriority())
							q.add(x-1, p);
						else if(priority == q.get(x).getPriority())
						{
							if (priority < q.get(x).getPriority())
								q.add(x-1, p);
						}
						else if (priority > q.get(x).getPriority() && priority < q.get(x+1).getPriority())
							if (p.getID() < q.get(x).getID())
								q.add(x+1,p);
							else;
						else q.add(p);
					}
				}
				
			}	
			
		}
		catch(Exception e)
		{
			//if (!e.getMessage().equals("null")
			System.out.println(e.getMessage());
		}
		printPNP(q, count, algo);
	}*/
	private static void processPNP(Scanner scanF, String algo)
	{
		int count= 0;
		LinkedList<Process> q = new LinkedList<Process>();
		Process p;
		try 
		{
			while (scanF.hasNext())
			{	p = new Process();
				scanF.next();
				p.setID(scanF.nextInt());
				p.setTimeStamp(scanF.nextInt());
				p.setBurst(scanF.nextInt());
				p.setPriority(scanF.nextInt());
				q.add(p);
				count++;
			}			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//need to sort the goddamn queue in another method
		printPNP(q, count, algo);
	}
	
	//sortPNP(){}
	
	//sortSJNNP(){}
	
	private static void processRR(Scanner scanF, String algo)
	{
		int count= 0;
		ArrayList<Process> q = new ArrayList<Process>();
		Process p;
		try 
		{
			while (scanF.hasNext())
			{	p = new Process();
				scanF.next();
				p.setID(scanF.nextInt());
				p.setTimeStamp(scanF.nextInt());
				p.setBurst(scanF.nextInt());
				q.add(p);
				count++;
			}			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		printRR(q, count, algo);
	}
	
	private static void processSJNNP(Scanner scanF, String algo)
	{
		int count= 0;
			LinkedList<Process> q = new LinkedList<Process>();
			Process p;
			try 
			{
				while (scanF.hasNext())
				{	p = new Process();
					scanF.next();
					p.setID(scanF.nextInt());
					p.setTimeStamp(scanF.nextInt());
					p.setBurst(scanF.nextInt());
					q.add(p);
					count++;
				}			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			//need to sort the goddamn queue in another method
			printSJNNP(q, count, algo);	
	}
	
	private static void printFCFS(Queue<Process> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		while (!q.isEmpty())
		{
			System.out.println(q.peek().getID() + " " + q.peek().getTimeStamp() + " " + q.poll().getBurst());
		}
	}
	
	private static void printPNP(LinkedList<Process> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		while (!q.isEmpty())
		{
			System.out.println(q.peek().getID() + " " + q.peek().getTimeStamp() + " " + q.peek().getBurst() + " " + q.poll().getPriority());
		}
	}
	
	private static void printRR(ArrayList<Process> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		for (Process p: q)
		{
			System.out.println(p.getID() + " " + p.getTimeStamp() + " " + p.getBurst());
		}
	}
	
	private static void printSJNNP(LinkedList<Process> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		for (Process p: q)
		{
			System.out.println(p.getID() + " " + p.getTimeStamp() + " " + p.getBurst());
		}
	}
	
}
