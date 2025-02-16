package Graph;

import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriends
{

    static ArrayList<ArrayList<Integer>> buildGraph(int [][]logs, int n)
    {
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        for(int i = 0 ;i < n;i++)
            ar.add(new ArrayList<>());

        for(int i =0 ;i<logs.length;i++)
        {
            ar.get(logs[i][1]).add(logs[i][2]);
            ar.get(logs[i][2]).add(logs[i][1]);
        }

        return  ar;

    }

    static boolean checkpossiblity( ArrayList<ArrayList<Integer>> ar)
    {
        int n = ar.size();

        boolean vis[] = new boolean[n];
        int cnt = 0;
        for(int i =0 ;i<n;i++)
        {
            cnt++;
            if(cnt > 1)
                return  false;
            if(vis[i] == false)
            {
                traverse(i, ar, vis);
            }
        }

        return  cnt == 1 ;


    }

    static  void traverse(int src, ArrayList<ArrayList<Integer>> adj, boolean vis[])
    {
        if(vis[src])
            return;

        vis[src]= true;

        for(int i : adj.get(src))
            traverse(i, adj, vis);

    }
    public static int minTime(int[][] logs, int n) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> ar = buildGraph(logs, n);

        if(checkpossiblity(ar))
            return -1;

        Arrays.sort(logs, (a,b)->Integer.compare(a[0], b[0]));

        HashSet<Integer> hset = new HashSet<>();
        int noofEdges = 0;
        for(int i[] : logs) {
            hset.add(i[1]);
            hset.add(i[2]);
             noofEdges++;
            if (hset.size() == n && noofEdges >=n-1)
                return i[0];

        }
    return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        int logs[][]=  new int[edges][3];

        for(int i=0; i<edges; i++)
        {
            logs[i][0] = sc.nextInt();
            logs[i][1] = sc.nextInt();
            logs[i][2] = sc.nextInt();
        }

        int ans =  minTime(logs, nodes);
        System.out.println("Answer : "+ans);
    }
}


//4 5
//        51 0 1
//        55 0 2
//        1 0 3
//        29 1 2
//        53 1 3




//4 5
//        60 0 1
//        80 0 2
//        100 0 3
//        22 1 2
//        77 1 3