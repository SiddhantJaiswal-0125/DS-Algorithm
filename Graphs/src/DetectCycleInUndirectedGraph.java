import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInUndirectedGraph
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
                list.get(v).add(u);
            }
            if(new DetectCycle().isCyclic(list,noV))
                System.out.println("Yes Cycle Present");
            else
                System.out.println("No Cycle Detected");

        }
    }



}
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int v)
    {
        // add your code here
        boolean visited[] = new boolean[v];

//        this "for loop" is just for if the graph has more than one connected components
        for(int i = 0; i<v;i++)
        {
            if(!visited[i])
            {
                if(DFSRec(adj,i,visited,-1) )
                    return true;
            }
        }
        return false;
    }




    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int s,
                          boolean visited[], int parent)
    {
        visited [s] = true;


        ArrayList <Integer> temp = new ArrayList<>();
        temp = adj.get(s);
        for(int i :temp)
        {
            if(!visited[i])
            {
                if(DFSRec(adj,i,visited,s))
                    return true;
            }
            else if(i!=parent)
                return true;
        }
        return  false;
    }
}