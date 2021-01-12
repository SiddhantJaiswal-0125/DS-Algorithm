import java.util.Arrays;
import java.util.Scanner;

 class ChocolateDistributionProblem
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int  t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long a[] = new long[n];
            for(int i = 0;i<n;i++)
                a[i] = sc.nextInt();
            int m = sc.nextInt();
            Arrays.sort(a);
            long ans = solve(a,n,m);
            System.out.println(ans);

        }
    }
    static long solve(long arr[], int n,
                           int m)
    {

        if (m == 0 || n == 0)
            return 0;


        Arrays.sort(arr);


        if (n < m)
            return -1;


        long min_diff = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < n; i++)
        {
            long diff = arr[i+m-1] - arr[i];
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }

}
