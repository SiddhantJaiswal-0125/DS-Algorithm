package atCoderDP;

import java.util.Arrays;
import java.util.Scanner;

public class AFrog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int ar[] = new int[n];

        for(int i = 0; i < n; i++)
            ar[i] =  sc.nextInt();
        int dp[] = new int[n];


        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]  = 0;
        for(int i=1; i < n; i++)
        {
            for(int j =1; j<=k; j++)
            {
                if(i-j<0)
                    break;
                dp[i] = Math.min(dp[i-j] + Math.abs(ar[i] - ar[i-j]), dp[i]);
            }
        }

        System.out.println(dp[n-1]);
    }
}
