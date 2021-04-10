import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

public class WordBreak
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {

            System.out.println("ENTER THE DICTONARY");
            ArrayList<String>  ar = new ArrayList<String> ();
            for(int i= 0;i<12;i++) {
             String dict = sc.next();
                ar.add(dict);
            }
            String s  = sc.next();
            System.out.println(solve(s,ar));

        }
    }
    static int solve(String s , ArrayList<String> al)
    {
        HashSet<String > hs = new HashSet<String> ();
        for(int i = 0;i<al.size();i++)
        {
            hs.add(al.get(i));
        }


        int n = s.length();
        int dp[] = new int[n];
        for(int i =0;i<n;i++)
        {
            for(int j = 0;j<i;j++)
            {
                String word2check = s.substring(j,i+1);

                if(hs.contains(word2check)) {
                    if(j>0)
                    dp[i] += dp[j-1];
                    else
                        dp[i] += 1;

                }

            }
        }
        for(int i =0;i<n;i++)
        {
            System.out.print(dp[i]+" ");
        }
        System.out.println();

        if(dp[s.length()-1]>0)
            return 1;

        return 0;


    }
}
