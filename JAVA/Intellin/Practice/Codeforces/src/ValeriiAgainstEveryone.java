import java.util.HashSet;
import java.util.Scanner;

public class ValeriiAgainstEveryone
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            long b[] = new long[n];
            boolean isExist = false;
            HashSet<Long>  hs  = new HashSet<>();
            for(int i =0;i<n;i++)
            {
                b[i] = sc.nextInt();
                if(hs.contains(b[i]))
                    isExist = true;


                hs.add(b[i]);
            }

            if(isExist)
                System.out.println("YES");

            else
                System.out.println("NO");



        }

    }

    
}
