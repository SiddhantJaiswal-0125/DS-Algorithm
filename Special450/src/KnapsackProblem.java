import java.util.Scanner;

public class KnapsackProblem
{
    //0 1 KnapSack Problem\
    static  int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int val[] = new int[n];
        int we[] = new int[n];
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            we[i] = sc.nextInt();

        dp = new int[w + 1][n + 1];
        for (int i = 0; i <= w; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;
        System.out.println(knapSack(w, we, val, n));

    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        dp = new int [W+1][n+1];
        for(int i =0;i<=W;i++)
            for(int j = 0;j<=n;j++)
                dp[i][j]= -1;

        return solve(W,wt,val,n);




    }
    static int solve(int W, int wt[], int val[], int n)
    {
        if( W==0)
            return 0;
        if(n==0 )
            return 0;


        if(dp[W][n]!=-1)
            return dp[W][n];


        if(wt[n-1]<=W)
        {

            dp[W][n] = max(val[n-1] + solve (W-wt[n-1], wt, val, n-1), solve(W,wt,val, n-1)
            );


        }
        else
            dp[W][n] =  solve(W,wt,val, n-1);
        return dp[W][n];


    }
//
//    static int knapSack(int W, int wt[], int val[], int n)
//    {
//        if( W==0)
//            return 0;
//        if(n==0 )
//            return 0;
//
//
//        if(dp[W][n]!=-1)
//            return dp[W][n];
//
//
//        if(wt[n-1]<=W)
//        {
//
//            dp[W][n] =
//                    max(val[n-1] + knapSack (W-wt[n-1], wt, val, n-1), knapSack(W,wt,val, n-1)
//                    );
//
//
//        }
//        else
//            dp[W][n] =  knapSack(W,wt,val, n-1);
//        return dp[W][n];
//
//    }
    static int max(int a, int b)
    {
        return a>b?a:b;
    }
}
