package Graph;

import java.util.*;

public class DetectCycleInUndirectedGraphBFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>>  adj = new ArrayList<>();

        for(int i = 0; i<V; i++)
            adj.add(new ArrayList<>());

        for(int i=0; i<E; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        System.out.println(adj);
        boolean ans = new DetectCycleInUndirectedGraphBFS().isCycle(adj);
        System.out.println(ans
        );
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicConnected(adj, i, V, visited)) {
                return true;
            }
        }
        return false;


    }

    public boolean isCyclicConnected(ArrayList<ArrayList<Integer>> adj, int s, int V, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);


        System.out.println("Starting BFS for source "+s);
        while (!q.isEmpty()) {
            int v = q.poll();

            System.out.println("Polled "+v);

            if (visited[v]) {

                System.out.println("Caught a Visited Node "+v);
                return true; // Cycle detected
            }

            visited[v] = true; // Mark as visited
            System.out.println("Marked visted :  "+v);

            for (int it : adj.get(v)) {

                System.out.println("Child Node "+it + " :: parent node "+v);
                if (!visited[it]) {

                    System.out.println("Child Node "+it + " :: parent node "+v+" added in Queue");
                    q.add(it);
                }
            }
        }
        return false;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here

        int initialColor = image[sr][sc];
        boolean vis[][] = new boolean[image.length] [ image[0].length];

        dfs(image, sr, sc, newColor, initialColor, vis);
        return image;
    }

    void dfs(int [][]image, int sr, int sc, int newColor, int iniColor, boolean vis[][] )
    {
        if(!isValid(sr, sc, image.length, image[0].length) || vis[sr][sc] || image[sr][sc] != iniColor)
            return;

        vis[sr][sc] = true;

        image[sr][sc] = newColor;

        dfs(image, sr+1  , sc, newColor, iniColor,vis);
        dfs(image, sr-1  , sc, newColor, iniColor, vis);

        dfs(image, sr  , sc-1, newColor, iniColor,vis);
        dfs(image, sr  , sc+1, newColor, iniColor, vis);
    }


    boolean isValid(int sr, int sc, int m, int n)
    {
        if(sr >= m || sr < 0)
            return false;

        if(sc >=n || sc < 0)
            return false;

        return true;
    }



}