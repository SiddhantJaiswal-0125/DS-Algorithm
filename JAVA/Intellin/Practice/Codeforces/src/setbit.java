import java.util.Scanner;

public class setbit
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c =0;
        while(n>0)
        {
            if(n%2!=0)
                c++;
            n/=2;
        }
        System.out.println(c);
    }
}
