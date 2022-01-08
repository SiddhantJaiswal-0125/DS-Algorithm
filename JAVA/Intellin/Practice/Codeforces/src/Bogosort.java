import java.util.Arrays;
import java.util.Scanner;

public class Bogosort
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int test = sc.nextInt();
         while(test-->0)
         {
             int n = sc.nextInt();
             int a[] = new int[n];
             for(int i =0;i<n;i++)
                 a[i] = sc.nextInt();
             Arrays.sort(a);
             //sort it and print it reverse
             for(int i = n-1;i>=0;i-- )
                 System.out.print(a[i]+" ");
             System.out.println();
         }
    }
}
