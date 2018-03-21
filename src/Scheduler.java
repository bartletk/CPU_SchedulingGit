import java.util.*;
import java.io.*;


public class Scheduler {

	public static void main(String[] args) {


		/*main needs to take in txt
		 * 				check
		 * then determine which method to call, case statement?
		 * 		check
		 * calls relevant method
		 			check
		 * relevant method will read rest of txt
		 	 		check
		 * should read in individual elements
		 			check
		 * then method will call submethod to print out
		 			check
		 * need  to add in a second array, for each method, that will hold the original scan in
		 			check
		 * need to calc Tat and WT
		 			check
		 * need to print to files.
		 */



		try
		{
			Scanner scan = new Scanner(new File("../in.txt"));
			String algo = scan.next();
			algo = scan.nextLine().trim();
			switch(algo)
			{
				case "fcfs": processFCFS(scan, algo);
					break;
				case "pnp": processPNP(scan, algo);
					break;
				case "sjnnp": processSJNNP(scan, algo);
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

	}//end main

	private static void processFCFS(Scanner scan, String algo)
	{
		int count= 0;
		ArrayList<Fcfs> q1 = new ArrayList<Fcfs>();
		ArrayList<Fcfs> q2 = new ArrayList<Fcfs>();
		Fcfs p;
		try
		{
			while (scan.hasNext())
			{
				p = new Fcfs();
				scan.next();
				p.setID(scan.nextInt());
				p.setTimeStamp(scan.nextInt());
				p.setBurst(scan.nextInt());
				q1.add(p);
				q2.add(p);
				count++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		printFCFS(q1, q2, count, algo);
	}

	private static void processPNP(Scanner scan, String algo)
	{
		int count= 0;
		ArrayList<Pnp> q1 = new ArrayList<Pnp>();
		ArrayList<Pnp> q2 = new ArrayList<Pnp>();
		Pnp p;
		try
		{
			while (scan.hasNext())
			{
				p = new Pnp();
				scan.next();
				p.setID(scan.nextInt());
				p.setTimeStamp(scan.nextInt());
				p.setBurst(scan.nextInt());
				p.setPriority(scan.nextInt());
				q1.add(p);
				q2.add(p);
				count++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		Collections.sort(q1);;
		printPNP(q1, q2, count, algo);
	}


	private static void processRR(Scanner scan, String algo)
	{
		int count= 0;
		ArrayList<R_r> q1 = new ArrayList<R_r>();
		ArrayList<R_r> q2 = new ArrayList<R_r>();
		R_r p;
		try
		{
			while (scan.hasNext())
			{
				p = new R_r();
				scan.next();
				p.setID(scan.nextInt());
				p.setTimeStamp(scan.nextInt());
				p.setBurst(scan.nextInt());
				q1.add(p);
				q2.add(p);
				count++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		printRR(q1, q2, count, algo);
	}

	private static void processSJNNP(Scanner scan, String algo)
	{
		int count= 0;
			ArrayList<Sjnnp> q1 = new ArrayList<Sjnnp>();
			ArrayList<Sjnnp> q2 = new ArrayList<Sjnnp>();
			Sjnnp p;
			try
			{
				while (scan.hasNext())
				{
					p = new Sjnnp();
					scan.next();
					p.setID(scan.nextInt());
					p.setTimeStamp(scan.nextInt());
					p.setBurst(scan.nextInt());
					q1.add(p);
					q2.add(p);
					count++;
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			Collections.sort(q1);
			printSJNNP(q1, q2, count, algo);
	}

	private static void printFCFS(ArrayList<Fcfs> q1, ArrayList<Fcfs> q2, int c, String algo)
	{
		int clock = 0;
		String breaker = "---------------------------------------------------------";
		Fcfs p = new Fcfs();
		System.out.println("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
		System.out.println(breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
		for (Fcfs m: q2) System.out.println(m);
		System.out.print("\n");
		for (int i = 0; i < c; i++)
			{
				p = q1.get(i);
				clock += p.getBurst();
				System.out.println("CPU Request serviced during this clock interval: " + p);
				System.out.print(breaker);
				if (q1.indexOf(p) != q1.size()-1)
					{
						System.out.println("\nClock: "+ clock);
						System.out.println("Pending CPU request(s): ");
					}
				for (int x = i+1; x < c; x++)
					System.out.println(q1.get(x));
				System.out.print("\n");
			}
			printTATfcfs(q1);
			printWTfcfs(q1);
	}

	private static void printPNP(ArrayList<Pnp> q1, ArrayList<Pnp> q2, int c, String algo)
	{
		int clock = 0;
		String breaker = "---------------------------------------------------------";
		Pnp p = new Pnp();
		System.out.println("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
		System.out.println(breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
		for (Pnp m: q2) System.out.println(m);
		System.out.print("\n");
		for (int i = 0; i < c; i++)
			{
				p = q1.get(i);
				clock += p.getBurst();
				System.out.println("CPU Request serviced during this clock interval: " + p);
				System.out.print(breaker);
				if (q1.indexOf(p) != q1.size()-1)
					{
						System.out.println("\nClock: "+ clock);
						System.out.println(p+"\nPending CPU request(s): ");
					}
				for (int x = i+1; x < c; x++)
					System.out.println(q1.get(x));
				System.out.print("\n");
			}
			printTATpnp(q1);
			printWTpnp(q1);
	}

	private static void printSJNNP(ArrayList<Sjnnp> q1, ArrayList<Sjnnp> q2, int c, String algo)
	{
		int clock = 0;
		String breaker = "---------------------------------------------------------";
		Sjnnp p = new Sjnnp();
		System.out.println("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
		System.out.println(breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
		for (Sjnnp m: q2) System.out.println(m);
		System.out.print("\n");
		for (int i = 0; i < c; i++)
			{
				p = q1.get(i);
				clock += p.getBurst();
				System.out.println("CPU Request serviced during this clock interval: " + p);
				System.out.print(breaker);
				if (q1.indexOf(p) != q1.size()-1)
					{
						System.out.println("\nClock: "+ clock);
						System.out.println(p+"\nPending CPU request(s): ");
					}
				for (int x = i+1; x < c; x++)
					System.out.println(q1.get(x));
				System.out.print("\n");

			}
			printTATsjnnp(q1);
			printWTsjnnp(q1);
	}

	private static void printRR(ArrayList<R_r> q1, ArrayList<R_r> q2, int c, String algo)
	{
		int clock = 0;
		String breaker = "---------------------------------------------------------";
		R_r p = new R_r();
		System.out.println("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
		System.out.println(breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
		for (R_r m: q2) System.out.println(m);
		System.out.print("\n");
		for (int i = 0; i < c; i++)
			{
				p = q1.get(i);
				clock += p.getBurst();
				System.out.println("CPU Request serviced during this clock interval: " + p);
				System.out.print(breaker);
				if (q1.indexOf(p) != q1.size()-1)
					{
						System.out.println("\nClock: "+ clock);
						System.out.println(p+"\nPending CPU request(s): ");
					}
				for (int x = i+1; x < c; x++)
					System.out.println(q1.get(x));
				System.out.print("\n");

			}
			printTATrr(q1);
			printWTrr(q1);
	}



private static void printTATfcfs(ArrayList<Fcfs> q)
	{
		int exit = 0;
		System.out.println("Turn-Around Time Computations\n");
		double totalTAT = 0;
		double count=0;
		for (Fcfs p: q)
			{
				exit+= p.getBurst();
				totalTAT += exit;
				System.out.println("TAT(" + p.getID() + ") = " + exit);
				count++;
			}
		System.out.println("\nAverage TAT = " + (totalTAT/count));
		System.out.print("---------------------------------------------------------\n");
	}




private static void printTATpnp(ArrayList<Pnp> q)
	{
		int exit = 0;
		System.out.println("Turn-Around Time Computations\n");
		double totalTAT = 0;
		double count=0;
		for (Pnp p: q)
			{
				exit+= p.getBurst();
			  totalTAT += exit;
				System.out.println("TAT(" + p.getID() + ") = " + exit);
				count++;
			}
		System.out.println("\nAverage TAT = " + (totalTAT/count));
		System.out.print("---------------------------------------------------------\n");
	}

private static void printTATsjnnp(ArrayList<Sjnnp> q)
{
	int exit = 0;
	System.out.println("Turn-Around Time Computations\n");
	double totalTAT = 0;
	double count=0;
	for (Sjnnp p: q)
		{
			exit+= p.getBurst();
			totalTAT += exit;
			System.out.println("TAT(" + p.getID() + ") = " + exit);
			count++;
		}
	System.out.println("\nAverage TAT = " + (totalTAT/count));
	System.out.print("---------------------------------------------------------\n");
}

private static void printTATrr(ArrayList<R_r> q)
	{
		int exit = 0;
		System.out.println("Turn-Around Time Computations\n");
		double totalTAT = 0;
		double count=0;
		for (R_r p: q)
			{
				exit+= p.getBurst();
				totalTAT += exit;
				System.out.println("TAT(" + p.getID() + ") = " + exit);
				count++;
			}
		System.out.println("\nAverage TAT = " + (totalTAT/count));
		System.out.print("---------------------------------------------------------\n");
	}



	private static void printWTfcfs(ArrayList<Fcfs> q)
		{
			int exit = 0;
			System.out.println("Wait Time Computations\n");
			double totalWT = 0;
			double count = 0;
			for (Fcfs p: q)
				{
					exit+= p.getBurst();
					totalWT += (exit - p.getBurst());
					System.out.println("WT(" + p.getID() + ") = " + (exit - p.getBurst()));
					count++;
				}
			System.out.println("\nAverage WT = " + (totalWT/count));
		}


	private static void printWTpnp(ArrayList<Pnp> q)
		{
			int exit = 0;
			System.out.println("Wait Time Computations\n");
			double totalWT = 0;
			double count = 0;
			for (Pnp p: q)
				{
					exit+= p.getBurst();
					totalWT += (exit - p.getBurst());
					System.out.println("WT(" + p.getID() + ") = " + (exit - p.getBurst()));
					count++;
				}
			System.out.println("\nAverage WT = " + (totalWT/count));
		}


	private static void printWTsjnnp(ArrayList<Sjnnp> q)
		{
			int exit = 0;
			System.out.println("Wait Time Computations\n");
			double totalWT = 0;
			double count = 0;
			for (Sjnnp p: q)
				{
					exit+= p.getBurst();
					totalWT += (exit - p.getBurst());
					System.out.println("WT(" + p.getID() + ") = " + (exit - p.getBurst()));
					count++;
				}
			System.out.println("\nAverage WT = " + (totalWT/count));
		}

	private static void printWTrr(ArrayList<R_r> q)
		{
			int exit = 0;
			System.out.println("Wait Time Computations\n");
			double totalWT = 0;
			double count = 0;
			for (R_r p: q)
				{
					exit+= p.getBurst();
					totalWT += (exit - p.getBurst());
					System.out.println("WT(" + p.getID() + ") = " + (exit - p.getBurst()));
					count++;
				}
				System.out.println("\nAverage WT = " + (totalWT/count));
		}



}//end class
