import java.util.HashSet;
import java.util.Scanner;

public class RearrangeArray
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        solve(a,n);
    for(int i: a)
        System.out.print(i+" ");
    System.out.println();
    }
    static  int cur , end;
    static  void solve(int a[],int n)
    {
        int last = 0, cur = 1, end = n-1;
        last = a[0];
        boolean l = ispos(last);
        while(cur<end && cur < n)
        {
            boolean c = ispos(a[cur]);
            l = ispos(last);
            if((l&&!c)||(!l&&c))
            {
                last = a[cur];
//                cur++;
               l = c;
            }
            else
            {
                if(l)
                {
                    //last one is positive
                    //cur is negative
                    findneg(a,cur,end);
//                    cur++;


                }
                else
                {
                    // last one is negative
                    //cur is positive
                    findpos(a,cur,end);
//                    cur++;
                }
            }
            last = a[cur];
            cur++;
        }



    }


static boolean ispos(int a)
{
    return  a>=0;
}
static  void findpos(int a[],int cur,int end)
{
    //finding positive
    while(cur<end)
    {
        if(a[end]>=0)
        {
            swap(a,cur,end);
            break;
        }
        else
            end--;
    }
}
    static  void findneg(int a[],int cur,int end)
    {
        //finding positive
        while(cur<end)
        {
            if(a[end]<0)
            {
                swap(a,cur,end);
                break;
            }
            else
                end--;
        }
    }


static void swap(int a[],int i ,int j)
{

    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;

}
}
