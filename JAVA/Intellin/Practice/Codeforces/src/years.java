import java.util.*;
public class years
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b[]=new int[n];
        int d[]=new int[n];
        int i,j;
        for(i=0;i<n;i++)
        {
            b[i]=sc.nextInt();
            d[i]=sc.nextInt();
        }
        Arrays.sort(b);
        Arrays.sort(d);
        int x=1, y=b[0], max=1;
        j=0;
        for(i=1;i<n;i++) {
            while(j<n && d[j]<=b[i]) {
                x--;
                j++;
            }
            x++;
            if(x>max) {
                max=x;
                y=b[i];
            }
        }
        System.out.println(y+" "+max);
    }
}