package csesDP;


import java.util.*;

 class MinimizingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int coins[] = new int[n];
        for(int i =0 ;i<n; i++)
            coins[i] = sc.nextInt();

        int ans = findMinimalCoinstoConstruckK(coins, k);
        System.out.println(ans);
    }
    static int findMinimalCoinstoConstruckK(int coins[], int k)
    {
        int dp[] = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //dp[i] will store the minimum num of coins required to genratre a sum value of i;
        //base case
        dp[0] = 0;

        int size =  coins.length;
        for(int i =1; i<=k;i++)
        {
            for(int j=0; j < size; j++ )
                if(coins[j] <= i && dp[i-coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);

        }

        return  dp[k] == Integer.MAX_VALUE ? -1 : dp[k];

    }
}
