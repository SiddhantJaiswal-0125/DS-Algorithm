package csesDP;

import java.util.Scanner;



public class DiceCombination {
    static final int MOD = 1000000007; // 10^9 + 7

    public static int modAdd(int a, int b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = findDiceCombinations(n);
        System.out.println(ans);
    }

    static int findDiceCombinations(int n)
    {
        int dp[] = new int[n+1];
        dp[0] =1;
        dp[1] = 1;

        for(int i=2; i<=n;i++)
            for(int j = 1; j<=6;j++)
                if(i-j>=0)
                    dp[i] = modAdd(dp[i], dp[i-j]);
//                    dp[i]+=dp[i-j];





        return dp[n];
    }
}
