import java.util.*;


public class TravelMaze {
    static int dp[][];
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int m = 3;
        int ar[][] = new int[n][m];
        dp = new int [n+1][m+1];
        for(int i =0;i<n;i++)
            for(int j =0;j<m;j++)
            ar[i][j] = sc.nextInt();
            // display(n,m);

            
        int ans = minCost(ar,0,0,2,2);
        System.out.println("ans is :"+ans);
        int ans2 = minCostIterative(ar, m, n);
        System.out.println("ans2 is : "+ans2);




        sc.close();
    }

    static int minCost(int a[][], int si, int sj, int endi, int endj)
    {
        if(si==endi && sj == endj)
         return a[endi][endj];

         if(si>endi || sj>endj)
              return Integer.MAX_VALUE;

        if(dp[si][sj]!=0)
        return dp[si][sj];
    
        int op1 = minCost(a, si+1, sj, endi, endj);
        int op3 = minCost(a, si+1, sj+1, endi, endj);
        int op2 = minCost(a, si, sj+1, endi, endj);
        
        dp[si][sj]  = a[si][sj]+ min(op1, min(op2, op3));
        return dp[si][sj];





    }
    static int min ( int a, int b)
    {return a>b?b:a;}


    static int minCostIterative(int inp[][], int m, int n)
    {
        int dpi[][] = new int [m][n];

        dpi[m-1][n-1] = inp[m-1][n-1];
        for(int i = m-2;i>=0;i--)
        {
            dpi[i][n-1] = dpi[i+1][n-1] + inp[i][n-1];
        }
        for(int i = n-2;i>=0;i--)
        {
            dpi[m-1][i] = dpi[m-1][i+1] + inp[m-1][i];
        }


        for(int i = m-2;i>=0;i--)
        {
            for(int j  = n-2;j>=0;j--)
            {
                dpi[i][j]  = inp[i][j] + min(dpi[i+1][j], min(dpi[i+1][j+1], dpi[i][j+1]));
            }
        }
       
       
        return dpi[0][0];



    }
}
