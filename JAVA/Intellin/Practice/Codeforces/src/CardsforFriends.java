import java.util.Scanner;

public class CardsforFriends
{
    public static void main(String[] args) {
         Scanner  sc = new Scanner(System.in);
         int t = sc.nextInt();
         while  (t-->0)
         {
             int w = sc.nextInt();
             int h = sc.nextInt();
             long n = sc.nextInt();
             if(get(w,h,n))
                 System.out.println("YES");
             else
                 System.out.println("NO");
         }
    }
    static  boolean get (int w, int h,long n)
    {
        long cnt = 1l;
        int po = 0;
        while(true)
        {
            if (w%2!=0 && h%2!=0)
            { break;}
            else
            {
            if (w % 2 == 0) {
                w =w/ 2;
                cnt +=(int) Math.pow(2,po);
            }
            else
            {
                h =h/2;
                cnt +=(int) Math.pow(2,po);

            }
            po++;
        }
        }

        return cnt>=n;




}
}

