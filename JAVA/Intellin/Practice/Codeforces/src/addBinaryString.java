import java.util.Scanner;

public class addBinaryString
{
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            String s1 = sc.next();
            String s2 = sc.next();
            String ans = solve(s1, s2);
            System.out.println(ans);
        }
    }
    static  String solve(String a, String b)
    {
        String result = "";
        int s = 0;

        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);
            result = (char)(s % 2 + '0') + result;
            s /= 2;
            i--; j--;
        }

        return result;

    }
}
