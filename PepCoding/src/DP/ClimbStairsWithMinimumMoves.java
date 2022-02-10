package DP;//package DP;
import java.util.Scanner;

public class ClimbStairsWithMinimumMoves
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i  = 0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans =new ClimbStairsWithMinimumMoves().
                findMinimumMoves(ar, n);
        System.out.println(ans);
    }
    int findMinimumMoves(int ar[], int n)
    {
        Integer dp[] = new Integer[n+1];
        dp[n] = new Integer(0);
//

        for(int i = n-1;i>=0;i--)
        {
            int min = Integer.MAX_VALUE;
            int j = 1;
            if(ar[i]==0)
                continue;
            while(j<=ar[i])
            {
                if(i+j>n)
                    break;

                if(dp[i+j]!=null)
                    min = Math.min(min, dp[i+j]);

                j++;
            }
            if(min!=Integer.MAX_VALUE)
            {
                dp[i] = new Integer(min)+1;
            }
         else
             dp[i] = null;
        }
        return  dp[0];
    }


}
