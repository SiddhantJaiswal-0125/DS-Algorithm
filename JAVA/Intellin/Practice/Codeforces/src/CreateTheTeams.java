import java.util.Arrays;
import java.util.Scanner;

public class CreateTheTeams
{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++)
                a[i]  = sc.nextInt();
            Arrays.sort(a);
            int i =n-1;
            int count =0;
            int k =1;
            while(i>=0)
            {
               if((a[i]*k)>=x)
               {
                   count++;
                   k = 1;
               }
               else if(i>0)
                   k++;
               i--;
            }
            System.out.println(count);
        }
    }
}
