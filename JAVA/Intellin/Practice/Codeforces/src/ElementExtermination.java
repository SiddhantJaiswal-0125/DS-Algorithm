import java.util.Scanner;

public class ElementExtermination
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            int max = -1;

            for(int i =0;i<n;i++)
                a[i] = sc.nextInt();


            if(a[n-1]>a[0])
                System.out.println("YES");
            else
                System.out.println("NO");


        }
    }
}
