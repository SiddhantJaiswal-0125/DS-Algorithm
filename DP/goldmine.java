import java.util.*;
public class goldmine 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int  m = sc.nextInt();
        int a[][]= new int[n][m];
        for(int  i =0;i<n;i++)
        for(int j =0;j<m;j++)
        a[i][j] = sc.nextInt();

        int ans = solve(a);
        System.out.println(ans);
        sc.close();
    }

    static int dp[][];
    static int solve(int a[][])
    {
        int n = a.length;
      
        int  m = a[0].length;
        dp = new int[n+1][m+1];
        for(int  i =0;i<=n;i++)
        for(int j =0;j<=m;j++)
         dp[i][j] = -1;
            int temp=-1 , ans =-1;

            for(int i = 0;i<n;i++)
            {
                temp = sol(a,n,m,i,0);
                ans = Math.max(temp, ans);
            }
      return ans;
    }

    static int sol(int a[][], int n , int m , int i,int j )
    {
        if(i>=n || j>=m || i<0)
        return 0;
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        
        dp[i][j]=  a[i][j] + Math.max(sol(a,n,m,i+1,j+1), sol(a, n, m, i-1, j+1));
    return dp[i][j];
    }
    
}
