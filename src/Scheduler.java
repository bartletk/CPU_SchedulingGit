import java.util.*;
import java.io.*;


public class Scheduler {

	/*
	 * Main method to read in a text file containing information related to n number of processes.
	 * Main determines which subMethod to call, based on which algorithm is specified in the input file.
	 */
	public static void main(String[] args)
	{


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

	/*
	 * Processes fcfs input file.
	 * Then calls printFcfs() to print out the pertinent information.
	 * @param scan a scanner containing the input file.
	 * @param algo the algorithm.
	 */
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

	/*
	 * Processes pnp input file.
	 * Then calls printPnp() to print out the pertinent information.
	 * @param scan a scanner containing the input file.
	 * @param algo the algorithm.
	 */
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

	/*
	 * Processes sjnnp input file.
	 * Then calls printSjnnp() to print out the pertinent information.
	 * @param scan a scanner containing the input file.
	 * @param algo the algorithm.
	 */
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

	/*
	 * Processes rr input file.
	 * Then calls printRR() to print out the pertinent information.
	 * @param scan a scanner containing the input file.
	 * @param algo the algorithm.
	 */
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

	
	/*
	 * Prints out the results of processing which occurred in processFcfs() method.
	 * Contains neither turn-around time nor wait time.
	 * Calls printTATfcfs() to process and print turn-around time.
	 * Calls printWTfcfs() to process and print wait time.
	 * @param q1 contains ordered processes.
	 * @param q2 contains processes in original order.
	 * @param c the count of processes in question.
	 * @param algo the algorithm being used.
	 */
	private static void printFCFS(ArrayList<Fcfs> q1, ArrayList<Fcfs> q2, int c, String algo)
	{
		String outText = "fcfs_out.txt";
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(outText));
			int clock = 0;
			String breaker = "---------------------------------------------------------";
			Fcfs p = new Fcfs();
			writer.write("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
			writer.append("\n"+breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
			for (Fcfs m: q2) writer.write("\n"+m);
			writer.newLine();
			for (int i = 0; i < c; i++)
				{
					p = q1.get(i);
					clock += p.getBurst();
					writer.append("\nCPU Request serviced during this clock interval: " + p);
					writer.newLine();
					writer.append(breaker);
					if (q1.indexOf(p) != q1.size()-1)
						{
							writer.append("\nClock: "+ clock);
							writer.append("\nPending CPU request(s): ");
						}
					for (int x = i+1; x < c; x++)
						writer.append("\n"+q1.get(x));
					writer.newLine();;
				}
			printTATfcfs(q1, writer);
			printWTfcfs(q1, writer);
			
		}
		catch(Exception e) 
		{
			System.out.print(e.getMessage());
		}
	}

	/*
	 * Prints out the results of processing which occurred in processPnp() method.
	 * Contains neither turn-around time nor wait time.
	 * Calls printTATpnp() to process and print turn-around time.
	 * Calls printWTpnp() to process and print wait time.
	 * @param q1 contains ordered processes.
	 * @param q2 contains processes in original order.
	 * @param c the count of processes in question.
	 * @param algo the algorithm being used.
	 */
	private static void printPNP(ArrayList<Pnp> q1, ArrayList<Pnp> q2, int c, String algo)
	{
		String outText = "pnp_out.txt";
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(outText));
			int clock = 0;
			String breaker = "---------------------------------------------------------";
			Pnp p = new Pnp();
			writer.write("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
			writer.append("\n"+breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
			for (Pnp m: q2) writer.write("\n"+m);
			writer.newLine();
			for (int i = 0; i < c; i++)
				{
					p = q1.get(i);
					clock += p.getBurst();
					writer.append("\nCPU Request serviced during this clock interval: " + p);
					writer.newLine();
					writer.append(breaker);
					if (q1.indexOf(p) != q1.size()-1)
						{
							writer.append("\nClock: "+ clock);
							writer.append("\nPending CPU request(s): ");
						}
					for (int x = i+1; x < c; x++)
						writer.append("\n"+q1.get(x));
					writer.newLine();;
				}
			printTATpnp(q1, writer);
			printWTpnp(q1, writer);
			
		}
		catch(Exception e) 
		{
			System.out.print(e.getMessage());
		}
	}

	/*
	 * Prints out the results of processing which occurred in processSjnnp() method.
	 * Contains neither turn-around time nor wait time.
	 * Calls printTATsjnnp() to process and print turn-around time.
	 * Calls printWTsjnnp() to process and print wait time.
	 * @param q1 contains ordered processes.
	 * @param q2 contains processes in original order.
	 * @param c the count of processes in question.
	 * @param algo the algorithm being used.
	 */
	private static void printSJNNP(ArrayList<Sjnnp> q1, ArrayList<Sjnnp> q2, int c, String algo)
	{
		String outText = "sjnnp_out.txt";
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(outText));
			int clock = 0;
			String breaker = "---------------------------------------------------------";
			Sjnnp p = new Sjnnp();
			writer.write("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
			writer.append("\n"+breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
			for (Sjnnp m: q2) writer.write("\n"+m);
			writer.newLine();
			for (int i = 0; i < c; i++)
				{
					p = q1.get(i);
					clock += p.getBurst();
					writer.append("\nCPU Request serviced during this clock interval: " + p);
					writer.newLine();
					writer.append(breaker);
					if (q1.indexOf(p) != q1.size()-1)
						{
							writer.append("\nClock: "+ clock);
							writer.append("\nPending CPU request(s): ");
						}
					for (int x = i+1; x < c; x++)
						writer.append("\n"+q1.get(x));
					writer.newLine();;
				}
			printTATsjnnp(q1, writer);
			printWTsjnnp(q1, writer);
			
		}
		catch(Exception e) 
		{
			System.out.print(e.getMessage());
		}
	}

	/*
	 * Prints out the results of processing which occurred in processRR() method.
	 * Contains neither turn-around time nor wait time.
	 * Calls printTATrr() to process and print turn-around time.
	 * Calls printWTrr() to process and print wait time.
	 * @param q1 contains ordered processes.
	 * @param q2 contains processes in original order.
	 * @param c the count of processes in question.
	 * @param algo the algorithm being used.
	 */
	private static void printRR(ArrayList<R_r> q1, ArrayList<R_r> q2, int c, String algo)
	{
		String outText = "rr_out.txt";
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(outText));
			int clock = 0;
			String breaker = "---------------------------------------------------------";
			R_r p = new R_r();
			writer.write("CPU sheduling algorithm: " + algo + "\nTotal number of CPU requests: "+c);
			writer.append("\n"+breaker + "\nClock: " +clock + "\nPending CPU request(s): ");
			for (R_r m: q2) writer.write("\n"+m);
			writer.newLine();
			for (int i = 0; i < c; i++)
				{
					p = q1.get(i);
					clock += p.getBurst();
					writer.append("\nCPU Request serviced during this clock interval: " + p);
					writer.newLine();
					writer.append(breaker);
					if (q1.indexOf(p) != q1.size()-1)
						{
							writer.append("\nClock: "+ clock);
							writer.append("\nPending CPU request(s): ");
						}
					for (int x = i+1; x < c; x++)
						writer.append("\n"+q1.get(x));
					writer.newLine();;
				}
			printTATrr(q1, writer);
			printWTrr(q1, writer);
			
		}
		catch(Exception e) 
		{
			System.out.print(e.getMessage());
		}
	}


	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted Fcfs objects.
	 * @param writer writes to an output file.
	 */
	private static void printTATfcfs(ArrayList<Fcfs> q, BufferedWriter writer)
		{
			try 
			{
				int exit = 0;
				writer.append("Turn-Around Time Computations\n");
				double totalTAT = 0;
				double count=0;
				for (Fcfs p: q)
					{
						exit+= p.getBurst();
						totalTAT += exit;
						writer.append("\nTAT(" + p.getID() + ") = " + exit);
						count++;
					}
				writer.append("\n\nAverage TAT = " + (totalTAT/count));
				writer.append("\n---------------------------------------------------------");
				
			}
			catch(Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}



	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted Pnp objects.
	 * @param writer writes to an output file.
	 */
	private static void printTATpnp(ArrayList<Pnp> q, BufferedWriter writer)
		{
			try 
			{
				int exit = 0;
				writer.append("Turn-Around Time Computations\n");
				double totalTAT = 0;
				double count=0;
				for (Pnp p: q)
					{
						exit+= p.getBurst();
						totalTAT += exit;
						writer.append("\nTAT(" + p.getID() + ") = " + exit);
						count++;
					}
				writer.append("\n\nAverage TAT = " + (totalTAT/count));
				writer.append("\n---------------------------------------------------------");
			}
			catch(Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}

	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted Sjnnp objects.
	 * @param writer writes to an output file.
	 */
	private static void printTATsjnnp(ArrayList<Sjnnp> q, BufferedWriter writer)
	{
			try 
			{
				int exit = 0;
				writer.append("Turn-Around Time Computations\n");
				double totalTAT = 0;
				double count=0;
				for (Sjnnp p: q)
					{
						exit+= p.getBurst();
						totalTAT += exit;
						writer.append("\nTAT(" + p.getID() + ") = " + exit);
						count++;
					}
				writer.append("\n\nAverage TAT = " + (totalTAT/count));
				writer.append("\n---------------------------------------------------------");
			}
			catch(Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}

	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted R_r objects.
	 * @param writer writes to an ouput file.
	 */
	private static void printTATrr(ArrayList<R_r> q, BufferedWriter writer)
		{
			try 
			{
				int exit = 0;
				writer.append("Turn-Around Time Computations\n");
				double totalTAT = 0;
				double count=0;
				for (R_r p: q)
					{
						exit+= p.getBurst();
						totalTAT += exit;
						writer.append("\nTAT(" + p.getID() + ") = " + exit);
						count++;
					}
				writer.append("\n\nAverage TAT = " + (totalTAT/count));
				writer.append("\n---------------------------------------------------------");
			}
			catch(Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}

	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted Fcfs objects.
	 * @param writer writes to an output file.
	 */
	private static void printWTfcfs(ArrayList<Fcfs> q, BufferedWriter writer)
		{
			try 
			{
				int exit = 0;
				writer.append("\nWait Time Computations\n");
				double totalWT = 0;
				double count = 0;
				for (Fcfs p: q)
					{
						exit+= p.getBurst();
						totalWT += (exit - p.getBurst());
						writer.write("\nWT(" + p.getID() + ") = " + (exit - p.getBurst()));
						count++;
					}
				writer.write("\n\nAverage WT = " + (totalWT/count)+ "\n");
				writer.close();
				System.out.println("fcfs complete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		
		}

	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted Pnp objects.
	 * @param writer writes to an output file.
	 */
	private static void printWTpnp(ArrayList<Pnp> q, BufferedWriter writer)
		{
			try 
			{
				int exit = 0;
				writer.append("\nWait Time Computations\n");
				double totalWT = 0;
				double count = 0;
				for (Pnp p: q)
					{
						exit+= p.getBurst();
						totalWT += (exit - p.getBurst());
						writer.write("\nWT(" + p.getID() + ") = " + (exit - p.getBurst()));
						count++;
					}
				writer.write("\n\nAverage WT = " + (totalWT/count) + "\n");
				writer.close();
				System.out.println("pnp complete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted Sjnnp objects.
	 * @param writer writes to an output file.
	 */
	private static void printWTsjnnp(ArrayList<Sjnnp> q, BufferedWriter writer)
		{
			try 
			{
				int exit = 0;
				writer.append("\nWait Time Computations\n");
				double totalWT = 0;
				double count = 0;
				for (Sjnnp p: q)
					{
						exit+= p.getBurst();
						totalWT += (exit - p.getBurst());
						writer.write("\nWT(" + p.getID() + ") = " + (exit - p.getBurst()));
						count++;
					}
				writer.write("\n\nAverage WT = " + (totalWT/count)+"\n");
				writer.close();
				System.out.println("sjnnp complete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	/*
	 * Processes and prints turn-around time.
	 * @param q contains sorted R_r objects.
	 * @param writer writes to an output file.
	 */
	private static void printWTrr(ArrayList<R_r> q, BufferedWriter writer)
		{
			try 
			{
				int exit = 0;
				writer.append("\nWait Time Computations\n");
				double totalWT = 0;
				double count = 0;
				for (R_r p: q)
					{
						exit+= p.getBurst();
						totalWT += (exit - p.getBurst());
						writer.write("\nWT(" + p.getID() + ") = " + (exit - p.getBurst()));
						count++;
					}
				writer.write("\n\nAverage WT = " + (totalWT/count) + "\n");
				writer.close();
				System.out.println("rr complete");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}



}//end class