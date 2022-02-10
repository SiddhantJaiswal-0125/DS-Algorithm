package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TargetSumSubsets
{
    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int coins[] = new int[n];
        for(int i =0;i<n;i++)
            coins[i] = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        System.out.println(check(coins, n, target));


    }
    static boolean check(int coins[], int n, int target)
    {
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i = 0;i<n+1;i++)
            dp[i][0] = true;
        for(int  j  = 0;j<target+1;j++)
            dp[0][j] = false;

        for(int  i = 1;i<=n;i++)
        {
            //for each element
            for(int j  = coins[i-1];j<=target;j++)
            {
                dp[i][j] = dp[i-1][j-coins[i-1]] || dp[i-1][j];
            }
        }



        return  dp[n][target];


    }

}
