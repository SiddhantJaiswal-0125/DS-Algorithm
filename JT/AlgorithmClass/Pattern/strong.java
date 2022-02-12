import java.util.*;
class strong
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = isStrong(n);
		if(n==res)
		System.out.println("Strong Number");
		else
		System.out.println("Not Strong");
		


	}	

	static int isStrong(int n)
	{
	int sum =0;
	while(n>0)
	{
		sum += findfac(n%10);
		n/=10;

	
	}	
	
	return sum;
	}
	
	static	int findfac(int  n )
	{
	int res = 1;
	for(int i =2;i<=n;i++)
		res *=i;
	return res;


	
	}


}