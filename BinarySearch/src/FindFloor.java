/*
*Floor of an Element : floor(4.8) = 4
* so in array ,floor of an element can be the same element if
* present of the GREATEST SMALLER element than it!!
* ar[] : 1 2 3 4 6 7 8 10 25
* floor(5) => 4
*/

import java.util.Scanner;

public class FindFloor
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
        int index = floor(arr,key,n);
        if(index!=-1)
            System.out.println(" Floor of that Element is  "+index);
        else
            System.out.println("Floor Not Found");

    }
    protected static int floor(int a[],int key,int n)
    {
        int start = 0;
        int end = n-1;
        int res = -1;
        while (start <= end)
        {
            int mid = start + ((end-start)/2);
            if(a[mid] == key)
                return a[mid];
            if(a[mid] <= key)
            {

                res = a[mid];
                start = mid +1;
            }
            else if(a[mid] > key)
                end = mid-1;
        }
        return res;
    }


}
