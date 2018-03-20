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
		ArrayList<Fcfs> q = new ArrayList<Fcfs>();
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
		ArrayList<Pnp> q = new ArrayList<Pnp>();
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
	
	private static void printFCFS(ArrayList<Fcfs> q, int c, String algo)
	{
		int clock = 0;
		String breaker = "---------------------------------------------------------";
		Fcfs p = new Fcfs();
		System.out.println("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
		System.out.println(breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
		for (Fcfs m: q) System.out.println(m);
		for (int i = 0; i < c; i++)
			{
				if (i == c)
					{
						System.out.print("nothing");
					}
				else
					{
						p = q.get(i);
						clock += p.getID();
						System.out.println("CPU Request serviced during this clock interval: " + p);
						System.out.println(breaker);
						System.out.println("Clock: "+ clock);
						System.out.println(p+"\nPending CPU request(s): ");
						for (int x = i+1; x < c; x++)
							System.out.println(q.get(x));
						System.out.print("\n");
					}
				
				
			}
	}
	
	private static void printPNP(ArrayList<Pnp> q, int c, String algo)
	{
		String breaker = "---------------------------------------------------------";
		Pnp p = new Pnp();
		System.out.println("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
		System.out.println(breaker + "\nClock: " + p.getTimeStamp() + "\nPending CPU request(s): ");
		for (Pnp m: q) System.out.println(m);
		for (int i = 0; i < c-1; i++)
			{
				p = q.get(i);
				
				System.out.println(breaker);
				//if (i==c-1)
					//break;
				System.out.println(p+"\nPending CPU request(s): ");
				for (int x = i+1; x < c; x++)
					System.out.println(q.get(x));
				System.out.print("\n");
				
				
			}
	}
	
	private static void printRR(ArrayList<R_r> q, int c, String algo)
	{
		//still the same print tech as fcfs, currently
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		for (R_r p: q)
		{
			System.out.println(p);
		}
	}
	
	private static void printSJNNP(LinkedList<Sjnnp> q, int c, String algo)
	{
		System.out.println("Algorithm: " + algo + ".\n" +c +" processes.");
		for (Process p: q)
		{
			System.out.println(p);
		}
	}
		
}
