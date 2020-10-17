//https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
/*Union and Intersection of two sorted arrays*/

import java.util.HashSet;
import java.util.Scanner;

public class UnionAndIntersection
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a[] = {1,2,3,4,5,6,7};
        int b[] = {2,3,4,5,6};
        System.out.println("Print Intersection ");
        printInterSection(a,b);
        System.out.println("Print Union ");
        printUnion(a,b);
    }

    static void printUnion(int a[], int b[])
    {
        int n = a.length;
        int m = b.length;
        int i = 0,j=0;
        while(i<n&&j<m)
        {
            if (a[i] < b[j])
                    System.out.print(a[i++] + " ");
                else if (b[j] < a[i])
                    System.out.print(b[j++] + " ");
                else {
                    System.out.print(b[j++] + " ");
                    i++;
                }
            }

        /* Print remaining elements of
         the larger array */
            while (i < n)
                System.out.print(a[i++] + " ");
            while (j < m)
                System.out.print(b[j++] + " ");

        System.out.println();

        }
        static  void printInterSection(int a[],int b[])
        {
           int m = a.length;
           int n = b.length;
           int i =0,j=0;
           while (i<m && j<n)
           {


               if(a[i] < b[j])
                   i++;
               else if(a[i]>b[j])
                   j++;
               else
                   {
                       System.out.print(a[i++] + " ");
                       j++;
                   }
           }
            System.out.println();

        }
    }



