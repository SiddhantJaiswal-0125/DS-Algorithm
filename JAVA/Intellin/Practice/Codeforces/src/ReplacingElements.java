import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ReplacingElements
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
           int n = sc.nextInt();
           int d = sc.nextInt();

           long a[] = new long[n];
            boolean ifall = true;
           for(int i =0;i<n;i++) {
               a[i] = sc.nextInt();
           if(a[i]>d)
               ifall=false;

           }
            Arrays.sort(a);
           long sum = a[0]+a[1];
           for(int i =n-1;i>=0;i--)
           {
               if(a[i]<=d)
                   break;
               a[i]  = sum;
           }

           boolean yes = true;
           for(int i=n-1;i>=0;i--)
           {
               if(a[i]>d)
               {
                   yes = false;
                   break;
               }
           }

           if (yes)
               System.out.println("YES");
           else
               System.out.println("NO");

        }


    }


}
