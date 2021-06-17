public class FLN{
	String firstName;
	String lastName;
	
	FLN()
	{
		firstName = "Alina";
		lastName = "Popa";
	}
	
	FLN(String fn, String ln)
	{
		firstName = fn;
		lastName = ln;
	}
	
	public String toString()
	{
		return "prenume : " + this.firstName + "\n" +
				"nume : " + this.lastName + "\n";
	}
	
	public static void main(String[] args)
	{
		FLN person1 = new FLN("Sanda", "Popescu");
		System.out.print(person1);
	}
}
