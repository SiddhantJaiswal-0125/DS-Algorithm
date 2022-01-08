import java.util.Scanner;

class test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b  = sc.nextInt();
        long ans = GetLongestStreak(a, b);
        System.out.println(ans);




    }

    static long GetLongestStreak(int a,int b)
    {
        long x = a ^ b;
        long y = a * 1l * b;
        long z = a + b;

        long c1 = getOnes(x);
        long c2 = getOnes(y);
        long c3 = getOnes(z);
        System.out.println("C1: "+x+" " +c1);
        System.out.println("C2:  "+y+" "+c2);
        System.out.println("C3:  "+z+" "+c3);
        if(c1==c2)
            if(c2==c3)
                return Math.min(x, Math.min(y,z));
            else
                return Math.min(x,y);
        else if(c2==c3)
        return Math.min(y,z);

        else if (c1 == c3)
            return  Math.min(x,z);
        else if(c1>c2 && c1>c3)
            return x;
        else if(c2>c3 && c2>c1)
            return  y;
        else
            return z;
    }
    private static long getOnes(long x)
    {
        long count = 0;

        while (x!=0)
        {
            x = (x & (x << 1));
            count++;
        }
        return count;
    }
}