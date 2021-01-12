import java.util.Arrays;
import java.util.Scanner;

public class MedianOfTwoSortedArraysSameSize
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a1[] = new int[n];

        int a2[] = new int[n];
        for(int i = 0;i<n;i++)
            a1[i] = sc.nextInt();


        for(int i = 0;i<n;i++)
            a2[i] = sc.nextInt();
        Arrays.sort(a1);
        Arrays.sort(a2);
        int ans = findMedian(a1,a2,n);
        System.out.println(ans);


    }
    static  int findMedian(int a1[], int a2[], int n)
    {
        int i = 0,j = 0,count,m1 = 0,m2 = 0;
        for(count = 0;count  <=n;count++)
        {

            if(i==n)
            {
                m1= m2;
                m2= a2[0];
                break;
            }
            else if(j==n)
            {
                m1= m2;
                m2=a1[0];
                break;
            }
            if(a1[i] <= a2[j])
            {
                m1=m2;
                m2=a1[i];
                i++;

            }
            else
            {
                m1=m2;
                m2=a2[j];
            j++;
            }


        }

        return  (m1+m2)/2;
    }

}
