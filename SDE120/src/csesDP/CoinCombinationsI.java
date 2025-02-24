package csesDP;

import java.io.*;
import java.util.*;

public class CoinCombinationsI {
    static class FastReader {

        // BufferedReader to read input
        BufferedReader b;

        // StringTokenizer to tokenize input
        StringTokenizer s;

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader
                    (new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Method to read the next token as a long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Method to read the next token as a double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {

        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int coins[] = new int[n];
        for(int i = 0;i <n;i++)
            coins[i] = sc.nextInt();

        int ans = countCombinations(coins, x);
        System.out.println(ans);
    }

   static int mod = 1000000007;
    static int addMod(int a, int b){
        int res = (a%mod + b%mod)%mod;
        return  res;
    }





    static int countCombinations(int ar[], int x)
    {
        if(x==0)
            return  1;

        int totalways = 0;
        int size = ar.length;

        int dp[] = new int[x+1];
        dp[0] = 1;

//        for(int i =0; i<size; i++)
//        {
//            if(ar[i] <=x)
//                totalways = addMod(totalways,( countCombinations(ar, x-ar[i]) ) );
//        }


        Arrays.sort(ar);
        for(int i =1;i<=x;i++)
        {
            for(int j =0; j<size; j++)
            {
                if(ar[j] <= i)
                {
                    dp[i] = (dp[i] + dp[i-ar[j]]) %mod;


                }
                else break;
            }
        }

        return  dp[x];

    }
}
