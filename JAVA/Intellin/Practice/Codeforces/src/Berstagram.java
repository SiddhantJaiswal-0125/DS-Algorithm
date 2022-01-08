import java.util.Arrays;
import java.util.Scanner;

public class Berstagram
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int m = sc.nextInt();
        int pos[]  = new int[n+1];

        pair2[] ans = new pair2[n+1];
        for(int i =0;i<=n;i++) {
            ans[i] = new pair2(i);
            pos[i]  = i;
        }
        while(m-->0)
        {
            int q = sc.nextInt();


        }






//        for(int i=0;i<m;i++)
//        {
//            a[sc.nextInt()-1]++;
//        }

    }

}
class pair2
{
    int min , max, cur, val;
    pair2(int m)
    {
        min = m;
        max = m;
        cur = m;
        val =0;

    }
}
