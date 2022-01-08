import java.util.Hashtable;
import java.util.Scanner;

public class nuatanix1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
           int a[] = new int[n];
           for(int i =0 ;i<n;i++)
               a[i] = sc.nextInt();

           countSwaps(a);

        }
    }
    static void countSwaps(int[] a)
    {
        int n = a.length;
        int swaps = 0;

        for(int i =0;i<n;i++)
        {
            for(int  j =0;j<n-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    //swap
                    int temp = a[j];
                    a[j] = a[j+1] ;
                    a[j+1] = temp;
                    swaps++;
                }
            }
        }
        // Array is sorted in 3 swaps.


        System.out.println("Array is sorted in "+swaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }
}
