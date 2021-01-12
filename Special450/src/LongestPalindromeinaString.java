import java.util.Scanner;

public class LongestPalindromeinaString
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-->0) {
            String s = sc.next();
            solve(s);
        }
    }
    static  void solve(String s)
    {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for(int i = 0;i<n;i++)
            dp[i][i] = true;
        int maxlen = 1;
        int start = 0;
        for(int i = 0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i + 1] = true;
                maxlen = 2;
                start = i;
            }
        }
        for(int k = 3;k<=n;k++)
        {
            for(int i = 0; i<n-k+1;i++)
            {
                int j = i+k-1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j))
                {
                    dp[i][j] = true;
                    if(k>maxlen)
                    {
                        maxlen = k;
                        start = i;

                    }
                }
            }
        }


        print(s,start,start+ maxlen-1);









    }
    static void print(String s , int i , int len)
    {
        System.out.println(
                s.substring(
                        i, len + 1));
    }
}
