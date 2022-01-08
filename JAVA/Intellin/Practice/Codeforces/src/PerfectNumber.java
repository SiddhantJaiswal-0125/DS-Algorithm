import java.util.Scanner;

public class PerfectNumber
{
    static  int dp[] ;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int  c,b,i=0,j,k;

//        dp = new int[k+1];
//        dp[1]  = 19;
//        int add =18;
        k=19;
        while(a!=0)
        {
            c=k;k++;b=0;
            while(c!=0)
            {
                b+=c%10;c/=10;
            }
            if(b==10)
            {
                a--;
                i=k;
            }
        }
        System.out.println(i-1);






    }
}
