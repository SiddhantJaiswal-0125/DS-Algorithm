import java.util.Scanner;

public class permutation_Coefficient
{
    static  int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new int[n+1][k+1];
        int ans1 = solvebyDP(n,k);

        long ans2 = solvebyIterative(n,k);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    static int solvebyDP(int n , int k)
    {
        if(k==0)
            return  1;
        if(k>n)
            return 0;

        if(dp[n][k]!=0)
            return dp[n][k];

        dp[n][k]  = solvebyDP(n-1,k)+ (k * solvebyDP(n-1,k-1));
        return  dp[n][k];
    }
    static  long solvebyIterative(int n , int k )
    {
        long fact[]  = new long [n+1];
        fact[0] =1;
        fact [1]  = 1;
        for(int i =2;i<=n;i++)
            fact[i]  = i*fact[i-1];

        return fact[n]/fact[n-k];
    }

}
