
import java.util.Scanner;

public class Increase_and_Copy
{
    static Scanner sc= new Scanner(System.in);

    public static void main(String[] args)
    {   int t = sc.nextInt();
        while(t-->0)
        {
                solve();
        }
    }


   static void solve()
   {
       long n =sc.nextLong();
       long sum =1;
       int count =0;
       int z=1;
       if(z<n){
       while(z<(long)Math.sqrt(n))
       {
           z++;
           count++;
       }
       sum = z;
       }
       while (sum<n)
       {
           sum+=z;
           count++;
       }

       System.out.println(count);










   }


}
