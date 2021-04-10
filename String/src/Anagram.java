import java.util.Scanner;

public class Anagram
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {
            String s =sc.next();
            int ans = solve(s);
            System.out.println(ans);
        }

    }
    static int solve(String s)
    {
        int count = 0;
        int freqIni[] = new int[26];
        int freqEnd[] = new int[26] ;
        int n = s.length();
        if(n%2!=0)
            return -1;
        else
        {
            for(int i = 0;i<n;i++)
            {
                char c = s.charAt(i);
             if(i<n/2)
                 freqIni[c-'a']++;
             else
                 freqEnd[c-'a']++;

            }

            for(int i=0;i<26;i++)
            {
               if(freqIni[i]>freqEnd[i])
                   count+=(freqIni[i]-freqEnd[i]);
            }
        return  count;
        }

    }

}
