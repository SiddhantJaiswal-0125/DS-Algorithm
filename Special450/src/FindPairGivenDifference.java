import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FindPairGivenDifference
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int x =  sc.nextInt();

            int a[] = new int[n];
            HashSet<Integer> hs = new HashSet<>();
            boolean find = false;
            for(int  i =0;i<n;i++)
            {
                a[i] = sc.nextInt();
                hs.add(a[i]);
            }
            for(int  i =0;i<n;i++)
            {
                if (!find )
                {
                    int dif = a[i]-x;
                    if(hs.contains(dif))
                        find = true;

                }
            
            }
            if(find)
                System.out.println(1);
            else System.out.println("-1");
        }
    }
}
