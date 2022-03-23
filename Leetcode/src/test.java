import java.util.Scanner;

class test
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int  n = sc.nextInt();
         String ans = solve(n);
        System.out.println(ans);

    }
    static  String solve(int n)
    {
        StringBuffer sb = new StringBuffer();

        while(n>0)
        {
            int rem = n%2;
            sb.append(rem);
            n/=2;
        }

        return new String(sb.reverse());
    }
}