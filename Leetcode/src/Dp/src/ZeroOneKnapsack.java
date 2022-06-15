import java.util.Scanner;

public class ZeroOneKnapsack
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int values[] = new int[n];
        int wt[] = new int[n];
        for(int i= 0;i<n;i++)
            values[i] = sc.nextInt();
        for(int i= 0;i<n;i++)
            wt[i] = sc.nextInt();
        int cap = sc.nextInt();
        int maxRes = _findMaximumValue(wt, values, cap,n );
        System.out.println(maxRes);

    }
    static  int _findMaximumValue(int wt[], int val[], int cap, int n)
    {
        int dp[][] = new int[n+1][cap+1];

//
        for(int  i = 1;i<=n;i++)
        {
            for(int j = 1;j<=cap;j++)
            {
                if(wt[i-1] <=j)
                    dp[i][j] = Math.max(val[i-1]
                            +
                            dp[i-1][j-wt[i-1]
                                    ], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return  dp[n][cap];



//        for(int i = 1;i<=n;i++)
//        {
//            for(int j =1;j<=cap;j++)
//            {
//
//                if(wt[i-1]<=j)
//                {
//                    dp[i][j] = Math.max(
//                            val[i-1]+
//                                    dp[i-1][j-wt[i-1]],
//                            dp[i-1][j]
//
//                    );
//
//
//                }
//                else
//                {
//                    dp[i][j] = dp[i-1][j];
//                }
//
//
//
//            }
//
//        }
//        return dp[n][cap];
    }
}
