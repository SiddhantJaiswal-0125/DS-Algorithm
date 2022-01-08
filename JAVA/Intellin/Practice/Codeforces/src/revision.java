import java.util.Scanner;

public class revision
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {

            String a = sc.next();
            String b = sc.next();
            int n  = LCSubStr(a.toCharArray() ,b.toCharArray(),
                    a.length(), b.length());
//            System.out.println("COMMON LENGTH : "+n);

                int ans = a.length() - n;
                ans = ans + b.length() -n;
            System.out.println(ans);








        }
    }
    static int LCSubStr(char X[], char Y[], int m, int n)
    {
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
                    LCStuff[i][j]
                            = LCStuff[i - 1][j - 1] + 1;
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
