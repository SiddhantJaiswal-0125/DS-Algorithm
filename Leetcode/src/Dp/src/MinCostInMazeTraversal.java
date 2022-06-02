import java.util.Scanner;

public class MinCostInMazeTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] =  new int[m][n];
        for(int i=0; i<m;i++)
            for(int j = 0 ;j<n;j++)
                mat[i][j] = sc.nextInt();
        int _minimumCost = getMinimumCostOfTraversal(mat, m,n);
        System.out.println(_minimumCost);
    }
    static  int getMinimumCostOfTraversal(int mat[][], int m, int n)
    {
        int dp[][] =  new int[m][n];
        dp[0][0] = mat[0][0];
        for(int j = 1;j<n;j++)
            dp[0][j] = mat[0][j]+dp[0][j-1];
        for(int j = 1;j<m;j++)
            dp[j][0] = mat[j][0]+dp[j-1][0];

        for(int i = 1;i <m;i++)
        {
            for(int j = 1; j<n;j++)
            {
                dp[i][j] = mat[i][j];
                dp[i][j] += (Math.min(dp[i-1][j], dp[i][j-1]));

            }
        }


        return dp[m-1][n-1];


    }
    static  void display(int dp[][], int m, int n)
    {
        for(int i =0; i<m;i++)
        {
            for(int j = 0;j<n;j++)
                System.out.print(dp[i][j]+"\t");
            System.out.println();
        }
    }
}
