package d2x;

import java.io.*;
import java.util.*;

 class Solutio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int ar[] = new int[n];
            for(int i=0;i<n;i++)
                ar[i] = sc.nextInt();

            int res[] = solve(ar, n);
            for(int i:res)
                System.out.print(i+" ");

            System.out.println();
        }

    }
    static int[]  solve(int arr[], int n)
    {
        ArrayList<Integer> ar = new ArrayList<>();
        long res = 0l;
        for(int i=0;i<n;i++)
            res = res + (arr[i]==1?(int)Math.pow(2, i):0);

//        System.out.println( "RES IS "+res);


        while(res>0)
        {
            int i =(int)res %6;
            ar.add(i);
            res/=6;
        }


        int ans[] = new int [ar.size()];
        int ind = 0;
        for(int i:ar)
            ans[ind++] = i;
        return ans;
    }

}