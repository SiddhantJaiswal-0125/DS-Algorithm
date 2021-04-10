import java.util.Scanner;

public class BinaomialCoefficiant
{
    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        dp = new int[n+1][r+1];
        int mod = sc.nextInt();
        int ans = solve(n,r);
        System.out.println(ans);
    }
    static int solve(int n , int r)
    {
        int mod = 1000000007;
        if(r>n)
            return 0;
        if(r==0 || r==n)
            return  1;


        if(dp[n][r]!=0)
            return dp[n][r];


        dp[n][r] = addmodulo(solve(n-1,r-1) ,solve(n-1,r),mod);
        return  dp[n][r];

    }
    static int addmodulo(int  a,int b, int mod)
    {
        return  (a%mod + b%mod)%mod;
    }


}
