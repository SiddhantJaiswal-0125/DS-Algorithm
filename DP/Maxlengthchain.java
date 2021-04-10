import java.util.*;

public class Maxlengthchain {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair   a[] = new Pair[n];
        for(int i  =0;i<n;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[i] = new Pair(x, y);
        }

        Arrays.sort(a, new Comparator<Pair>() { 
            @Override public int compare(Pair p1, Pair p2) 
            { 
                return p1.y - p2.y; 
            } 
        }); 

        int dp[] = new int [n];
        dp[0] = 1;
        for(int i =1;i<n;i++)
        {
            int max = 0;

            for(int j =0;j<i;j++)
            {
                if(a[i].x>a[j].y)
                    max = Math.max(max, dp[j]);
            }
            dp[i] =max+1;
        }
            int mx = dp[0];
            for(int i :dp)
            mx = Math.max(mx, i);

        System.out.println(mx);
  
        // for (int i = 0; i < n; i++) { 
        //     System.out.println(a[i].x + " " + a[i].y + " "); 
        // } 
        // System.out.println();

        sc.close();

    }
}
class Pair 
{
    int x  , y;
    Pair(int a, int b)
    {
        x = a;
        y =b;

    }

}
