import java.util.Scanner;

public class StrangePartition {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int a[] =  new   int[n];
            long sum = 0l;
            int count = 0;
            for(int i = 0;i<n;i++)
            {
                a[i] = sc.nextInt();
                sum +=a[i];
                count+=Math.ceil(a[i]/(double)x);


            }
            long min =  (long)Math.ceil(sum/(double)x);
            System.out.println(min+" "+count);

        }
    }
}
