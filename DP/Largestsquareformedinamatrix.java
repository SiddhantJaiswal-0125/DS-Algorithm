import java.util.*;
public class Largestsquareformedinamatrix 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int [n][m];
        for(int i =0;i<n;i++)
        for(int j =0;j<m;j++)
        a[i][j]  = sc.nextInt();


        int ans = maxSquare(n, m, a);
        System.out.println(ans);




        sc.close();
        
    }
    static int maxSquare(int n, int m, int a[][]){

        // int max = 0;

        int dp[][] = new int[n][m];
        int mx =0;
        for(int  i = n-1;i>=0;i--)
        {
            dp[i][m-1] = a[i][m-1];
            if(dp[i][m-1]>mx)
            mx =dp[i][m-1];
        }

        for(int  i = m-1;i>=0;i--)
        {
            dp[n-1][i] = a[n-1][i];
            if(dp[n-1][i]>mx)
            mx = dp[n-1][i];

        }
  

        for(int i = n-2;i>=0;i--)
        {
            for(int j  = m-2;j>=0;j--)
            {
                if(a[i][j]!=0){
                dp[i][j]  = min(dp[i][j+1],dp[i+1][j+1], dp[i+1][j]) +1;
                if(dp[i][j]>mx)
                mx = dp[i][j];}

            }

        }


        return mx;
    }
    static int min (int a, int b, int c)
    {
        return Math.min(a, Math.min(b, c));
    }
}
