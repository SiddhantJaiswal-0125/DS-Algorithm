package MicroSoft;

import java.util.Scanner;

public class q1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i = 0;i<n;i++)
            ar[i] = sc.nextInt();
         int x = sc.nextInt();
         int y = sc.nextInt();
         int ans = solve(ar, x,y);
         System.out.println( ans );



    }

    static int dp[][] ;
     static int solve(int ar[], int  x, int y) {
         int m = ar.length;
         int n = Math.max(x, y);
         dp = new int[m + 1][n + 1];
         for (int i = 0; i < m + 1; i++)
             for (int j = 0; j < n + 1; j++)
                 dp[i][j] = -1;

         return solveBydp(ar, 0, x, y, ar.length);
     }

     static  int solveBydp(int ar[], int ind, int x, int y, int size)
     {
         if(ind>=size)
         return 0;

         int time = Math.abs(x-y);
         if(dp[ind][time] !=-1)
             return dp[ind][time];

         int a = 0, b = 0, c = 0;
         if(x>=ar[ind])
             a= 1+solveBydp(ar,ind+1,x-ar[ind],y,size);
         if(y>=ar[ind]){
             b=1+solveBydp(ar,ind+1,x,y-ar[ind],size);
         }

         c =solveBydp(ar,ind+1,x,y,size);

         return dp[ind][time] =Math.max(a,Math.max(b,c));


     }
}
