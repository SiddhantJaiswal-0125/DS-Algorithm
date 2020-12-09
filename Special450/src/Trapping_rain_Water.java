import java.util.Scanner;

public class Trapping_rain_Water
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        int n = sc.nextInt();
        int b[] = new int[n];
        for(int i = 0;i<n;i++)
            b[i] = sc.nextInt();
        int maxL[] = new int[n];
        maxL[0] = b[0];
        for(int i  =1 ;i<n;i++)
        {
            maxL[i] =  Math.max(maxL[i-1],b[i]);
        }
        int maxR[] = new int[n];
        maxR[n-1] = b[n-1];
        int min[] = new int[n];
        long ans = 0l;
        min[n-1] = Math.min(maxL[n-1],maxR[n-1]);

            for(int i  =n-2 ;i>=0;i--)
        {
            maxR[i] =  Math.max(maxR[i+1],b[i]);
            min[i] = Math.min(maxL[i],maxR[i]);
            ans +=(min[i] - b[i]);
        }
        System.out.println(ans);
        }

    }
}
