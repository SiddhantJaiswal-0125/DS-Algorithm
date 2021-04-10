import java.util.Scanner;

public class FriendsPairingProblem {
    public static void main(String[] args) 
    {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        long dp[]  = new long[n+1];
        for(int i =0;i<=n;i++)
        {
            if(i<=2)
            dp[i] = i;
            else
            dp[i] = add(dp[i-1], mul(i-1, dp[i-2]));
            //  dp[i] = dp[i-1] + (i-1)*dp[i-2];
 
        }
        System.out.println(dp[n]);
        sc.close();
    }
    static long mod = 1000000007;   
    static long mul(long a , long b)
    {
        return (a%mod * b%mod)%mod;
    }
    static long add(long a , long b)
    {
        return (a%mod + b%mod)%mod;
    }
}
