import java.util.Scanner;

public class CoinChangePermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i=0; i < n; i++)
            coins[i] = sc.nextInt();
        int tar = sc.nextInt();
        int ans =  _getCombinations(coins, n, tar);
        System.out.println(ans);
    }
    static int _getCombinations(int coins[], int n, int tar)
    {
        int dp[] = new int[tar+1];

        dp[0] = 1;
        for(int i =1; i<=tar;i++)
            for(int j =0; j<n;j++)
                if(coins[j] <= i)
                    dp[i] += dp[i-coins[j]];

        return dp[tar];
    }
}
