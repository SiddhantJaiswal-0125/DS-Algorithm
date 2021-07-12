package Arrays;

import java.util.*;
public class POW
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(new POW().myPow(x, n));
    }
    public double myPow(double x, int n) {
        return res(x,n);
    }
    double res(double x, long n)
    {
        if(n==0)
            return 1;
        long power = 0l;
        if(n<0)
        {
            power = -1* n;
            x = 1/x;

        }
        else
            power = n;

        return
                (power%2==0) ? res(x*x, power/2):x*res(x*x,power/2);
    }
}
