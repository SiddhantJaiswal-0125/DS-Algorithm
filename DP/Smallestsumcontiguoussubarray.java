import java.util.*;
class Smallestsumcontiguoussubarray
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];

		for(int i =0;i<n;i++)
		a[i]= sc.nextInt();
		int ans = solve(a,n);
		System.out.println(ans);
		
		sc.close();	
	}
		
	static int solve(int a[], int n)	
	{
		int cur_min = 0;
		int min = Integer.MAX_VALUE;
		for(int i : a)
		{
			cur_min += i;
			if(cur_min>0)
			cur_min = 0;
			if(cur_min<min)
			min = cur_min ;

		}
	return min;

	}
}