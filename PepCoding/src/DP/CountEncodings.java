package DP;

import java.io.*;
import java.util.*;

public class CountEncodings {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = solve(s);
        System.out.println(ans);
    }
    static int solve(String s )
    {
        int len = s.length();
        int dp[] = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=len;i++)
        {
            char c1 = s.charAt(i-2);
            char c2 = s.charAt(i-1);

            if(c1=='0' && c2=='0')
            {
                dp[i] = 0;
            }
            else if(c1=='0' && c2!='0')
            {
                dp[i] = dp[i-1];
            }
            else if(c1!='0' && c2=='0')
            {

                if(c1=='1'||c1=='2')
                {
                    dp[i]= dp[i-2];
                }
                else dp[i] =0;

            }
            else {
                //both non - zero
                dp[i] = dp[i - 1];

                if (s.charAt(i - 2) == '2') {
                    if (s.charAt(i - 1) <= '6')
                        dp[i] += dp[i - 2];
                } else if (s.charAt(i - 2) == '1')
                    dp[i] += dp[i - 2];
            }
        }
        return dp[len];



    }

}