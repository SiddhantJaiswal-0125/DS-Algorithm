import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
    public int longestPalindrome(String s) {

        int small[] = new int[26];
        int big[] = new int[26];
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char ch = s.charAt(i);
            if (ch <= 'z' && ch >= 'a')
                small[ch - 'a']++;
            else
                big[ch - 'A']++;
        }
        int c1 = 0;
        for (int i = 0; i < 26; i++)
            if (small[i]%2!=0)
                c1 = Math.max(c1, small[i]);
        for (int i = 0; i < 26; i++)
            if (big[i]%2!=0)
                c1 = Math.max(c1, big[i]);

        int total = 0;
        for (int i = 0; i < 26; i++) {
                total += ((big[i]/2)*2);

                total += ((small[i]/2)*2);
        }

       total+=c1;
        total-= ((c1/2)*2);

        return total;


    }

    void print(int ar[])
    {
        for(int i =0; i<ar.length; i++)
            System.out.print(ar[i]+'\t');
        System.out.println();

    }}
