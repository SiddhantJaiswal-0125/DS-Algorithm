package Hashing;

import java.util.*;

public class CountSubstringDESHAW
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();

        System.out.println(new CountSubstringDESHAW().substrCount(s,k));

    }


        boolean have_same_frequency(int[] freq, int k)
        {
            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0 && freq[i] != k) {
                    return false;
                }
            }
            return true;
        }
        long substrCount (String s, int k)
        {
            // your code here



            int count = 0;
            int distinct = 0;
            boolean[] have = new boolean[26];
            Arrays.fill(have, false);
            for (int i = 0; i < s.length(); i++) {
                have[((int)(s.charAt(i) - 'a'))] = true;
            }
            for (int i = 0; i < 26; i++) {
                if (have[i]) {
                    distinct++;
                }
            }
            for (int length = 1; length <= distinct; length++) {
                int window_length = length * k;
                int[] freq = new int[26];
                Arrays.fill(freq, 0);
                int window_start = 0;
                int window_end
                        = window_start + window_length - 1;
                for (int i = window_start;
                     i <= Math.min(window_end, s.length() - 1);
                     i++) {
                    freq[((int)(s.charAt(i) - 'a'))]++;
                }
                while (window_end < s.length()) {
                    if (have_same_frequency(freq, k)) {
                        count++;
                    }
                    freq[(
                            (int)(s.charAt(window_start) - 'a'))]--;
                    window_start++;
                    window_end++;
                    if (window_end < s.length()) {
                        freq[((int)(s.charAt(window_end)
                                - 'a'))]++;
                    }
                }
            }
            return count;
        }


}
