//Largest Sum Contiguous Subarray
//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
import java.util.Scanner;

public class KadaneAlgorithm
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int max = Max_via_Kadane(a, n);
            System.out.println(max);
        }
    }
    static  int Max_via_Kadane(int a[] , int n)
    {
        int max_So_far = a[0], max_ending = 0;
        for(int  item : a)
        {
            max_ending+=item;

            if(max_So_far < max_ending)
                max_So_far = max_ending;
            if(max_ending < 0)
                max_ending =  0;
            if(max_So_far < item)
                max_So_far = item;
        }
        return max_So_far;
    }
}
