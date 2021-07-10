package Arrays;

import java.util.*;


public class MergeSortedArray
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("enter m");
        int m = sc.nextInt();
        int a[] = new int[n+m];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();



        int b[] = new int[m];
        for(int i =0;i<m;i++)
            b[i]  = sc.nextInt();
        merge(a,n,b,m);
        for(int i :a)
            System.out.print(i+"\t");
        System.out.println();


    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
      int k = m+n-1;
      int i = m-1;
      int j  = n-1;
      while(i>=0 && j>=0)
      {
          if(nums1[i] > nums2[j])
          {
              nums1[k--]  =nums1[i--];
          }
          else
          {
              nums1[k--] = nums2[j--];
          }

      }
    }

}
