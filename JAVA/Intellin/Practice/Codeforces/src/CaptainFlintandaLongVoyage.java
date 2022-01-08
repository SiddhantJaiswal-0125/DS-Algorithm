import java.util.Scanner;

public class CaptainFlintandaLongVoyage
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int  n = sc.nextInt();
            int p =(int) Math.ceil(n/4.0);
            for(int i =0;i<n-p;i++)
                System.out.print(9+"");

            for(int i = 0;i<p;i++)
                System.out.print(8+"");

            System.out.println();

        }
    }
}
