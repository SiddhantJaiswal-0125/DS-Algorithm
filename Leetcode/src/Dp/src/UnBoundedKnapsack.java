import java.util.Scanner;

public class UnBoundedKnapsack
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
        int dp[] = new int[cap+1];
        for(int  i = 1;i<=cap;i++)
            for(int j = 0;j<n;j++)
                if(wt[j]<=i)
                    dp[i] = Math.max(dp[i], val[j]+ dp[i-wt[j]]);




        return  dp[cap];

    }
}
