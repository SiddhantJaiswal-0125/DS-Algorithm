package Arrays;

import java.io.*;
import java.util.*;

public class Graph1 {
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
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = sc.nextInt();
//        ArrayList<Edge>[] graph = new ArrayList[vtces];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
//        for (int i = 0; i < vtces; i++) {
//            graph[i] = new ArrayList<>();
//        }


        HashMap<Integer, Integer> ht = new HashMap<>();
        int id[] = new int[vtces];
        for (int i = 0; i < vtces; i++) {
            graph.add(new ArrayList<>());
//            graph[i] = new ArrayList</>();
            id[i] = sc.nextInt();
            ht.put(id[i], i);

        }

//        System.out.println(ht);
        int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
//            String[] parts = br.readLine().split(" ");
            int v1 =sc.nextInt();
            int v2 = sc.nextInt();

//            int wt = sc.nextInt();

            graph.get(ht.get(v1)).add(new Edge(ht.get(v1), ht.get(v2), 0));
//            graph[ht.get(v1)].add(new Edge(ht.get(v1), ht.get(v2), 0));
//            graph[v1].add(new Edge(v1, v2, 0));
//            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();

        boolean[] visited = new boolean[vtces];
        HashSet <Integer> hs = new HashSet<>();
        boolean flag = hasPath(graph, ht.get(src), ht.get(dest), hs);
        System.out.println(flag?1:0);
    }

    public static boolean hasPath(ArrayList<ArrayList<Edge>> graph, int src, int dest, HashSet<Integer> hs) {
        if (src == dest) {
            return true;
        }
        hs.add(src);

//        visited[src] = true;
        for (Edge e : graph.get(src)) {
//            if (!visited[e.nbr])
            if(hs.contains(e.nbr)==false)
            {
                boolean nbrHasPath = hasPath(graph, e.nbr, dest, hs);
                if (nbrHasPath) {
                    return true;
                }
            }
        }

        return false;
    }

}


                        


                        