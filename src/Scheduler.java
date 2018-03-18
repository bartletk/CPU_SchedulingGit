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
				case "sjnnp":System.out.println("sjnnp");
					break;
				case "rr": System.out.println("rr");
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

	
	private static void processPNP(Scanner scanF, String algo)
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
				q.add(p);
				count++;
				for (int x = 0; x < q.size(); x++)
				{
					priority = p.getPriority();
					if(priority < q.get(x).getPriority())
						q.add(x-1, p);
					if(priority == q.get(x).getPriority())
					{
						if (priority < q.get(x).getPriority())
							q.add(x-1, p);
					}
					if (priority > q.get(x).getPriority() && priority < q.get(x+1).getPriority())
						q.add(p);
				}
			}	
			
		}
		catch(Exception e)
		{
			//if (!e.getMessage().equals("null")
			System.out.println(e.getMessage());
		}
		printPNP(q, count, algo);
	}
	
	/*private static void processRR()
	{
		
	}
	
	private static void processSJNNP()
	{
		
	}*/
	
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
		/*while (!q.isEmpty())
		{
			System.out.println(q.peek().getID() + " " + q.peek().getTimeStamp() + " " + q.poll().getBurst());
		}*/
	}
	
}
