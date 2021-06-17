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
				"nume : " + this.lastName + "\n";
	}
	
	
	// create a FirstLastName object, print it
	
	public static void main(String[] args)
	{
		FLN person1 = new FLN("Sanda", "Popescu");
		System.out.print(person1);
	}
}
