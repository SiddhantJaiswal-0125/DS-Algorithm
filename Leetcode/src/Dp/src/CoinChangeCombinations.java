import java.util.Scanner;

public class CoinChangeCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for(int i =0;i<n;i++)
            coins[i] = sc.nextInt();
        int tar =  sc.nextInt();
        int ans = _findCombinations(coins, n, tar);
        System.out.println(ans);
    }
    static  int _findCombinations(int coins[], int size, int tar)
    {
        int dp[] = new int[tar+1];
        dp[0] = 1;
        for(int i =0;i<size;i++)
            for(int j = coins[i];j<=tar;j++)
                dp[j]+= dp[j-coins[i]];



        return  dp[tar];
    }
}
