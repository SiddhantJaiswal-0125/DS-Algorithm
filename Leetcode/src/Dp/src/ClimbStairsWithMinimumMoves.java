import java.util.Arrays;
import java.util.Scanner;

public class ClimbStairsWithMinimumMoves
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n; i++)
            ar[i] = sc.nextInt();
        int ans = getMinimumMoves(n,ar);
        System.out.println(ans);

    }
    static int getMinimumMoves(int n, int ar[])
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i =0;i<n;i++)
        {
            for(int j = 1;j<=ar[i] && i+j<=n; j++)
            {
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[n];
    }

}
