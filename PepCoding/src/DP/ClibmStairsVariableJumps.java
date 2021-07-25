package DP;

import java.util.*;

public class ClibmStairsVariableJumps
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int steps[] = new int[n];
        for(int i =0;i<n;i++)
            steps[i] = sc.nextInt();

        System.out.println(countStepswithVariableJumps(n, steps));

    }
    static int countStepswithVariableJumps(int n , int steps[])
    {
        int dp[] = new int[n+1];
        dp[0] =  1;


        for(int i = 0;i<n;i++)
        {
            if(dp[i]==0)
                continue;

            int j = 1;
            while(j<=steps[i])
            {
                if(i+j<=n)
                {
                    dp[i+j] += dp[i];
                }
                else
                    break;
                j++;
            }
        }


//        for(int i  =0;i<=n;i++)
//            System.out.print(dp[i]+"\t");
//        System.out.println();
        return dp[n];



    }
}
