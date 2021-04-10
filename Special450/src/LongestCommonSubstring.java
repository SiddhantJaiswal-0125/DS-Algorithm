import java.util.Scanner;

public class LongestCommonSubstring
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int ans = solve(s1, s2);
        System.out.println(ans);

    }
    static  int solve(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];
        int max = -1;
        for(int i =0;i<n+1;i++)
            for(int j =0;j<m+1;j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else
                    {
                        if(s1.charAt(i-1)==s2.charAt(j-1))
                        {
                            dp[i][j] = 1+dp[i-1][j-1];

                        }
                    else
                        dp[i][j] = 0;

                    if(dp[i][j]>max)
                        max = dp[i][j];
                    }



            }
        return  max;

    }
}
