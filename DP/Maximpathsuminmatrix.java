import java.util.Scanner;

public class Maximpathsuminmatrix {
    
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            a[i][j]  = sc.nextInt();
        }
        int ans = maximumPath(n, a);
        System.out.println(ans);









        sc.close();
    }
    static int dp [][];
    static int maximumPath(int n, int a[][])
    {
        // code here
        dp = new int[n+1][n+1];
        for(int i =0;i<=n;i++)
        {
            for(int j =0;j<=n;j++)
            dp[i][j]  = -1;
        }

        int max  =-1;
        for(int j =0;j<n;j++)
        {
            max = Math.max(max,solve(0,j,n,a));
        }
    return max;
    }


    static int solve(int i , int j , int n,int a[][])
    {
        if(i>=n || j>=n || j<0)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        dp[i][j]  = a[i][j]+ max(solve(i+1, j, n, a), solve(i+1, j+1, n, a), solve(i+1, j-1, n, a));
        return dp[i][j];
    }
    
    static int max (int a , int b, int c)
    {
        return Math.max(a, Math.max(b, c));
    }

}
