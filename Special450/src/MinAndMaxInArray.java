import java.util.Scanner;

/*Problem link : https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 */
public class MinAndMaxInArray
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        pair ans = new pair();

        ans = getMinMax(a,n);

        System.out.println(ans.max+" "+ans.min);
    }
    static  pair getMinMax( int a[],int n)
    {
        pair ans = new pair();
        if(n==1)
        {
            ans.max = a[0];
            ans.min = a[0];
            return  ans;
        }
        if(a[0]>a[1])
        {
            ans.max = a[0];
            ans.min = a[1];

        }
        else
        {
            ans.max = a[1];
            ans.min = a[0];
        }



        for(int i =2;i<n;i++)
        {
            if(a[i]>ans.max)
                ans.max = a[i];
            else if(a[i]<ans.min)
                ans.min = a[i];
        }

        return  ans;



    }




}
class pair
{
    int min ,max;
}
