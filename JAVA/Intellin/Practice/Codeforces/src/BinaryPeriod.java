import java.util.HashSet;
import java.util.Scanner;

public class BinaryPeriod
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test -->0)
        {
            String s = sc.next();
            int leng = s.length();
            HashSet <Character> both = new HashSet<>();

            for(int i = 0;i<leng;i++)
            {
                both.add(s.charAt(i));
                if(both.size()==2)
                    break;

            }
            if(both.size()==2)
            {
                for(int i = 0;i<(2*leng);i++)
                {
                    if(i%2==0)
                        System.out.print("1");
                    else
                        System.out.print("0");
                }
                System.out.println();

            }
            else
            {
                System.out.println(s);

            }

        }
    }
}
