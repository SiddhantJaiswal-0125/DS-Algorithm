import java.util.*;

public class LongestRepeatingSubsequence
{
    public static void main(String[] args) {
         Scanner sc = new Scanner (System.in);
         int test  = sc.nextInt();
         while(test-->0)
         {
             int n = sc.nextInt();
             String s = sc.next();
             int ans = solve(s,n);
             System.out.println(ans);

         }
    }
    static  int solve(String s,int n)
    {
        int dp[][] = new int[n+1][n+1];
        for(int i =0;i<n+1;i++)
        {
            for(int j = 0;j<n+1;j++)
                dp[i][j] = 0;
        }

        for(int i= 1;i<n+1;i++)
        {
            for(int j =1;j<n+1;j++)
            {

                if(s.charAt(i-1)==s.charAt(j-1) && i!=j)
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }



            }

        }

    return dp[n][n];
    }

}
