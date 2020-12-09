import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Factorialsoflargenumbers
{
    static BigInteger a[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        a = new BigInteger[1000];
        for(int i = 0; i<1000;i++)
        {
            a[i] = new BigInteger("0");
            a[i] = BigInteger.valueOf(0);
        }
        while(t-->0)
        {
            int n = sc.nextInt();
            System.out.println(factorial(n));
        }
    }
    public static BigInteger factorial(int number) {

            if(number==0||number==1)
                return a[number] = BigInteger.valueOf(1);
            if(a[number-1]!=BigInteger.valueOf(0))
                return a[number-1];


        return a[number-1] = BigInteger.valueOf(number).multiply(factorial(number-1));


    }
}
