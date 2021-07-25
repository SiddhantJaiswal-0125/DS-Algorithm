package DP;

import java.util.Scanner;

public class MinCostInMazeTraversal
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  r = sc.nextInt();
        int  c = sc.nextInt();
        int mat[][] = new int[r][c];
        for(int i  = 0;i<r;i++)
            for(int j = 0; j < c; j++)
                mat[i][j] = sc.nextInt();

        int mincost = findMinCostTraversal(mat, r, c);
        System.out.println(mincost);

    }
    static int findMinCostTraversal(int mat[][], int r, int c)
    {
        int dp[][] = new int[r][c];
        dp[0][0] = 0;
        for(int i =1;i<c;i++)
            dp[0][i] = dp[0][i-1]+mat[0][i];
        for(int  i  =1;i<c;i++)
            dp[i][0] = dp[i-1][0] + mat[i][0];
        for(int i = 1;i<r;i++)
            for(int j =1;j<c;j++)
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+mat[i][j];


            return dp[r-1][c-1];

    }

}
