import java.util.*;
import java.io.*;
import java.util.Random;

public class FLN{
	
	// create object with 2 string variables
	// first name and last name
	
	String firstName;
	String lastName;
	
	
	// default constructor
	
	FLN()
	{
		firstName = "Alina";
		lastName = "Popa";
	}
	
	
	// constructor we'll use, obtain variables from main program
	
	FLN(String fn, String ln)
	{
		firstName = fn;
		lastName = ln;
	}
	
	
	// this function is needed to show the object details in own way
	
	public String toString()
	{
		return "Generam nume" + "\n" +
				"-------------------" + "\n" +
				"prenume : " + this.firstName + "\n" +
				"nume : " + this.lastName + "\n";
	}
	
	
	// unknown object array size, use arraylist
	// read from file, insert in array
	// print a random name until we get an answer different from da
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		Scanner sc= new Scanner(System.in);
		
		ArrayList<FLN> fln = new ArrayList<FLN>();
		int rn, size = 0;
		String option;
		
		try ( BufferedReader br = new BufferedReader(new FileReader("a.txt")) ) {
			String st, fn, ln;
			int cat;
			
			while ((st = br.readLine()) != null) {
				cat = st.indexOf(",");
				if(cat != -1){
					ln = st.substring(0, cat);
					fn = st.substring(cat + 2, st.length());
					fln.add(new FLN(fn, ln));
					size++;
				}
			}
		} catch(IOException e) { System.out.println("I/O Error: " + e); }
		
		do{
			System.out.println();
			rn = rand.nextInt(size);
			System.out.println(fln.get(rn));
			System.out.println("Inca o data ? (da/nu)");
			option = sc.nextLine();
		} while (option.equals("da"));
	}
}