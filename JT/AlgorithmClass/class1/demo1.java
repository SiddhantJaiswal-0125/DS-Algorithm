//reverse of a number 
class demo1
{
	public static void main(String [] args)
	{
		int a = 25;
		int rev = reverse(a);
		System.out.println("Initial Number : "+a);	
		System.out.println("Reverse Number : "+rev);		
	}

	static int reverse(int a)
	{
		int rev = 0;
		while(a>0)
		{
			rev = rev *10 + a%10;
			a/=10;	
		}

	return rev;
	}
}