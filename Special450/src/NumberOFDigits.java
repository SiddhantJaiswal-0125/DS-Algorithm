import java.util.Scanner;

public class NumberOFDigits
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = _Count(n);
        System.out.println(count);
    }
    static  int _Count(int n)
    {

        return  (int)(Math.log10(n))+1;

    }
}
