import java.util.Scanner;

public class ClimbStairs
{
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int  n  = sc.nextInt();
        solve(n);
    }
    static void solve(int n )
    {
        long a  =1;
        long b = 2;
        long c = 4;


        long sum  =0;


        for(int i=3;i<=n;i++)
        {
            sum =  a+b+c ;
            a = b;
            b = c;
            c = sum;


        }
        if(n==0)
            System.out.println(0);
        else if(n==1)
            System.out.println(1);
        else if(n==2)
            System.out.println(2);
        else if(n==3)
            System.out.println(4);
        else
            System.out.println(sum);







    }
}
