import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInDirectedGraph
{
    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            ArrayList <ArrayList<Integer>> list = new ArrayList<>();
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
            if(new DetectCycle1().isCyclic(list,noV))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }



}

class DetectCycle1
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int v)
    {
        // add your code here
        boolean visited[] = new boolean[v];
        boolean recSt[] = new boolean[v];
        for(int i = 0;i < v; i++)
        {
            if(!visited[i])
                if(DFSRec(adj,i,visited,recSt))
                    return true;

        }
        return false;
    }
    static  boolean DFSRec(ArrayList<ArrayList<Integer>> adj,int s,
                           boolean []visit,boolean []recSt )
    {
        visit[s] = true;
        recSt[s] = true;
        ArrayList <Integer> temp = new ArrayList<>();
        temp = adj.get(s);
        for(int i: temp)
        {
            if(!visit[i] && DFSRec(adj,i,visit,recSt))
                return true;
            else if (recSt[i])
                return true;

        }
        recSt[s]= false;
        return  false;
    }
}