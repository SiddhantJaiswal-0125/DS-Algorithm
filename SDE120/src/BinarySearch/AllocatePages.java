package BinarySearch;
import java.util.*;


public class AllocatePages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int  m = sc.nextInt();
        int ar[] = new int[n];
        for(int i =0;i<n;i++)
            ar[i] = sc.nextInt();
        int ans = findPages(ar, n,m);
        System.out.println("ANS IN "+ans);
    }
    public static int findPages(int[]A,int N,int M)
    {

        Arrays.sort(A);
        //Your code here
        int start = Integer.MAX_VALUE;
        int end = 0;
        for(int i :A)
        {
            end +=i;
            start = Math.min(i, start);

        }
        int res = -1;
        System.out.println("Start "+ start +"   end"+end);
        while(start<=end)
        {
            int mid = (start + end )/2;
            System.out.println("MID IS "+mid);
            if(isValid(A, N, M, mid) == true)
            {
                res = mid;
                end = mid -1;
            }
            else
                start = mid+1;
        }
        return res;

    }

    static boolean isValid(int A[], int n, int k , int mid)
    {
        int count = 1;
        int total = 0;
        for(int i=0;i<n;i++)
        {

            total+=A[i];
            if(total>mid)
            {
                count++;
                total = A[i];
            }
            if(count>k)
                return  false;


        }


        System.out.println("COUNT IS "+count+" for mid "+mid);
//        if(count == 0)
//            count = 1;

        return true;
    }
}

