public class ILJP {
	
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

	public static void main(String[] args) {
	
		String iljp = new String("I love java programming");
		fasterEachWord(iljp);
	}
}
