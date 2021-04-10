import java.util.Scanner;

public class LCSin3String 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n,m,k;
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            String s1 = sc.next();

            String s2 = sc.next();

            String s3 = sc.next();
            // System.out.println(s1);
            // System.out.println(s2);
            // System.out.println(s3);

            int ans = solve(n,m,k,s1,s2,s3);
            System.out.println(ans);
        }
        sc.close();
    }
    static int solve(int n , int m , int k , String s1 , String s2 , String s3)
    {
            int dp[][][] = new int[n+1][m+1][k+1];

            for(int i =1;i<=n;i++)
            {
                for(int j =1;j<=m;j++)
                {
                    for(int l =1;l<=k;l++)
                    {

                        if(s1.charAt(i-1)==s2.charAt(j-1)&& s2.charAt(j-1) ==s3.charAt(l-1))
                          dp[i][j][l] = dp[i-1][j-1][l-1]+1;
                        else
                        dp[i][j][l] = max(dp[i-1][j][l], dp[i][j-1][l], dp[i][j][l-1]);



                    }

                }
            }

            return dp[n][m][k];


    }
    static int max(int a, int b, int c)
    {
        return Math.max(a, Math.max(b, c));
    }
}
