public class Fibonacci
{
    static int fib(int n )
    {
        if(n==1 || n==0)
        return 1;

        return fib(n-1)+fib(n-2);

    }
    static int fib2(int n, int a[])
    {
        if(n==1 || n==0)
        return 1;
        if(a[n-1]>0)
        return a[n-1];

        int out = fib2(n-1,a) + fib2(n-2,a);
        a[n-1] = out;
        return out;
    }
    static int fibInteratively(int n)
    {
        int dp[] = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i =2;i<=n;i++)
        dp[i] = dp[i-1]+dp[i-2];

        return dp[n];
    }
    public static void main(String[] args) {
        int ans1 = fib(5);
        System.out.println(ans1);
        int a[] = new int [6];
        int ans2 = fib2(6,a);
        System.out.println(ans2);
        int ans3 = fibInteratively(7);
        System.out.println(ans3);

    }
}