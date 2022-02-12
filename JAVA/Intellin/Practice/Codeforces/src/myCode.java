
import java.util.Scanner;

public class myCode
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s =sc.next();
        String sr[] = s.split(",");
        int ar[] = new int[sr.length];
        for(int i =0;i<sr.length;i++)
        {
            ar[i] =   Integer.parseInt(sr[i]);
        }



        int d = 0;
        for(int i : ar)
        {
            d+= reverseit(i);
        }
        double res = d/(double)ar.length;

        System.out.println(  String.format("%.2f", res));



    }

   static int reverseit(int a)
    {
        boolean reverse = false;
        int rev = 0;
        int ac = a;

        while(ac>0)
        {
            int rem = ac%10;
            if(rem == 6)
            {
                reverse = true;
                rem = 9;
            }
            rev = rev*10 + rem;
            ac/=10;
        }



        if(reverse == false)
            return  a;

        return  rev;
    }
}
