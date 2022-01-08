import java.util.*;

public class harshi1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int days = sol(n);
            System.out.println(days);
        }
    }
    static int  sol(int day)
    {
        int q = 0;
        while(day>1)
        {
            if(day%2==0)
                day/=2;
            else
                day = day -1;
            q++;
        }
        return  q;
    }

}
