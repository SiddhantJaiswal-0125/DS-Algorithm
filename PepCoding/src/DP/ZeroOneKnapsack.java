package  DP;
import java.io.*;
import java.util.*;

class Zero {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        for(int i = 0;i<n;i++)
            val[i] = sc.nextInt();
        for(int i =0;i<n;i++)
            wt[i] = sc.nextInt();

        int cap = sc.nextInt();
        int ans = solve(val, wt,cap, n );
        System.out.println(ans);
    }

    static int solve(int val[], int wt[], int cap, int n)
    {
        if(n==0)
            return 0;



        int dp[][] = new int[n+1][cap+1];

        for(int i = 1;i<=n;i++)
        {
            for(int j =1;j<=cap;j++)
            {

                if(wt[i-1]<=j)
                {
                    dp[i][j] = max(
                            val[i-1]+
                            dp[i][j-wt[i-1]],
                           dp[i-1][j]

                    );


                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }



            }

        }



//        for(int i =1;i<=cap;i++)
//        {
//            for(int j  =1;j<=n;j++)
//            {
//
//                if(wt[j-1]<=i)
//                {
//
//                    dp[i][j] = max(val[j-1]+ dp[i-wt[j-1]][j],
//                            dp[i][j-1]
//                    );
//                }
//                else
//                {
//
//                    dp[i][j] = dp[i][j-1];
//
//                }
//
//            }
//        }
        return dp[n][cap];
    }

    static int max (int a, int b)
    {
        return a>b?a:b;
    }

}