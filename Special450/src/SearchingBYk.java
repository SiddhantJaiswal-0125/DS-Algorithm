import java.util.Scanner;

public class SearchingBYk
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int test = sc.nextInt();
         while(test-->0)
         {
             int n = sc.nextInt();
             int x = sc.nextInt();
             int k = sc.nextInt();

             int a[] = new int[n];
             for(int i =0;i<n;i++)
                 a[i] = sc.nextInt();
             int find = search(a,n,x,k);
             if ((find != -1)) {
                 System.out.println("found at i " + find);
             } else {
                 System.out.println("NOT FOUND");
             }

         }

    }
    static   int search(int a[],int n , int x, int k)
    {
        int i =0;
        while(i<n)
        {
            if(a[i]==x)
                return i;
            i = i+ Math.max(1, Math.abs(x-a[i])/k);

        }
        return  -1;

    }
}
