import java.util.Scanner;

public class NumbersBox
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int test = sc.nextInt();
         while(test-->0)
         {
             int n = sc.nextInt();
             int m = sc.nextInt();
             int a[][] = new int[n][m];

             int min = Integer.MAX_VALUE;
             long count = 0;
             long sum =0l;

             for(int  i=0;i<n;i++ )
             {
                 for(int j=0;j<m;j++)
                 {
                     a[i][j] = sc.nextInt();
                        if(a[i][j]<=0)
                            count++;

                     if(Math.abs(a[i][j])<min)
                         min = Math.abs(a[i][j]);

                     sum+=Math.abs(a[i][j]);
                 }
             }

             if(count%2==0)
                 System.out.println(sum);
             else
                 System.out.println(sum -(2*min));



         }
    }



}
