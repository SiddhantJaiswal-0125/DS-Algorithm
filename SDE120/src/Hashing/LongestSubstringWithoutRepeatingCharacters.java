package Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring2(s);
        System.out.println(ans);

    }
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>  hs = new HashSet<>();
        int max = -1;

        int size = s.length();

        for(int i =0;i<size;i++)
        {
            hs = new HashSet<>();
            hs.add(s.charAt(i));

            for(int j = i+1;j<size;j++)
            {
                char c = s.charAt(j);

                if(hs.contains(c))
                    break;

                hs.add(c);

            }

            if(hs.size()>max)
                max = hs.size();

        }
        return max;

    }
    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character>  hs = new HashSet<>();

        int max = 0;
        int size = s.length();
        if(size==0)
            return 0;
        int l = 0, r = 1;
        hs.add(s.charAt(0));
        while(r<size && l<=r)
        {
            char c = s.charAt(r);
            if(hs.contains(c))
            {

                while(s.charAt(l)!=c)
                {
                    hs.remove(s.charAt(l));
                    l++;
                }
                l++;

                hs.remove(c);

            }

            hs.add(c);
            if((r-l+1) > max)
                max = r-l+1;
            r++;



        }


        return Math.max(max, hs.size());


    }

}
