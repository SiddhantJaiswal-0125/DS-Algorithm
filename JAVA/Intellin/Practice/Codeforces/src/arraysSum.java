import java.util.HashSet;
import java.util.Scanner;

public class arraysSum
{
    public static void main(String[] args) {
        Scanner  sc  = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int  n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];

            HashSet <Integer> hs = new HashSet<>();
            for(int i =0;i<n;i++)
            {
                a[i] = sc.nextInt();
                hs.add(a[i]);
            }

            if(k==1)
            {
                if(hs.size()==1)
                    System.out.println(1);
                else
                    System.out.println(-1);
            }
            else
            {
//                System.out.println("h size "+hs.size());
                if(hs.size()<=k)
                    System.out.println(1);
                else{
//                    System.out.println("k "+k);

                    int p = (int)Math.ceil( (double)(hs.size()-1)/(double) (k-1));
                    System.out.println(p);


                }

            }
        }
    }
}