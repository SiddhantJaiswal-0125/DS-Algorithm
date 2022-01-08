import java.util.Scanner;

public class strangelist
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long a[] = new long[n];
            long b[] = new long[n];
            long k ,temp = Long.MAX_VALUE;
            for(int i = 0;i<n;i++)
            {
                a[i] = sc.nextLong();
                k=a[i];
                long c = 1l;
                while(k%x==0)
                {
                    c++;
                    k/=x;

                }
                b[i] = c;
                temp = Math.min(temp,c);
            }
            int index =0;
            long res = 0l;
            for(int i= 0;i<n;i++)
            {
                if(b[i]==temp){
                    index = i;
                break;}
            }
            for(int i=0;i<index;i++)
            {
                res+=a[i]*(temp+1);
            }
            for(int i = index;i<n;i++)
            {
               res+=a[i]*temp;
            }
            System.out.println(res);
        }
    }
}
