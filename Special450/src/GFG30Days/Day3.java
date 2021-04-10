package GFG30Days;

import java.util.Arrays;
import java.util.Scanner;

//Smallest Positive Integer that can not be represented as Sum
public class Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test>0)
        {
            int n = sc.nextInt();
            long a[] = new long[n];
            for(int i =0;i<n;i++)
                a[i] = sc.nextLong();

            long ans = solve(a,n);
            System.out.println(ans);




            test--;
        }
    }
    static long solve(long a[], int n)
    {
        Arrays.sort(a);

        long next = 1l;
        for (int i=0;i<n&& a[i]<=next;i++)
            next+=a[i];

        return next;

    }
}
