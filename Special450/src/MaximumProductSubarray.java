import java.util.Scanner;

public class MaximumProductSubarray
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        long ans = solve(a,n);
        System.out.println(ans);
    }
    static  long solve(int a[], int n)
    {
        long maxend = 1l, minend = 1l, maxsofar = 0l,flag = 0;

        for(int i : a)
        {
            if(i>0)
            {
                maxend  = maxend * i;
                minend   = min(minend * i, 1);
                flag = 1;
            }
            else if (i==0)
            {
                maxend = 1;
                minend = 1;
            }
            else
            {
                long temp = maxend;
                maxend = max(minend * i,1);
                minend = temp * i;
            }
            if(maxend > maxsofar )
                maxsofar = maxend;

        }
        if(flag == 0)
            return 0;
        return maxsofar;





    }
    static  long min (long a ,long b)
    {
        return  a<b?a:b;
    }
    static  long max (long a ,long b)
    {
        return  a>b?a:b;
    }


}
