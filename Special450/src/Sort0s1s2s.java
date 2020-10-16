/*
* Method 1 : Use Counting algorithm which use 2 passes ==> O(2*n)
* Method 2 : use Dutch Flag algo which use one pass to solve this Problem;
*/




//Solved using dutch Flag Algorithm
import java.util.Scanner;

public class Sort0s1s2s
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i= 0;i<n;i++)
                a[i] = sc.nextInt();
            int start =0 ,mid =0,end = n-1;

            while(mid <= end)
            {
                if(a[mid]==0)
                {
                    //Swap (a[low],a[mid])
                    int temp = a[start];
                    a[start] = a[mid];
                    a[mid] = temp;
                    start++;
                    mid++;

                }
                else if(a[mid] == 1)
                    mid++;
              else if(a[mid] == 2)
                {
                    int temp = a[mid];
                    a[mid] = a[end];
                    a[end] = temp;
                    end--;
                }
            }

            for(int i= 0;i<n;i++)
                System.out.print(a[i]+" ");
            System.out.println();




        }





    }
}
