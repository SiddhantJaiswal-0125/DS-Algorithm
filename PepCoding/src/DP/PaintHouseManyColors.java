package DP;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PaintHouseManyColors
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int data[][] = new int[n][k];
        for(int i =0; i <n;i++)
            for(int j = 0;j<k;j++)
                data[i][j] = sc.nextInt();

        int ans = solve(data, n, k);
        System.out.println(ans);
    }
    static int solve(int data[][], int n, int k)
    {
//        int dp[][] = new int[n][k];
        int ar[] = new int[k];
        int firstleast  = Integer.MAX_VALUE;
        int secondleast = Integer.MAX_VALUE;
        for(int i  =0;i<k;i++)
        {
            ar[i] = data[0][i];
            if(ar[i]<=firstleast)
            {
                secondleast = firstleast;
                firstleast = ar[i];
            }
            else if(secondleast>ar[i])
                secondleast = ar[i];
        }

//        System.out.println(firstleast+"\t"+secondleast);



        for(int i =1;i<n;i++)
        {
            for(int j = 0;j<k;j++)
            {
                if(ar[j]==firstleast)
                    ar[j] = data[i][j]+secondleast;
                else
                 ar[j] = data[i][j]+firstleast;
            }
            firstleast = Integer.MAX_VALUE;
            secondleast = Integer.MAX_VALUE;

            for(int j  =0;j<k;j++)
            {
//                ar[i] = dp[0][k];
                if(ar[j]<=firstleast)
                {
                    secondleast = firstleast;
                    firstleast = ar[j];
                }
                else if(secondleast>ar[j])
                    secondleast = ar[j];
            }

        }

//
//        for(int i=0;i<k;i++)
//            System.out.print(ar[i]+"\t");
//        System.out.println();




        int min = Integer.MAX_VALUE;
        for(int i =0;i<k;i++)
            min = Math.min(min, ar[i]);


return  min ;


    }
}
