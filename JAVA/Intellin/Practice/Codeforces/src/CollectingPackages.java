import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CollectingPackages
{
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            Pair1 []p = new Pair1[n];
            for(int i =0;i<n;i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                p[i] = new Pair1(a,b);
            }
            Compare obj = new Compare();
            obj.compare(p,n);


            boolean can = true;
            for(int i =1;i<n;i++)
                if(p[i].y<p[i-1].y)
                {
                    can = false;
                    break;
                }

            if(can)
            {
                String res = "";
                int x =0;
                int y =0;

                for(int i =0;i<n;i++)
                {
                    while(x<p[i].x)
                    {
                        res = res +"R";
                        x++;
                    }

                    while(y<p[i].y)
                    {
                        res = res+"U";
                        y++;
                    }

                }
                System.out.println("YES");
                System.out.println(res);

            }
            else
            {
                System.out.println("NO");

            }        }
    }
}
class Compare {

    static void compare(Pair1 arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Pair1>() {
            @Override public int compare(Pair1 p1, Pair1 p2)
            {
                int k = p1.x - p2.x;
                if(k!=0)
                    return  k;
                else
                    return  p1.y - p2.y;

            }
        });
    }
}
 class Pair1
{
    int x , y;
    Pair1(int a, int b) {
        x = a;
        y = b;
    }
}
