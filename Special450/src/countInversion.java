import java.util.*;
public class countInversion
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        System.out.println(inversionCount(a,n));
        long q = -1l;

    }
    static long inversionCount(long arr[], int n)
    {
        // Your Code Here
         return mergesortandcount(arr,0,n-1);
    }
    static  long mergesortandcount(long arr[],int l, int r)
    {
        long count = 0l;
        if(l<r)
        {
            int m = (l+r)/2;
            count+=mergesortandcount(arr,l,m);
            count+=mergesortandcount(arr,m+1,r);
            count+=mergecount(arr,l,m,r);
        }
    return  count;
    }
    static  long mergecount(long arr[],int l,int m ,int r)
    {
        long left[] = Arrays.copyOfRange(arr,l,m+1);
        long []right = Arrays.copyOfRange(arr,m+1,r+1);
        int i=0,j=0,k=l,swaps=0;
        while(i<left.length && j <right.length)
        {
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else
            {
                arr [k++] = right[j++];
                swaps+=m+1-(l+i);
            }
        }
        return swaps;
     }

}
