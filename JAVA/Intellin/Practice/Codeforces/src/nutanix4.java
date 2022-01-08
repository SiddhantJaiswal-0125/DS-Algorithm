import java.util.Arrays;
import java.util.Scanner;

public class nutanix4
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] =  new int[n];
        for(int i =0;i<n;i++)
            a[i] = sc.nextInt();
        int ans [] = new int[n];
        Arrays.fill(ans,1);
        for(int i =1;i<n;i++)
        {
            if(a[i]>a[i-1])
                ans[i] = ans[i-1]+1;
        }

        for(int i = n-2;i>=0;i--)
        {
            if(a[i]>a[i+1] && ans[i]<= ans[i+1])
                ans[i] = ans[i+1]+1;

        }
        long total = 0l;
        for(int i:ans)
            total+=i;
        System.out.println(total);


    }

}
