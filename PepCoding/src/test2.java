import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;


 class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i]= sc.nextInt();
        int k = sc.nextInt();
        int total = 0;
        for(int i =0;i<k;i++)
        {
            ArrayList<Integer> a = new ArrayList<>();
            for(int j = i ;j<n;j+=k)
                a.add(ar[j]);

        
            int tempar[] = new int[a.size()];
            for(int ind = 0;ind<a.size();ind++)
                tempar[ind] = a.get(ind);

            total+=mergeSortAndCount(tempar, 0, tempar.length - 1);
        }

        System.out.println(total);




    }
    private static int mergeAndCount(int[] arr, int l,
                                     int m, int r)
    {

        int[] left = Arrays.copyOfRange(arr, l, m + 1);


        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }


    private static int mergeSortAndCount(int[] arr, int l,
                                         int r)
    {
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;


            count += mergeSortAndCount(arr, l, m);


            count += mergeSortAndCount(arr, m + 1, r);


            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

}