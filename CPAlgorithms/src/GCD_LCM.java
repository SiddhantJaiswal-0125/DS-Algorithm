import java.util.Scanner;

 class GCD_LCM
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long gcd  = _getGcd(a,b);
            long lcm = (a/gcd)*b;
            System.out.println(gcd+" "+lcm );
        }
    }
    static long _getGcd(long a ,long b)
    {
        if(b==0)
            return  a;
        return _getGcd(b,a%b);
    }
}
