import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS
{
    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            ArrayList <ArrayList <Integer> > list = new ArrayList<>();
            int noV = sc.nextInt();
            int edge = sc.nextInt();
            for(int i = 0;i<noV+1; i++)
                list.add(i,new ArrayList<Integer>());


            for(int i = 1; i<= edge;i++)
            {
                int u = sc.nextInt();
                int v =sc.nextInt();
                list.get(u).add(v);
//                list.get(v).add(u);
            }
            ArrayList <Integer> res = new ArrayList<>();
            res = new DFSTraversal().dfs(list,noV);
            for(int i = 0;i<res.size();i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();


        }
    }



}
class DFSTraversal
{
    static ArrayList <Integer> ans = new ArrayList<Integer>();

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int N)
    {
        // add your code here
        ans = new ArrayList<Integer>();
        boolean visit[] = new boolean[N+1];
        DFSREC(adj,0,visit);
        return ans;
    }
    static void DFSREC (ArrayList <ArrayList<Integer>> adj, int s,boolean [] visit)
    {

        visit[s] = true;
        ans.add(s);
        for(int u:adj.get(s))
            if(!visit[u])
                DFSREC(adj,u,visit);









    }
}
