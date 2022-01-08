import java.util.Scanner;

public class Productarraypuzzle
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[]  = new int[n];
        for(int i =0;i<n;i++)
            a[i] = sc.nextInt();
        long ans[] = solve(a,n);
        for(long i : ans)
        System.out.print(i+" ");
        System.out.println();
    }
    static long [] solve(int arr[], int n)
    {
        long ans[] = new long[n];
        long pro = 1l;
        ans[0] = 1;

        int noofzeros = 0;
        for(int i :arr)
        {
            pro*=i;
            if(i==0)
                noofzeros++;
        }

//        System.out.println("product  : " +pro);

        if(noofzeros>1)
            for(int i =0;i<n;i++)
            {
                ans[i] = 0;
            }
        else
        {
            for(int i =0;i<n;i++)
            {

                if(arr[i]!=0)
                {
                    ans[i]= pro/arr[i];
                }
                else
                    {
                        ans[i] = 1;
                        long p = 1;
                        for(int j =0;j<n;j++)
                        {
                            if(j!=i)
                                p*=arr[j];

//                                ans[i]*=arr[j];
                        }
                        ans[i] = p;
                    }

            }


        }
        return ans;
    }
}
