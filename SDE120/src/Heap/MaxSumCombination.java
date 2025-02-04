package Heap;


import java.util.*;

public class MaxSumCombination {



   static class PairSum implements Comparable<PairSum>
    {
        int sum;
        int l, r;
        PairSum(int sum, int l, int r)
        {
            this.sum = sum;
            this.l = l;
            this.r = r;
        }
        public int compareTo(PairSum oth)
        {

           return  oth.sum - this.sum;
        }
    }
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here

        HashSet<String> pairs = new HashSet<>();
        PriorityQueue<PairSum>  pq = new PriorityQueue<>();

        Arrays.sort(A);
        Arrays.sort(B);
        List<Integer>  ans = new ArrayList<>();

        int l = N-1, m = N-1;

        pq.add(new PairSum(A[l]+B[m], l, m));
        pairs.add(""+l+":"+m);
        for(int i = 0; i<K; i++)
        {

            PairSum mx = pq.poll();

            l = mx.l -1;
            m = mx.r;

            if(l >= 0 && m >=0 && !pairs.contains(""+l+":"+m))
            {
                pq.add(new PairSum(A[l]+B[m], l, m));
                pairs.add(""+l+":"+m);
            }

            l = mx.l;
            m = mx.r-1;

            ans.add(mx.sum);

            if(l >= 0 && m >=0 && !pairs.contains(""+l+":"+m))
            {
                pq.add(new PairSum(A[l]+B[m], l, m));
                pairs.add(""+l+":"+m);
            }






        }



        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a[] = new int[n];

        int b[] = new int[n];
        for(int i =0; i<n; i++)
            a[i] = sc.nextInt();
        for(int i =0; i<n; i++)
            b[i] = sc.nextInt();

        List<Integer>  res = maxCombinations(n, k, a, b);
        System.out.println(res);
    }

}
//4
//        3
//        4
//        2
//        5
//        1
//        8
//        0
//        3
//        5