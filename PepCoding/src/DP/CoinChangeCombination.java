package DP;

import java.util.*;

public class CoinChangeCombination
{

  
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i =0;i<n;i++)
        coins[i] = sc.nextInt();
        int tar = sc.nextInt();
        System.out.println(solve(coins, tar,n));
        sc.close();
    }

    static int solve(int coins[], int tar, int n)
    {
       int dp[] = new int [tar+1];

       dp[0]  = 1;

       for(int i =0;i<n;i++)
       {
            for(int j = coins[i] ;j<=tar;j++)
            {
                    dp[j]+= dp[j-coins[i]];
            }
       }

       return dp[tar];

    }

}
