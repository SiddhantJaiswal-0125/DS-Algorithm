class demo2
{
	public static void main(String args[])
	{
		/*(int a = 153;
		if(armstrong(a)==a)
		System.out.println(a+ " is Armstrong Number ");
		else
		System.out.println(a+ " is Not Armstrong Number ");*/
		


		for(String s: args)
		{
System.out.println(s );

			}
		
		




	}
		
		
	static int armstrong(int a)
	{
			
		int ans = 0;
		while(a>0)
		{
			int  r = a%10;	
			ans = ans +(r*r*r);
			a/=10;
			
		}
		return ans ;
	
	}


}