/*This Program  will Return the Number of times A sorted Array is Rotated*/
//for ex:  1 2 3 4 5 6  ==>   3 4 5 6 1 2
//the number of Rotations is  ==> 4
//solution Approach == Index of Min Element


import java.util.Scanner;

public class NoOfTimesSortedArrayRotated
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the Size of the Array/List in Sorted Form:");
        int n = sc.nextInt  ();
        int arr[] = new int[n];
        System.out.println("Enter the Elements :");
        for(int i = 0;i < n; i++)
            arr[i] =  sc.nextInt();
        System.out.println("the answer is");
        System.out.println(NoOfTimesArrayIsRotated(arr,n));



    }
    protected static int NoOfTimesArrayIsRotated(int a[] ,int n)
    {
        int start = 0;
        int end  = n-1;
        while(start<=end)
        {
            int mid = start + ((end - start) / 2);
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            if(a[next]>=a[mid]  && a[prev]>=a[mid])
                return mid;
            else if(a[mid]>=a[start])
                start = mid +1;
            else if (a[mid]<=a[end])
                end = mid - 1;

        }
        System.out.println("here");
       return 0;

    }
}
