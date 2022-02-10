package DP;


import java.util.*;

public class CountBinarySubstring
{


        public static void main(String[] args) throws Exception {
            // write your code here
            Scanner sc = new Scanner(System.in);
            int  n = sc.nextInt();
            int ans = solve(n);
            System.out.println(ans);
        }

        static int solve(int n )
        {
            int dp[][] = new int[2][n+1];
            dp[0][0] = 1;
            dp[1][0] = 1;

            for(int i = 1;i<=n;i++)
            {
                dp[0][i] = dp[0][i-1] + dp[1][i-1];
                dp[1][i] = dp[0][i-1];

            }
            return dp[0][n];
        }
    }

