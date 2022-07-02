import java.util.Arrays;
import java.util.Scanner;

public class MaximumArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int sH = sc.nextInt();
        int hr[] = new int[sH];
        for(int i =0;i <sH; i++)
            hr[i] = sc.nextInt();
        int sW = sc.nextInt();
        int vt[] = new int[sW];

        for(int i=0;i<sW; i++)
            vt[i]  = sc.nextInt();

        int ans = new MaximumArea().maxArea(h,w, hr, vt);
        System.out.println(ans);

    }
    public int maxArea(int h, int w, int[] hr, int[] vt) {
        Arrays.sort(hr);
        Arrays.sort(vt);
        int maxH = -1;
        int prev =0;
        for(int i : hr)
        {
            int temp = i- prev;
            if(temp > maxH)
                maxH = temp;
            prev = i;
        }


        if(h - prev > maxH)
            maxH = h -prev;


        prev = 0;
        int maxV =0;
        for(int i : vt)
        {
            int temp = i- prev;
            if(temp > maxV)
                maxV = temp;
            prev = i;
        }
        if(w - prev > maxV)
            maxV = w -prev;


        System.out.println("MAX H "+maxH );
        System.out.println("MAX V "+maxV);
        int mod  = 1000000007;
        long val = maxH *1l* maxV;

        return (int)(val %mod );



    }
}
