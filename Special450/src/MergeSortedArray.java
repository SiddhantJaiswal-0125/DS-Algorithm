import java.util.*;
public class MergeSortedArray 
{
   static  int nextGap(int gap)
    {
        if (gap <= 1)
        {
            return 0;
        }
        return (gap / 2);
    }
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        for(int i  =0;i<n;i++)
        a[i] = sc.nextInt();
        for(int i  =0;i<m;i++)
        b[i] = sc.nextInt();
        merge(a,b,n,m);
        printarray(a,b);
        sc.close();

    }
    static void merge(int arr1[], int arr2[], int n, int m)
    {
        int gap = (n+m)/2;
        while(gap!=0)
        {
            int l = 0;
            int r  = l+gap;
            int j ;
            if(gap>n) // meaning arr2 is larger than arr1
            {
                j = gap - n;
            }
            else
            {
                j = 0;
            }
            int i;

            for (i = 0; i + gap < n; i++)
            {
                if (arr1[i] > arr1[i + gap])
                {
                    int temp = arr1[i] ;
                    arr1[i]=  arr1[i+gap];
                    arr1[i+gap] = temp;

                }
            }

            for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++)
            {
                if (arr1[i] > arr2[j])
                {


                    int temp = arr1[i] ;
                    arr1[i]=  arr2[j];
                    arr2[j] = temp;

                }
            }
            if (j < m)
            {

                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap])
                    {
                        int temp = arr2[j] ;
                        arr2[j]=  arr2[j+gap];
                        arr2[j+gap] = temp;

                    }
                }


            }

            gap = nextGap(gap);
        }
    }
    static void printarray(int a[] , int b[])
    {
        for(int i :a)
            System.out.print(i+" ");
        System.out.println( );
        for(int i :b)
            System.out.print(i+" ");
        System.out.println( );

    }
}
