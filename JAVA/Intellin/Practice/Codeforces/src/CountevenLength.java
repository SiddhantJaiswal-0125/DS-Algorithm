import java.util.Scanner;

public class CountevenLength
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(new CountevenLength().compute_value(n));

    }
    static long factorial [];
    static int mod = 1000000007;
    public int  compute_value(int n)
    {

        return countSeq(n);

    }
    int countSeq(int n)
    {
        int nCr=1, res = 1;

        for (int r = 1; r<=n ; r++)
        {

            nCr = (nCr * (n+1-r)/r);
            nCr = mul(nCr, n+1-r);

            res = (res%mod+(nCr%mod*nCr%mod)%mod)%mod;
        }

        return res;
    }

    int add(int a, int b)
    {
        return  (a%mod+b%mod)%mod;
    }

    int mul(int a, int b)
    {
        return  (a%mod * b%mod)%mod;
    }

}
