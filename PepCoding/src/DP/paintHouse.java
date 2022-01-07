package DP;

import java.util.Scanner;

public class paintHouse
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int data[][] =  new int[n][3];
         for(int i = 0;i<n;i++)
             for(int j  =0;j<3;j++)
                 data[i][j] = sc.nextInt();

         int ans = solve(data);
        System.out.println(ans);
    }
    static  int solve(int d[][])
    {
        int n = d.length;
        int dp[][] = new int[3][n];
        dp[0][0] = d[0][0];
        dp[1][0] = d[0][1];
        dp[2][0] = d[0][2];

        for(int i =1;i<n;i++)
        {
            dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + d[i][0];
            dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + d[i][1];
            dp[2][i]= Math.min(dp[1][i-1], dp[0][i-1]) + d[i][2];
        }


//        for(int i =0;i<3;i++)
//        {
//            for(int j = 0;j<n;j++)
//                System.out.print(dp[i][j]+"\t");
//            System.out.println();
//
//        }

        return  Math.min(dp[0][n-1], Math.min(dp[1][n-1],
                dp[2][n-1])
        );

    }
}
