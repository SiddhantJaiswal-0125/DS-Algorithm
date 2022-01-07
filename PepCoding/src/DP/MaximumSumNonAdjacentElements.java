package DP;

import java.util.Scanner;

public class MaximumSumNonAdjacentElements
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i  =0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = _solve(ar);
        System.out.println(ans);
    }
    static int _solve(int ar[])
    {
        int  size = ar.length;
        int dp[][] = new int[2][size+1];
        for(int i = 1;i<=size;i++)
        {
            dp[0][i] = Math.max(dp[1][i-1]+ar[i-1],
                    dp[0][i-1]);
            dp[1][i] = dp[0][i-1];


        }
        return Math.max(dp[0][size], dp[1][size]);
//        return ar[size];
    }
}
