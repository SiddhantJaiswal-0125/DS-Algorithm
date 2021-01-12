import java.util.Scanner;

class MinimumswapsandKtogether
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = sc.nextInt();


            int k = sc.nextInt();
          int ans = solve2(a,n,k);
            System.out.println(ans);

        }
    }

    static int solve2(int a[],int n ,int k)
    {
        int cnt = 0;
        for(int i : a)
        {
            if(i<=k)
                cnt++;
        }

        int ans = n+1;
        for(int i =0 ;i<n-cnt+1;i++)
        {
            int temp = 0;
            for(int j =i;j <i+cnt;j++ )
            {
                if(a[j] > k)
                    temp++;
            }

            if(temp < ans)
                ans = temp;
        }
        return ans;
    }


    static  int minans1(int a[],int n,int k)
    {
        int start =0, end = n-1;
        int c = 0;
        while(start < end)
        {
            if(a[start]>k && a[end]<=k)
            {
                //swap
                c++;
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp  ;
            }
            else if(a[start]<=k && a[end]>k)
            {
                start++;
                end--;
            }
            else if(a[start]<=k )
                start++;
            else if(a[end]>k)
                end--;
        }
    return  c;
    }
}
