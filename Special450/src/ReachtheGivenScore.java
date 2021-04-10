import java.util.Arrays;
import java.util.Scanner;

public class ReachtheGivenScore
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans  = solve(n);
        System.out.println(ans);

    }
    static long solve( int sum) {

        long[] dp = new long[sum + 5];
        Arrays.fill(dp, 0);   //O(n)
        dp[0] = 1;

        for(int i =3;i<=sum;i++)
            dp[i]+= dp[i-3];
        for(int i =5;i<=sum;i++)
            dp[i]+= dp[i-5];
        for(int i =10;i<=sum;i++)
            dp[i]+= dp[i-10];


        return dp[sum];
    }

}
