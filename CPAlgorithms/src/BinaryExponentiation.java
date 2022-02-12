public class BinaryExponentiation
{
    public static void main(String[] args)
    {
        System.out.println(BinExpo(2,6));
    }

    static long BinExpo( long a,  long b)
    {
    if (b == 0)
        return 1;
     long res = BinExpo(a, b / 2);
    if (b % 2==1)
        return res * res * a;
    else
        return res * res;
    }

    //this apporach is little faster !!
     long binpow( long a,  long b) {
     long res = 1;
    while (b > 0)
    {
        if ((b & 1) ==1)
            res = res * a;
        a = a * a;
        b >>= 1;
    }
    return res;
}
}
