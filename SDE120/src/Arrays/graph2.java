package Arrays;
import java.io.*;
import java.util.*;

public class graph2 {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int vtces = sc.nextInt();

//        ArrayList<Edge>[] graph = new ArrayList[vtces];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();


        HashMap<Integer, Integer> ht = new HashMap<>();
        int id[] = new int[vtces];
        for (int i = 0; i < vtces; i++) {
            graph.add(new ArrayList<>());
//            graph[i] = new Arr/ayList<>();
            id[i] = sc.nextInt();
            ht.put(id[i], i);

        }

        int edges = sc.nextInt();


        for (int i = 0; i < edges; i++) {

            int v1 = sc.nextInt();

            int v2 = sc.nextInt();
            int wt = sc.nextInt();
//            graph[v1].add(new Edge(v1, v2, wt));
//            System.out.println("ht get :"+ht.get(v1));
            graph.get(ht.get(v1)).add(new Edge(ht.get(v1), ht.get(v2), wt));
//            graph[ht.get(v1)].add(new Edge(ht.get(v1), ht.get(v2), wt));

        }

//        System.out.println(ht);



        int src = sc.nextInt();
        int dest = sc.nextInt();



        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(ht.get(src), src + "", 0));
        boolean[] visited = new boolean[vtces];
        HashSet<Integer> hs = new HashSet<>();
        int answer= 0;

        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (hs.contains(rem.v)) {
                continue;
            }
            visited[rem.v] = true;
            hs.add(rem.v);
//            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);


            if(rem.v==ht.get(dest)) {
                answer = rem.wsf;
            break;
            }

//            for (Edge e : graph[rem.v]) {
            for (Edge e : graph.get(rem.v))
            {
                if (visited[e.nbr] == false) {
                    queue.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt));
                }
            }
        }
        System.out.println(answer);
    }

    static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

}