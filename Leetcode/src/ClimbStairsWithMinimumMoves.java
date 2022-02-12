import java.util.Arrays;
import java.util.Scanner;

public class ClimbStairsWithMinimumMoves
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
//        System.out.println("Enter moves : ");
        for(int  i =0;i<n;i++)
            ar[i]  = sc.nextInt();
        solve(ar,n);


    }
    static  void solve(int ar[], int n)
    {
        int dp[] = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] =0;
        for(int i =1;i<=n;i++)
        {
            int k = ar[i-1];
//            System.out.println("FOR I "+i);
            for(int j = 1;j<=k && i+j<=n;j++)
            {
//                System.out.println("HERE");

                if(dp[i]!=Integer.MAX_VALUE)
                {
//                    System.out.println("BEFORE for j:"+j+", dp[j] is "+dp[i+j]);

                    dp[i+j]= Math.min(dp[i+j], dp[i]+1);
//                    System.out.println("AFTER for j:"+(int)(i+j)+", dp[j] is "+dp[i+j]);

                }
            }
        }
        System.out.println(dp[n]);



    }
}
