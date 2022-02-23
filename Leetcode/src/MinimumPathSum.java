import java.util.Scanner;

public class MinimumPathSum {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int m = sc.nextInt();
        int  n = sc.nextInt();

        int ar[][] =new int[m][n];
        for(int i  =0 ;i<m;i++)
            for(int j = 0;j<n;j++)
                ar[i][j] = sc.nextInt();

        int min = new MinimumPathSum().minPathSum(ar);
        System.out.println(min);
    }
    public int minPathSum(int[][] g) {
        int m = g.length;
        int n = g[0].length;

        int dp[][]= new int[m][n];
        int sum = 0;
        dp[0][0] = g[0][0];
        for(int i = 1;i<m;i++)
            dp[i][0] = dp[i-1][0] + g[i][0];

        for(int i = 1;i<n;i++)
            dp[0][i] = dp[0][i-1] + g[0][i];


        for(int i = 1;i<m;i++)
            for(int j = 1;j<n;j++)
                dp[i][j] = g[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);

        return dp[m-1][n-1];
        // return solve(grid, 0, 0);
    }
}
