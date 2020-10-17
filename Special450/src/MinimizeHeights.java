//https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights//

//Minimize the maximum difference between the heights
//Question  was asked in Adobe InterView

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MinimizeHeights
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int k = sc.nextInt();

        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        int ans = getMinDiff(a,n,k);
        System.out.println(ans);


    }
    static int getMinDiff(int[] arr, int n, int k)
    {
        // code here
        if(n==1)
            return 0;
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n-1] - k;
        if(small > big)
        {
            int temp = small;
            small = big;
            big  = temp;
        }
        for(int i= 1 ;i <n-1;i++)
        {
            int sub = arr[i] - k;
            int add = arr[i] + k;
            if(sub >= small || add <= big)
                continue;
            if( big - sub <= add - small)
                small = sub ;
            else
                big = add;
        }
        return  Math.min(ans,big-small);







    }



}
