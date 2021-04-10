import java.util.Scanner;

public class MiddleofThree
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c  = sc.nextInt();
        int ans = solve(a,b,c);
        System.out.println(ans);
    }
    static int solve(int a, int b,int c)
    {
        if(b>c)
        {
            if(a>b)
                return b;
            else if(a>c)
                return a;
            else return c;


        }
        else
        {
            if(a>c)
                return  c;
            else if (a>b)
                return  a;
            else return b;

        }

    }
}
