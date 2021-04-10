//Two strings are anagrams of each other if the
//letters of one string can be rearranged to form the other string.
// Given a string, find the number of pairs of substrings of the string that are anagrams of each other.


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockandAnagrams
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {
            String s = sc.next();
            int count = solve(s);
            System.out.println(count);
        }
    }
    static int solve(String s )
    {
        int anagrams = 0;
        int n = s.length();

        Map<String , Integer> hashMap = new HashMap<String, Integer>();
        for(int i =0;i<n;i++)
        {
            for(int  j = i;j<n;j++)
            {
                char c[] = s.substring(i,j+1).toCharArray();
                Arrays.sort(c);
                String k = new String(c);
                if(hashMap.containsKey(k))
                    hashMap.put(k,hashMap.get(k)+1);
                else
                    hashMap.put(k,1);


            }
        }
        for(String a:hashMap.keySet())
        {
            int v = hashMap.get(a);
            anagrams+= (v*(v-1))/2;

        }



        return  anagrams;

    }
}
