import java.util.Scanner;

/*Dynamic Programming Approach*/
 class LongestCommonSubsequence
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            String copy = new String(s);
            int ans = solve(n,s,copy);
            System.out.println(ans);
        }
    }
    static int solve(int n , String s , String copy)
    {
        int t[][] = new int[n+1][n+1];
        for(int i = 0;i<n+1;i++)
            for(int j = 0;j<n+1;j++)
                if(i==0||j==0)
                    t[i][j] = 0;
        for(int i= 1;i<n+1;i++)
        {
            for(int j =1;j<n+1;j++)
            {
                if(s.charAt(i-1)==s.charAt(j-1) && i!=j)
                {
                    t[i][j] = t[i-1][j-1] + 1;
                }
                else
                    t[i][j] = max(t[i-1][j],t[i][j-1]);
            }
        }


    return t[n][n];
    }
    static int max (int a, int b)
    {
        return a>b?a:b;
    }
}

