import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class RepaintingStreet
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int c[] = new int[n];
            int freq[] = new int[101];
            int max = 0;
            int color = 0;
            HashSet<Integer >hs =  new HashSet<>();
            for(int i =0;i<n;i++)
            {
                c[i] = sc.nextInt();
                hs.add(c[i]);

            }
            int mindays = Integer.MAX_VALUE;
            int days = 0;
            Iterator<Integer> it = hs.iterator();
            while (it.hasNext())
            {
                int ci = it.next();
                days = 0;
                for(int i = 0;i<n;)
                {
                if(c[i]!=ci)
                {
                    days++;
                    i+=k;
                }
                else
                    i++;
                }
                if(days<mindays)
                    mindays = days;

            }
            System.out.println(mindays);



        }
    }
}
