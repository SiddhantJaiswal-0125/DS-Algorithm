package DP;

import java.util.Scanner;

public class PaintFence
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = solve(n, k);
        System.out.println(ans);
    }
    static int solve(int n, int k )
    {
        int lastsame = 0;
        int lastdiff = 0;
        if(n>1)
        {
            lastdiff = k * (k -1);
            lastsame = k;


        }

        else if(n>0)
        {
            lastdiff = k ;
            lastsame = k;

        }

        int total = lastdiff+lastsame;
        for(int i = 3;i<=n;i++)
        {
//            int temp = lastdiff;
            lastsame = lastdiff;
            lastdiff = total * (k-1);
            total =  lastdiff+lastsame;

        }


//        System.out.println(lastdiff+"\t"+lastsame);
        return  total;
        

    }
}
