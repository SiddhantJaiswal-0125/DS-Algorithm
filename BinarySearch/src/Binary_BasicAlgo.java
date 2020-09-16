//it is the Basic Complementary Code of Binary Search
//as a normal search is Done in O(n) but if the Given
//list/array is given in Sorted form then we can use Binary Search
//and reduce the Complexity to O(logn)

import java.util.Scanner;

public class Binary_BasicAlgo
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
        System.out.println("Enter Element You Want to Search for :");
        int key = sc.nextInt();
        int index = BinarySearch(key,arr,n);
        if(index!=-1)
            System.out.println("Element is found at index "+index);
        else
            System.out.println("Element Not Found");
    }
    protected static int BinarySearch(int key ,int arr[], int n)
    {
        int start = 0;
        int end = n-1;
        while(start <= end)
        {
            int mid = start+((end-start)/2);
            if(arr[mid] == key)
                return mid;
            else if(arr[mid]>key)
                end = mid - 1;
            else if (arr[mid] < key)
                start = mid +1;

        }
        return -1;
    }
}
