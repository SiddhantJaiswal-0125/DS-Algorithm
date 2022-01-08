import java.util.Scanner;

public class MagicStick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            if (x == y || x>y) {
                System.out.println("YES");
            }
            else
            {
                if(x==1)
                    System.out.println("NO");
                else
                {
                    if(x<=3) {
                     if(y==3)
                        System.out.println("YES");
                     else
                         System.out.println("NO");

                    }
                    else
                    {
                        System.out.println("YES");


                    }
                }
            }
        }
    }
}
