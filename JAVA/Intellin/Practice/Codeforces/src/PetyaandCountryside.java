import java.util.Scanner;

public class PetyaandCountryside
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]  = new int[n];
        for(int  i =0;i<n;i++)
            a[i]  = sc.nextInt();
        int max =1;
        int i =0;
        while(i<n)
        {
            int k = i-1;
            int count =1;
            while(k>=0)
            {
                if(a[k]<=a[k+1]) {
                    count++;
                    k--;

                }
                else
                    break;
            }

            while(i<n-1)
            {
                if(a[i]>=a[i+1]) {
                    count++;
                    i++;

                }
                else
                    break;

            }

            if(count>max)
                max = count;

            i++;
        }
        System.out.println(max);
    }
}
