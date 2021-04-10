/*Given an array of n integers sorted in ascending order, write a function that returns a Fixed Point in the array,
if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i
such that arr[i] is equal to i. Note that integers in array can be negative.*/

import java.util.Scanner;
public class ValueequaltoIndexvalue
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];


            for(int i =0;i<n;i++)
                a[i] = sc.nextInt();
            int ans = binSearch(a,0,n-1);
            System.out.println(ans);

        }
    }
    static int binSearch(int a[],int start, int end)
    {
        if(start>end)
            return  -1;


        int midIndex = start + (end-start)/2;
        int midValue = a[midIndex];


        if(midIndex==midValue)
            return  midIndex;
        //search in left side;
        int left = binSearch(a,start,Math.min(midIndex-1, midValue));
        if(left>-1)
            return  left;

        //search in right side
        return  binSearch(a,Math.max(midIndex+1, midValue),end);





    }

}
