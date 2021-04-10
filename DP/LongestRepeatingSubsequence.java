import java.util.Scanner;

public class LongestRepeatingSubsequence 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        int ans = solve(s1);
        System.out.println(ans);
        sc.close();

    }
    static int solve(String s1)
    {
        String s2 = new String (s1);
        int n = s1.length();
        int dp[][] = new int [n+1][n+1];
        for(int i =1;i<=n;i++)
        {
            for(int j =1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1) && i!=j)
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

            }
    }
    return dp[n][n];
    }
}
