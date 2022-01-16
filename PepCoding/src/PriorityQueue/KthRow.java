package PriorityQueue;
import java.util.*;
public class KthRow {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int r = mat.length;
        int c = mat[0].length;
        for(int i =0;i<r;i++)
        {
            int total = 0;
            for(int j =0;j<c;j++)
            {
                if(mat[i][j] == 1)
                    total++;
                else
                    break;
            }
            pq.add(new pair(i, total));


        }

        int ind = 0;
        int ans[] = new int[k];
        while(ind <k)
            ans[ind++] = pq.remove().ind;
        return  ans;


    }
    static class pair implements  Comparable<pair>
    {
        int ind, val;
        pair(int i, int v)
        {
            ind = i;
            val = v;
        }
        public int compareTo(pair ot)
        {
            if(this.val < ot.val)
                return -1;
            else if(this.val == ot.val)
            {
                if(this.ind < ot.ind)
                    return -1;

            }

            return 1;

        }

        @Override
        public String toString() {
            return "pair{ " +
                    "ind= " + ind +
                    ", val= " + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int ar[][] = new int[n][m];
        for(int i =0;i<n;i++)
            for(int j =0;j<m;j++)
                ar[i][j] = sc.nextInt();

        int k = sc.nextInt();
        int ans [] = new KthRow().kWeakestRows(ar, k);
        for(int i : ans)
            System.out.print(i+"\t");
        System.out.println();


    }
}
