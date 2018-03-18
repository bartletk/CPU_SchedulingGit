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
		
		
		//print methods()
		
	}

	private static void processFCFS(Scanner scanF, String algo)
	{
		int count= 0;
		Queue<Fcfs> q = new LinkedList<Fcfs>();
		Fcfs p;
		try 
		{
			while (scanF.hasNext())
			{	
				p = new Fcfs();
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
		int count= 0;
		LinkedList<Pnp> q = new LinkedList<Pnp>();
		Pnp p;
		try 
		{
			while (scanF.hasNext())
			{	
				p = new Pnp();
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
		Collections.sort(q);;
		printPNP(q, count, algo);
	}
	
	//sortPNP(){}
	
	//sortSJNNP(){}
	
	private static void processRR(Scanner scanF, String algo)
	{
		int count= 0;
		ArrayList<R_r> q = new ArrayList<R_r>();
		R_r p;
		try 
		{
			while (scanF.hasNext())
			{	p = new R_r();
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
			LinkedList<Sjnnp> q = new LinkedList<Sjnnp>();
			Sjnnp p;
			try 
			{
				while (scanF.hasNext())
				{	p = new Sjnnp();
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
			Collections.sort(q);
			printSJNNP(q, count, algo);	
	}
	
	private static void printFCFS(Queue<Fcfs> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		while (!q.isEmpty())
		{
			System.out.println(q.peek().getID() + " " + q.peek().getTimeStamp() + " " + q.poll().getBurst());
		}
	}
	
	private static void printPNP(LinkedList<Pnp> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		while (!q.isEmpty())
		{
			System.out.println(q.peek().getID() + " " + q.peek().getTimeStamp() + " " + q.peek().getBurst() + " " + q.poll().getPriority());
		}
	}
	
	private static void printRR(ArrayList<R_r> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		for (R_r p: q)
		{
			System.out.println(p.getID() + " " + p.getTimeStamp() + " " + p.getBurst());
		}
	}
	
	private static void printSJNNP(LinkedList<Sjnnp> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		for (Process p: q)
		{
			System.out.println(p.getID() + " " + p.getTimeStamp() + " " + p.getBurst());
		}
	}
		
}
