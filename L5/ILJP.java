public class ILJP {
	
	// function to pause the execution for a few miliseconds
	
	public static void waitABit(int ms)
	{
		try
		{
		    Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	
	// function to print the string char by char, with a short pause
	// if there will be any space chars, the program will change the delay time
	
	public static void fasterEachWord(String s)
	{
		int len = s.length();
		char ch;
		int pause = 200;
		
		for(int i = 0; i < len; i++ )
		{
			ch = s.charAt(i);
			if (ch == ' ')
				{
					waitABit(500);
					pause = pause >= 50 ? pause - 50 : 200;
				}
			System.out.print(ch);
			waitABit(pause);
		}
	}


	// main function, test with any sentences

	public static void main(String[] args) {
	
		String iljp = new String("I love java programming");
		fasterEachWord(iljp);
	}
}
