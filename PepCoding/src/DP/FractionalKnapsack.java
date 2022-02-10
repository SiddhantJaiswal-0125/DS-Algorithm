package DP;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack
{
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        for(int i =0; i<n;i++)
            val[i] = sc.nextInt();

        for(int i =0; i<n;i++)
            wt[i] = sc.nextInt();
        int cap = sc.nextInt();
        double ans = solveGreedy(wt,val,cap, n);
        System.out.println(ans);
    }
    static double solveGreedy(int wt[], int []val, int cap, int n)
    {
        pair p[] = new pair[n];
        for(int i  =0 ;i<n;i++)
            p[i] = new pair(val[i],wt[i]);

        Arrays.sort(p);
//        for(pair pi : p)
//            System.out.println(pi.val +"\t"+pi.wt);


        double res = 0.0;

        int i  =0;
        while(i<n && cap > p[i].wt)
        {
                res+=p[i].val;
                cap-=p[i].wt;
            i++;
        }
        if(i<n &&cap>0)
        {
            double d = cap * (p[i].val/(double)p[i].wt);

            res+=d;
        }


        return  res;
    }


    static class pair implements Comparable<pair>
    {
        int val, wt;
        pair(int a, int b)
        {
            val = a;
            wt = b;
        }


        public int compareTo(pair ot)
        {
            double d1 = this.val / (double) this.wt  ;
            double d2 = ot.val / (double) ot.wt  ;

            if(d1 > d2)
                return -1;
            else if( d1 == d2)
            {
                return this.wt -  ot.wt;
            }
            else return  1;


        }

    }
}
