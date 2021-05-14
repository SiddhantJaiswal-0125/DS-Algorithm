package PepCoding;
import  java.util.*;
import java.io.*;
public class PrintAllPath {

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
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Scanner sc = new Scanner(System.in);

            int vtces = sc.nextInt();
            ArrayList<Edge>[] graph = new ArrayList[vtces];
            for (int i = 0; i < vtces; i++) {
                graph[i] = new ArrayList<>();
            }

            int edges = sc.nextInt();
            for (int i = 0; i < edges; i++) {
//                String[] parts = br.readLine().split(" ");
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                int wt = sc.nextInt();
                graph[v1].add(new Edge(v1, v2, wt));
                graph[v2].add(new Edge(v2, v1, wt));
            }

            int src = sc.nextInt();
            int dest = sc.nextInt();
            // write all your codes here
            boolean vis[] = new boolean[vtces];

            print(graph, src, dest,vis, ""+src);
        }

        static void print(ArrayList<Edge> graph[], int src, int dest,
                          boolean vis[], String res) {
            if (src == dest) {
                System.out.println(res);
                return;
            }

            vis[src] = true;
            for (Edge edge : graph[src]) {
                if (!vis[edge.nbr]) {
                    print(graph, edge.nbr, dest, vis, res + "" + edge.nbr);

                }

            }
            vis[src] = false;


        }
}


















