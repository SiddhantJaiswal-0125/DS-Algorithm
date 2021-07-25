package DP;

import java.util.*;
public class GoldMine
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for(int i =0;i<n;i++)
            for(int j = 0;j<m;j++)
                mat[i][j] = sc.nextInt();
        int ans = findMinDistanceGoldmine(mat, n, m);
        System.out.println(ans);
    }
    static int findMinDistanceGoldmine(int mat[][], int n , int m)
    {
        int dp[][] = new int[n][m];


        for(int i =0;i<n;i++)
            dp[i][0] = mat[i][0];

        for(int j = 1;j<m;j++)
        {
            for(int i  = 0;i<n;i++)
            {
                if(i==0)
                {
                    dp[i][j] = Math.max(dp[i+1][j-1], dp[i][j-1])+mat[i][j];
                }
                else if(i==n-1)
                {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1])+mat[i][j];
                }
                else
                {

                    dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i][j-1]),dp[i+1][j-1] )  +mat[i][j];

                }


            }
        }




        int min = Integer.MIN_VALUE;
        for(int i =0;i<n;i++)
            min=Math.max(min, dp[i][m-1]);
//
        return min;
//        return dp[n-1][m-1];
    }
}
