import java.util.Scanner;

public class DivideTwoIntegers
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int a = sc.nextInt();
        int b= sc.nextInt();
        System.out.println( divide(a,b));
    }
    public static int divide(int dividend, int divisor)
    {
        int count =0;
        long a = dividend;

        boolean neg = false;
        if(dividend < 0 && divisor < 0)
        {
//            System.out.println("HERE both");

            dividend = -1 * dividend ;
            divisor  = -1 * divisor;

        }
        else{

            if(dividend < 0 )
            {
                dividend = -1 * dividend;
                neg = true;
            }
            else if ( divisor < 0)
            {
                divisor = - 1 * divisor;

                neg = true;
            }
        }

//        System.out.println(dividend+ " \t"+divisor);

        a = Math.abs(a);
        divisor = Math.abs(divisor);
        while(a >= divisor)
        {
//            System.out.println("HERE");
            count++;
            a -= divisor;
            if(count==Integer.MAX_VALUE)
                break;
        }
        if(neg)
            count = -1* count;
        return count;
    }
}
