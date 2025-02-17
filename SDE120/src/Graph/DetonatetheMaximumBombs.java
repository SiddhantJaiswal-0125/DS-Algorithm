package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DetonatetheMaximumBombs {
//    int dp[];
//    public int maximumDetonation(int[][] bombs) {
//
//        int n = bombs.length, ans = 0;
//        dp = new int[n];
//        Arrays.fill(dp, -1);
//        for (int i = 0; i < n; i++) {
//            dp[i] = dfs(i, new boolean[n], bombs);
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;
//    }
//
//    private int dfs(int idx, boolean[] v, int[][] bombs) {
//        int count = 1;
//        v[idx] = true;
//        int n = bombs.length;
//        for (int i = 0; i < n; i++) {
//            if (!v[i] && inRange(bombs[idx], bombs[i])) {
//                if(dp[i]== -1)
//                dp[i] =  dfs(i, v, bombs);
//                count+=dp[i];
//            }
//        }
//        return count;
//    }


        int dp[];

     public int maximumDetonation(int[][] bombs) {
         int n = bombs.length, ans = 0;
         dp = new int[n];
        Arrays.fill(dp, -1);
         for (int i = 0; i < n; i++) {
             dp[i] =   dfs(i, new boolean[n], bombs);
             ans = Math.max(ans, dp[i]);
         }
         return ans;
     }

     private int dfs(int idx, boolean[] v, int[][] bombs) {
         int count = 1;
         v[idx] = true;
         int n = bombs.length;
         for (int i = 0; i < n; i++) {
             if (!v[i] && inRange(bombs[idx], bombs[i])) {
                 if(dp[i]==-1)
                     dp[i] =  dfs(i, v, bombs);
                 count += dp[i];
             }
         }
         return count;
     }



    private boolean inRange(int[] a, int[] b) {
        long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
        return dx * dx + dy * dy <= r * r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bombs[][] = new int[n][3];

        for(int  i=0 ;i<n;i++)
        {
            bombs[i][0] = sc.nextInt();
            bombs[i][1] = sc.nextInt();
            bombs[i][2] = sc.nextInt();
        }

        int ans = new DetonatetheMaximumBombs().maximumDetonation(bombs);

        System.out.println("ANSWER "+ans);
    }
}
//2
//        2
//        1
//        3
//        6
//        1
//        4


//[[868,658,84],[82,386,48],[464,157,11],[422,654,85],[864,418,84],[366,314,72],[955,270,60],[460,98,60],[824,147,38],[580,660,27],[423,102,73],[317,471,74]]


//12
//        868
//        658
//        84
//        82
//        386
//        48
//464
//157
//11
//422
//654
//85
//        864
//        418
//        84
//        366
//        314
//        72
//        955
//        270
//        60
//        460
//        98
//        60
//        824
//        147
//        38
//        580
//        660
//        27
//        423
//        102
//        73
//                317
//        471
//        74
