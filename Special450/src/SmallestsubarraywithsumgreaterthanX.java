import java.util.Scanner;

public class SmallestsubarraywithsumgreaterthanX
{
    public static void main(String[] args)
    {
        Scanner  sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int a[]  = new int[n];
            int x = sc.nextInt();
            for(int i = 0;i<n;i++)
                a[i] = sc.nextInt();

            int ans = FindSmallest(a,n,x);
            System.out.println(ans);

        }

    }

    static  int FindSmallest(int a[] , int n , int x)
    {
        int minVal = n+1, curSum = 0,start = 0, end = 0;

        while(end<n)
        {
            while(curSum<=x && end < n)
                curSum+=a[end++];
            while(curSum>x && start < curSum)
            {
                if(end - start < minVal)
                    minVal = end - start;

                curSum-=a[start++];
            }

        }



        return minVal;
    }
}
