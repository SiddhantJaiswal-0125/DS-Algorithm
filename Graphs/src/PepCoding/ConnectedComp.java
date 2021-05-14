package PepCoding;

import java.io.*;
import  java.util.*;
public class ConnectedComp {

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

            int vctes = Integer.parseInt(br.readLine());
            ArrayList<Edge>[] graph = new ArrayList[vctes];
            for (int i = 0; i < vctes; i++) {
                graph[i] = new ArrayList<>();
            }

            int edges = Integer.parseInt(br.readLine());
            for (int i = 0; i < edges; i++) {
                String[] parts = br.readLine().split(" ");
                int v1 = Integer.parseInt(parts[0]);
                int v2 = Integer.parseInt(parts[1]);
                int wt = Integer.parseInt(parts[2]);
                graph[v1].add(new Edge(v1, v2, wt));
                graph[v2].add(new Edge(v2, v1, wt));
            }

            ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

            // write your code here

            boolean vis[] = new boolean[vctes];

            for(int i = 0;i<vctes;i++)
            {
                if(!vis[i]) {
                    ArrayList<Integer> res = new ArrayList<>();
                    solve(graph, i, res, vis);
                    comps.add(res);
                }
            }

            System.out.println(comps);
        }

        public static void solve(ArrayList <Edge> graph[], int src, ArrayList <Integer>  res, boolean vis[])
        {
            vis[src] = true;
            res.add(src);
            for(Edge e : graph[src])
            {
                if(!vis[e.nbr])
                {
                    solve(graph, e.nbr, res, vis);

                }
            }
        }

















    }

