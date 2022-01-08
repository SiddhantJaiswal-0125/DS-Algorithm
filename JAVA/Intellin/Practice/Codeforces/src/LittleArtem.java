import java.util.Arrays;
import java.util.Scanner;

public class LittleArtem
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] ans = new char[n][m];
           fill(ans,n,m,'B');
           ans[n-1][m-1] = 'W';
           display(ans,n,m);



        }
    }
    static void fill(char a[][] , int n , int m,char c)
    {
        for(int  i =0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
                a[i][j] = c;
        }
    }
    static void display(char a[][] , int n , int m)
    {
        for(int  i =0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
                System.out.print(a[i][j]+"");

            System.out.println();
        }
    }
}
