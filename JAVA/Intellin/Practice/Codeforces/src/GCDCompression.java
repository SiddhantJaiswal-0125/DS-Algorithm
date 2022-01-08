import java.util.ArrayList;
import java.util.Scanner;

public class GCDCompression
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n  = sc.nextInt();
            int a[]  = new int[(2*n)];
            pair []ans = new pair[n-1];


            ArrayList<Integer> even = new ArrayList<Integer>();
            ArrayList <Integer> odd = new ArrayList<Integer>();

            for(int  i =0;i<2*n;i++)
            {
                a[i] = sc.nextInt();
                if(a[i]%2==0)
                    even.add(i+1);
                else
                    odd.add(i+1);
            }

//            System.out.println("EVEN SIZE "+even.size() );
//            System.out.println("ODD SIZE "+odd.size());
            int evenind = 0;
            int oddind =0;


            for(int count = 0;count< n-1;count++)
            {
                ans[count] = new pair();
                if(evenind+2 <= even.size() )
                {
                    ans[count].x = even.get(evenind++);
                    ans[count].y = even.get(evenind++);

                }
                else if(oddind+2 <= odd.size())
                {
                    ans[count].x = odd.get(oddind++);
                    ans[count].y = odd.get(oddind++);
                }


            }






            for(int i =0;i<n-1;i++) {
                System.out.println(ans[i].x + " " + ans[i].y);


            }

//            System.out.println("NEWWW");
        }
    }

    static int gcd(int a, int b)
    {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
class pair
{
    int x ,y;
//    pair (int a, int b)
//    {
//        x = a;
//        y = b;
//    }


}