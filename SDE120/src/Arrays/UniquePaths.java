package Arrays;

import java.util.*;


public class UniquePaths
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(new UniquePaths().uniquePaths(m,n));
    }
    static int ans = 0;
    public int uniquePaths(int m, int n) {
//        solve(0, 0, m, n);
//        return ans;
        int dp[][] = new int[m][n];
        for(int i =0;i<m;i++)
            dp[i][n-1] = 1;
        for(int j = 0;j<n;j++)
            dp[m-1][j]  = 1;


        for(int i =  m-2;i>=0;i--)
        {
            for(int j = n-2;j>=0;j--)
            {
                dp[i][j]= dp[i][j+1] + dp[i+1][j];
            }
        }



        return  dp[0][0];




    }
    void solve(int i , int j, int m, int n)
    {
        if(i<0||j<0 || i>=m || j>=n)
            return ;
        if(i==m-1 && j==n-1)
        {
            ans++;
            return;
        }
        solve(i+1, j, m,n);
        solve(i, j+1,m,n);


    }
}
