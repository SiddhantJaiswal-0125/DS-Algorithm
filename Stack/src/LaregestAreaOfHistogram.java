import java.util.*;
public class LaregestAreaOfHistogram
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();

//        ngl ==> NEXT SMALLER TO LEFT
        int nsl[] = findnsl(a,n);
            int nsr[] = findnsr(a,n);
//        for(int i:nsl)
//            System.out.print(i+" ");
//        System.out.println();
//
//        System.out.println();
//        System.out.println();
//
//        for(int i:nsr)
//            System.out.print(i+" ");
//        System.out.println();
        long MAX = -1l;
        long area [] = new long[n];
        for(int i = 0;i<n;i++)
        {
            area[i] = Math.abs(nsr[i] - nsl[i]) * a[i];

            if(area[i] > MAX)
                MAX = area[i];
        }
        System.out.println(MAX);



    }
    static  int [] findnsl(int a[] , int n )
    {
        Stack <Integer> index = new Stack<Integer>();
        int ans [] = new int[n];
        index.push(0);
        ans[0] = 0;
        for(int i = 1;i<n;i++)
        {
            while(!index.isEmpty() && a[index.peek()]>=a[i])
            {
                index.pop();
            }
            ans[i] = index.isEmpty()?(0):(index.peek()+1);

            index.push(i);
        }
        return ans;
    }
    static  int [] findnsr(int a[] , int n )
    {
        Stack <Integer> index = new Stack<Integer>();
        int ans [] = new int[n];
        index.push(n-1);
        ans[n-1] = n;
        for(int i = n-2;i>=0;i--)
        {
            while(!index.isEmpty() && a[index.peek()]>=a[i])
            {
                index.pop();
            }
            ans[i] = index.isEmpty()?(n):(index.peek());

            index.push(i);
        }
        return ans;
    }
}
