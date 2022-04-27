import  java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         int ed = sc.nextInt();
         int edges[][] = new int[ed][2];
         for(int i =0; i< ed;i++)
         {
             edges[i][0] = sc.nextInt();
             edges[i][1] = sc.nextInt();
         }
//        System.out.println("Enter Succ");
         double suc[] = new double[n];
         for(int i =0; i<n;i++)
             suc[i] = sc.nextDouble();
//        System.out.println("Enter Start and End");
         int start = sc.nextInt();
         int end = sc.nextInt();
         double ans = new Solution().maxProbability(n, edges, suc, start, end);
        System.out.println("Ans "+ans);

    }

    static class Solution {


        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            Map<Integer, List<int[]>> g = new HashMap<>();

            for (int i = 0; i < edges.length; ++i) {
                int a = edges[i][0], b = edges[i][1];
                g.computeIfAbsent(a, l-> new ArrayList<>()).add(new int[]{b, i});
                g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
            }
            double[] p = new double[n];
            p[start] = 1d;
            Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                    int neighbor = a[0], index = a[1];
                    if (p[cur] * succProb[index] > p[neighbor]) {
                        p[neighbor] = p[cur] * succProb[index];
                        q.offer(neighbor);
                    }
                }
            }
            return p[end];
        }


        static class pair implements Comparable<pair>
        {
            int ind, par;
            double val;

            pair(int a, double b, int p)
            {
                ind = a;
                val = b;
                par = p;

            }
            public int compareTo(pair o)
            {
                if(this.val < o.val)
                    return -1;
                return 1;

                // return this.val -o.val;
            }
        }

    }
}


//3
//        3
////        0
////        1
////        0
////        2
////        1
////        2
////        0.5
////        0.5
////        0.2
////        0

//        2