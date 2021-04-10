import java.util.Arrays;
import java.util.Scanner;

public class LongestsubsequencewithDifference1 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int  i =0;i<n;i++)
        a[i]  = sc.nextInt();
        int ans = solve(a,n);
        System.out.println(ans);



        sc.close();
    }
    
    static int solve(int a[], int n)
    {
        int dp[]  = new int [n+1];
        dp[0]  = 1;
        Arrays.fill(dp, 1);
        for(int i =1;i<n;i++)
        {
            for(int j =0;j<i;j++ )
            {
                if(Math.abs(a[i]-a[j])==1)
                {
                    dp[i]  = Math.max(dp[i] , dp[j]+1);
                }
            }
            // dp[i]++;
        }
        int max = 0;
        for(int i :dp)
        max = Math.max(max, dp[i]);
        return max;
        // return dp[n-1];


    }
}
