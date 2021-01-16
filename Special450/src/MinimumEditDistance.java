import java.util.Scanner;

public class MinimumEditDistance
{
    //using dp
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -- >0)
        {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(_solve(s1,s2));
        }
    }
    static  int _solve(String s,String t)
    {
        int len1 = s.length();
        int len2 = t.length();
        int dp [][] = new int[len2+1][len1+1];
        for(int i = 0;i<len1+1;i++)
        {
            dp[0][i] = i;
        }
        for(int i = 0;i<len2+1;i++)
        {
            dp[i][0] = i;
        }

        for(int i = 1;i<len2+1;i++)
        {
            for(int j =1;j<len1+1;j++)
            {
                if(s.charAt(j-1)==t.charAt(i-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = minthree(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                }
            }
        }




        return  dp[len2][len1];
    }
        static  int minthree (int a,int b,int c)
    {
        return  mintwo(a,mintwo(b,c));
    }
    static int mintwo(int a ,int b)
    {
        return  a<b?a:b;
    }
}
