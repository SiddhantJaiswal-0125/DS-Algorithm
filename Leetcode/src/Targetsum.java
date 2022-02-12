import java.io.*;
import java.util.*;

 class Main {

    static boolean dp[][];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int ar[] = new int[n];
        for(int  i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int tar = sc.nextInt();
        dp = new boolean[n+1][tar+1];
        if(  solve(ar, n, tar))
        System.out.println(true);
      else System.out.println(false);

    }


    static boolean solve(int ar[], int n, int tar) {
        Stack <Character> s1 = new Stack<>();
        if (n == 0)
            return false;
        if (tar == 0)
            return true;
        if (dp[n][tar])
            return true;
        else if (ar[n - 1] > tar)
                return dp[n][tar] = solve(ar, n - 1, tar);
        else
            return dp[n][tar] = solve(ar, n - 1, tar - ar[n - 1]) ||
                        solve(ar, n - 1, tar);


    }




}