import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LongestChainString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s[] = new String[n];
        for(int i =0;i<n;i++)
            s[i]= sc.next();
        System.out.println(new Solution().longestStrChain(s));
    }
    static class Solution {
        public int longestStrChain(String[] words) {
            int size = words.length;

            int dp[] = new int[size];
            Arrays.sort(words, (a, b)->a.length() - b.length());
            for(int i = 0;i<size;i++)
            {
                dp[i] = 1;
                for(int j =0; j<i;j++)
                    if(isPoss(words[i] , words[j]))
                    {
//                        System.out.println("HERE");
//                        dp[i] = words[i].length();
//                        break;
                        dp[i] = Math.max(dp[j]+1, dp[i]);
                        // break;
                    }
            }


            int max = -1;
            for(int i : dp)
                max = Math.max(i, max);

            return max;

        }


//["bdca","bda","ca","dca","a"]

//["xbc","pcxbcf","xb","cxbc","pcxbc"]
        boolean isPoss(String a, String b)
        {
            if((b.length() + 1 )!= a.length()) {
//                System.out.println("HERE");
                return false;
            }
//            System.out.println("HERE");

            boolean check =  false;


            int i =0, j =0;
            while(i< a.length() && j<b.length())
            {
                char c1 =  a.charAt(i);
                char c2 = b.charAt(j);

                if(c1==c2)
                {
                    i++;
                    j++;
                }
                else
                {
                    if(check)
                        return false;
                    else
                    {
                        check = true;
                        i++;
                    }
                }


            }

            return true;
        }
    }

}
