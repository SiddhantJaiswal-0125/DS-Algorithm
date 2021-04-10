import java.util.Scanner;

public class lcs 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
    
        String s2 = sc.next();


        int ans = solve(s1.length(),s2.length(),s1,s2);
        System.out.println(ans);
        sc.close();


    }
    static int solve(int p , int q , String s1, String s2)
    {

        int dp[][] = new int [p+1][q+1];

        for(int i =1;i<=p;i++)
        {
            for(int   j  = 1;j<=q;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;

                else 
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);    



            }

        }


        return dp[p][q];

    }


    
}
