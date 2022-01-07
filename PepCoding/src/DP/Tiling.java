package DP;


import java.io.*;
        import java.util.*;

public class Tiling {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = solve(n);
        System.out.println(ans);

    }
    static int solve(int n)
    {
        int two = 0;
        int one = 0;
        int total = 0;
        one =  1;
        two = 2;
        if(n==1)
            return one;
        else if(n==2)
            return two;

        total = one + two;
        for(int i = 3;i<=n;i++)
        {
            total = one + two;
            one = two;
            two = total;
//            two = one;
//            one = total;

        }

        return total;
    }
}