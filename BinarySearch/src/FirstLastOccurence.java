//this is an Extension of basicAlgo of binary search
//here we have to tell the first and last occurence of an element

//E.G :  2 4 10 10 10 18 20
//       0 1  2  3  4  5  6
//first occurence of 10 is at : 2 and last  at : 4

import java.util.Scanner;

public class FirstLastOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Array/List in Sorted Form:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Elements :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter Element You Want to Search for :");
        int key = sc.nextInt();
        int firstOccurence = firstOccurence(arr, n, key);
        int lastOccurence = lastOccurence(arr, n, key);
        if(firstOccurence!=-1||lastOccurence!=-1)
            System.out.println("First Occurence at index "+firstOccurence+" last Occurence at "+lastOccurence);
        else
            System.out.println("Element Not Found");
    }

protected  static int firstOccurence(int arr[],int n,int key)
{
    int start = 0;
    int end = n-1;
   int res = -1;
    while(start  <= end)
    {
        int mid = start + ((end-start)/2);
        if(arr[mid] == key)
        {
            res = mid;
            end = mid -1;
        }
        else if (arr[mid] < key)
        start = mid + 1;
        else
            end = mid - 1;
    }
    return res;
}

    protected  static int lastOccurence(int arr[],int n,int key)
    {
        int start = 0;
        int end = n-1;
        int res = -1;
        while(start  <= end)
        {
            int mid = start + ((end-start)/2);
            if(arr[mid] == key)
            {
                res = mid;
                start = mid + 1;
            }
            else if (arr[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return res;
    }


}
