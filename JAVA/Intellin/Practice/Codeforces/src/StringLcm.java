import java.util.Scanner;

public class StringLcm
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while   (test-->0)
        {
            String a = sc. next();
            String b = sc.next();
            int lenA = a.length();
            int lenB = b.length();
            long lcm = lcm(lenA,lenB);
            String res1 = "";
            for(int i =0;i<lcm/lenA;i++)
            {
                res1+=a;
            }

            String res2 = "";
            for(int i =0;i<lcm/lenB;i++)
            {
                res2+=b;
            }


            if (res1.equalsIgnoreCase(res2))
                System.out.println(res1);
            else
                System.out.println(-1);


        }
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

}
