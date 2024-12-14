package BinarySearch;


    import java.util.*;
import java.lang.*;

    class Main
    {
        public static void main (String[] args) throws java.lang.Exception
        {

            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int ar[] = new int[n];
                for(int i =0;i<n;i++)
                    ar[i] = sc.nextInt();
                long ans = solve(n,m, ar);
                System.out.println(ans);
            }
        }
        static long solve(int n, int m, int ar[])
        {
            Arrays.sort(ar);
            long start =  0l;
            long end = 0l;
            for(int i =1;i<n;i++)
                end+=(ar[i]- ar[i-1]);
            System.out.println("END IS "+end);

            long res = -1;

            while(start<=end)
            {
                long mid = (start + end) /2;
                if(isValid(ar, n, m, mid) == true)
                {
                    res = mid;
                    start = mid +1;
                }
                else
                {
                    end = mid -1;
                }


            }
            return res;

        }
        static boolean isValid(int A[], int n, int k , long mid)
        {
            int count = 1;
            int total = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=1;i<n;i++)
            {
                max = A[i];
                if(max-min >0)
                total+=(A[i]- A[i-1]);
                if(total>mid)
                {
                    count++;
                    total = A[i]-A[i-1];
                }
                if(count>=k)
                    return  true;


            }



//        if(count == 0)
//            count = 1;

            return false;
        }
}
