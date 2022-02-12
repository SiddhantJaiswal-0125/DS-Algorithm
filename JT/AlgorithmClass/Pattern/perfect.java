import java.util.*;
class perfect 
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = findcofacsum(n);
		if(n==res)
		System.out.println("Perfect Number");
		else
		System.out.println("Not Perfect");
		


	}	

	static int findcofacsum(int n)
	{
	int sum =0;
	for(int i =1;i<n;i++)
	{
	if(n%i==0)
	sum+=i;
	
	}
	return sum;
	}


}