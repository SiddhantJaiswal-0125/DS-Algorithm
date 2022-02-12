import java.io.*;
import java.util.*;

public class MinTravel {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for(int i =0;i<n;i++)
            for(int j =0;j<m;j++)
                mat[i][j]  = sc.nextInt();

        solve(mat, n,m);


    }
    static void solve(int mat[][], int n, int m)
    {
        int dp[][] = new int[n][m];
        dp[0][0] = mat[0][0];
        for(int i =0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(i==0 && j!=0)
                {
                    dp[i][j]= mat[i][j]+dp[i][j-1];

                }
                else if(j==0 && i !=0)
                {
                    dp[i][j]= mat[i][j]+dp[i-1][j];

                }
                else if(i!=0&& j!=0)
                    dp[i][j] = Integer.MAX_VALUE;

            }}

//            for(int i=0;i<n;i++) {
//                for (int j = 0; j < m; j++)
//                    System.out.print(dp[i][j]+"\t");
//                System.out.println();
//            }
            for(int i =1;i<n;i++)
                for(int j = 1;j<m;j++)
                {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + mat[i][j];
                }

//        for(int i=0;i<n;i++) {
//            for (int j = 0; j < m; j++)
//                System.out.print(dp[i][j]+"\t");
//            System.out.println();
//        }


        System.out.println(dp[n-1][m-1]);





    }

}