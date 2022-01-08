import java.util.Scanner;

public class binaryExponentiation
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(binpow(2,5));
    }
    static long binpow( long a,  long b)
    {
    if (b == 0)
        return 1;
     long res = binpow(a, b / 2);
    if (b % 2==1)
        return res * res * a;
    else
        return res * res;
}
}
