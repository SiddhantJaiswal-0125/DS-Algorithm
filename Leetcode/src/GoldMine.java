import java.util.*;
public class GoldMine
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int m = sc.nextInt();
         int mat[][] = new int[n][m];
         for(int i=0;i<n;i++)
             for(int j =0;j<m;j++)
                 mat[i][j] = sc.nextInt();
         solve(mat,n,m);



    }
    static void solve(int mat[][], int n, int m)
    {
       int  dp[][] = new int [n][m];


       for(int i= 0;i<n;i++)
           dp[i][m-1] = mat[i][m-1];
       for(int j = m-2;j>=0;j--) {
           for (int i = n - 1; i >= 0; i--) {
               if (i == 0) {
                   if (i + 1 == n) {
                       dp[i][j] = mat[i][j] + dp[i][j + 1];
                   } else {
                       dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                   }

               } else if (i == n - 1) {
//
//                   if(i==)
//                   {
//                       dp[i][j] = mat[i][j] + dp[i][j+1];
//                   }
//                   else
//                   {
                   dp[i][j] = mat[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
//                   }

               } else {
                   dp[i][j] = mat[i][j] + Math.max(Math.max(dp[i][j + 1], dp[i - 1][j + 1]), dp[i + 1][j + 1]);
               }
           }
       }

//           for(int i=0;i<n;i++)
//           {
//               for(int  j  =0;j<m;j++)
//               {
//                   System.out.print(dp[i][j]+"\t");
//
//               }
//               System.out.println();
//           }


           int max = -1;
           for(int i =0;i<n;i++)
               max = Math.max(max, dp[i][0]);

        System.out.println(max);
       }



}
