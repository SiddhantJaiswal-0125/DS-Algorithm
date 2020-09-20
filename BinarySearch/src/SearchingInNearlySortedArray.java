/*A nearly Sorted array is what in which the element which is meant to
* be in 'i'th position is can be in i-1/ i / i+1 position
*
* given arr[]  :  5 10 30 20 40
* sorted arr[] :  5 10 20 30 40
* */


import java.util.Scanner;

public class SearchingInNearlySortedArray
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the Size of the Array/List:");
        int n = sc.nextInt  ();
        int arr[] = new int[n];
        System.out.println("Enter the Elements :");
        for(int i = 0;i < n; i++)
            arr[i] =  sc.nextInt();
        System.out.println("Enter Element You Want to Search for :");
        int key = sc.nextInt();
        int index = searchInNearlySortedArray(arr,key,n);
        if(index!=-1)
            System.out.println("Element is found at index "+index);
        else
            System.out.println("Element Not Found");
    }
    protected static int searchInNearlySortedArray(int a[], int key , int n)
    {
        int start = 0;
        int end = n- 1;
        while(start <= end)
        {
            int mid = start +((end-start)/2);
            if(a[mid] == key)
                return mid;
            if(mid>0 && a[mid-1]==key)
                return mid-1;
            if (mid < n-1 && a[mid+1] == key)
                return mid+1;
            else if(a[mid]>key)
                end= mid-2;
            else if(a[mid] < key)
                start = mid + 2;

        }
       return -1;
    }


}
