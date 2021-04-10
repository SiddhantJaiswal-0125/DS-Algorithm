import java.util.Arrays;
import java.util.Scanner;

public class MinimumremovalsfromarraytomakeMinminusMaxlessthanequalsToK
{
    static  int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++)
            a[i] = sc.nextInt();
        dp = new int[n+1][n+1];
        int k = sc.nextInt();

        for(int i =0;i<=n;i++)
            for(int  j =0;j<=n;j++)
                dp[i][j] = -1;
        Arrays.sort(a);

        int ans= solve(0,n-1,a,k);
        System.out.println(ans);

    }
    static int solve(int i, int j , int a[], int k )
    {
        if(i>=j)
            return 0;
        if(a[j]-a[i]<=k)
            return 0;
        else if(dp[i][j]!=-1)
            return dp[i][j];
        else
        {
            dp[i][j] = 1+ Math.min(solve(i+1,j,a,k),solve(i,j-1,a,k));
            return  dp[i][j];
        }
    }
}
