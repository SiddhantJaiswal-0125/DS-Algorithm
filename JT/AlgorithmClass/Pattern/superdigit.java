import java.util.*;
class superdigit
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(findsuper(n));



	}
	static int findsuper(int n )
	{
		int res = 0;
		while(n>0)
		{
			res += n%10;
			n/=10;
		}
		if(res>9)
		return findsuper(res);
		else 
		return res;	
		

	}	
}