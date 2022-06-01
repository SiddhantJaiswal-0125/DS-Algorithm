import java.util.Scanner;

public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0; i < n ;i++)
            ar[i] = sc.nextInt();
        int ans = _climbStairs(ar, n);
        System.out.println(ans);

    }
    static  int _climbStairs(int ar[], int n)
    {
        int dp [] = new int[n+1];
        dp[n] = 1;
        for(int i = n-1;i>=0;i--)
            if(ar[i]>0)
                for(int j = 1;j<=ar[i] && i+j <= n ;j++)
                    dp[i] += dp[i+j];



        return dp[0];

    }
}
