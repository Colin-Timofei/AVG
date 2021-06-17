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
		return "prenume : " + this.firstName + "\n" +
				"nume : " + this.lastName;
	}
	
	
	// unknown object array size, use arraylist
	// read from file, insert in array
	// print one random name
	
	public static void main(String[] args)
	{
		ArrayList<FLN> fln = new ArrayList<FLN>();
		int rn, size = 0;
		Random rand = new Random();
		
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
		
		rn = rand.nextInt(size);
		System.out.println(fln.get(rn));
	}
}
