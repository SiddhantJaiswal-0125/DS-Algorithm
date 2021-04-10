
import java.util.*;



public class CoinChange {
    static int dp[][];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int deno[] = new int[n];
        for(int i =0;i<n;i++)
            deno[i]  = sc.nextInt();
        System.out.println("Enter Sum");
        int sum = sc.nextInt();
        dp =  new int [n+1][sum+1];
        // Arrays.fill(dp, -1);

        for(int i =0;i<n+1;i++)
            for(int j=0;j<sum+1;j++)
            dp[i][j] = -1;
            // System.out.print(dp[i][j] + "  ");
            // System.out.println();
        
        int ans = coinChange(deno,n,sum,0);
        System.out.println(ans);
        sc.close();
    }

    static int coinChange(int deno[], int n , int sum, int i)
    {
        if(sum==0)
        return 1;
        if(i==n || sum<0 )
        return 0;
        
        if(dp[i][sum]!=-1)
        return dp[i][sum];

        int first = coinChange(deno , n, sum - deno[i], i);
        int second = coinChange(deno, n, sum, i+1);

        dp[i][sum]  = first+second;
        return dp[i][sum];






    }



}
