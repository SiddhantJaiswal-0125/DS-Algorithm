import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int edges[][] = new int[n-1][2];
        for(int i =0; i< n-1;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        List<Integer> li = new Solution().findMinHeightTrees(n, edges);
        System.out.println(li);
    }
    static class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> li = new ArrayList<>();
            if (n == 0)
                return li;

            li.add(0);
            if (n == 1)
                return li;

            li = new ArrayList<>();

            int inD[] = new int[n];
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());

            for (int i = 0; i < n - 1; i++) {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
                inD[edges[i][0]]++;
                inD[edges[i][1]]++;
            }
            
            Queue<Integer> q = new LinkedList<>();


            for (int i = 0; i<n; i++)
                if (inD[i] == 1)
                    q.add(i);

            while (q.isEmpty() == false) {
                li = new ArrayList<>();


                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int cur = q.remove();


                    li.add(cur);

                    for (int j : adj.get(cur)) {
                        inD[j]--;
                        if (inD[j] == 1)
                            q.add(j);

                    }
                }
            }
            return li;
        }

        public List<Integer> findMinHeightTrees2(int n, int[][] edges) {

            if (n == 1) return Collections.singletonList(0);

            List<Integer> res = new ArrayList<>();

            List<List<Integer>> graph = new ArrayList<>();
            for(int i=0;i<n;i++)
                graph.add(new ArrayList<>());

            int[]degree = new int[n];

            for(int[]e:edges){
                int from = e[1];
                int to = e[0];
                graph.get(from).add(to);
                graph.get(to).add(from);

                degree[from]++;
                degree[to]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            for(int i=0;i<degree.length;i++)
                if(degree[i]==1)
                    queue.offer(i);

            while(!queue.isEmpty()){

                res.clear();
                int size = queue.size();

                while(size-->0){

                    int node = queue.poll();
                    res.add(node);

                    for(int nei:graph.get(node))
                        if(--degree[nei]==1)
                            queue.offer(nei);
                }
            }
            return res;
        }

    }
}
