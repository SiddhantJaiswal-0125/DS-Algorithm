/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
class CandidateCode {
    public static void main(String args[] ) throws Exception {

        //Write code here

        Scanner sc = new Scanner(System.in);
        String virus = sc.next();
        int n = sc.nextInt();
//        char [] viAR = virus.toCharArray();
        while(n-->0)
        {
            String sam = sc.next();

            if(check(virus, sam))
                System.out.println("POSITIVE");
            else
                System.out.println("NEGATIVE");
        }

    }
    static boolean check(String a, String b)
    {
        int i = 0, j = 0;
        int m = a.length(), n = b.length();
        while(i<m && j <n)
        {
            if(a.charAt(i)==b.charAt(j))
            {
                i++;
                j++;
            }
            else
                i++;

        }
        return j == n;
    }

    static int solve( char[] X, char[] Y)
    {
        int m = X.length;
        int n = Y.length;
        int dp[][] = new int[m+1][n+1];
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
    static int max(int a, int b)
    {
        return a>b?a:b;
    }

}
