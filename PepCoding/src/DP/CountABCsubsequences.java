package DP;

import java.util.Scanner;

public class CountABCsubsequences
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = solve(s);
        System.out.println(ans);

    }
    static int solve(String s) {
        int len = s.length();

        int dp[][] = new int[3][len];
        /*
        * Ek 2d matrix banao with 3 rows
        * one for A+ sequences  ||  whenever a comes => 2*(last a+) +1
        * one for a+b+ sequences || whenever b comes => 2*(last ab+) + count of a
        * one for a+b+c+ sequences || whenever c comes => 2*(last abc+) + count of b
        * */

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {

                if(i==0)
                    dp[0][i] = 1;
                else
                {


                    dp[1][i] = dp[1][i-1];
                    dp[2][i] = dp[2][i-1];


                    dp[0][i] = 2*dp[0][i-1];
                    dp[0][i]++;
                }


            }

            else if (ch == 'b') {
                if(i>0) {
                    dp[0][i] = dp[0][i - 1];
                    dp[2][i] = dp[2][i-1];


                    dp[1][i] =2*dp[1][i-1];
                    dp[1][i] += dp[0][i];
                }
            }
            else if (ch == 'c') {
                if(i>0) {

                    dp[1][i] = dp[1][i-1];
                    dp[0][i] = dp[0][i - 1];
                    dp[1][i] = dp[1][i-1];
                    dp[2][i] = (2*dp[2][i-1]);
                    dp[2][i] += dp[1][i];

                }
            }
        }
        return dp[2][len-1];

    }


    }
