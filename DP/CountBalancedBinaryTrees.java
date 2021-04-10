import java.util.*;
public class CountBalancedBinaryTrees
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		int n = sc.nextInt();
		long ans =  countBT(n);
		System.out.println(ans);
		}
		
		sc.close();
	
	}
	static long mod = 1000000007;
	static long dp[];
	static long countBT(int h)
{
        // code here
		dp = new long[h+1];
		return solve(h);

    }
	
	static long solve(int h )
	{
		if(h==0 || h==1)
		return 1;
		if(dp[h]!=0)
		return dp[h];
		long a1 = mul(2,solve(h-2));
		long a2 = add(a1,solve(h-1));
		long a3 = mul(solve(h-1),a2);
		
		dp[h] = a3;
		return dp[h];
	}

	static long add(long a, long b)
	{
		return (a%mod + b%mod) %mod;
	
	}
	static long mul(long a, long b)
	{
		return (a%mod * b%mod) %mod;
	
	}
	
}
