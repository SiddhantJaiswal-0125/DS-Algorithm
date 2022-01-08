import java.util.*;

public class DoubleEndedStrings
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String a = sc.next();
            String b = sc.next();
            int n  = _longestCommonSubstring(a,b);
            int res = a.length() -n;
            res+= b.length() -n;
            System.out.println(res);
        }

    }

    static  int _longestCommonSubstring(String a, String b)
    {
       char X[] = a.toCharArray();
       char Y[] = b.toCharArray();

            int m = a.length();
            int n = b.length();

            int LCStuff[][] = new int[m + 1][n + 1];


            int result = 0;

            for (int i = 0; i <= m; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    if (i == 0 || j == 0)
                        LCStuff[i][j] = 0;
                    else if (X[i - 1] == Y[j - 1])
                    {
                        LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                        result = Integer.max(result,
                                LCStuff[i][j]);
                    }
                    else
                        LCStuff[i][j] = 0;
                }
            }
            return result;


    }
}
