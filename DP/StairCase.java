import java.util.*;
public class StairCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int  n = sc.nextInt();
            long ans = solve(n+1);
            System.out.println(ans);

        }

        sc.close();
    }
    static long solve(int n )
    {

        long dp[]  = new long[n+1];
        dp[0] =1;
        dp[1] = 1;
        dp[2] = 2;
        for(int  i = 3;i<=n;i++)
             dp[i] += (dp[i-1]+dp[i-2]+dp[i-3]);



        return dp[n];
    } 
    
}
