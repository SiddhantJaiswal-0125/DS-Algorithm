package DP;

import java.util.Scanner;

public class TilingM1Tiles
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans  = solve(n, m);
        System.out.println(ans);
    }
    static int solve(int n, int m)
    {
     if (m>=n)
            return 1;
     int dp[]  = new int[n+1];
     dp[0] = 1;
     for(int i =1 ;i<m;i++)
         dp[i] = 1;

     for(int i = m;i<=n;i++)
     {
         dp[i] = dp[i-1] + dp[i-m] ;
     }
     return dp[n];


    }


}
