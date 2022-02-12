import java.util.Scanner;

public class StairWithVariableJump
{


    public static void main(String[] args) throws Exception
    {
                // write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ar[] = new int[n];
        System.out.println("ENTER Steps");
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();
        solve(n, ar);
    }
    static void solve(int n, int ar[])
    {
        if (n==0)
        {
            System.out.println(0);
            return;
        }
        int ans = 0;
        int dp[] = new int[n+1];
        for(int i=0;i<n;i++)
        {
            for(int j  =0;j<ar[i];j++)
                if(i+j<=n)
                    dp[i+j] += dp[i];

        }
        System.out.println(dp[n]);
        }
    }

