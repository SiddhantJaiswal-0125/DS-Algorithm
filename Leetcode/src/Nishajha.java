import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Nishajha
{
    int topologytype(int input1, int input2, int input3[], int input4[])
    {
        ArrayList<ArrayList<Integer>>  adj = new ArrayList<>();
        for(int i = 0;i<=input1;i++)
            adj.add(new ArrayList<>());

        for(int i = 0;i<input2;i++)
        {
            adj.get(input3[i]).add(input4[i]);
            adj.get(input4[i]).add(input3[i]);
        }

        if(isCyclic(input1+1, adj))
            return 3;


        for(ArrayList<Integer> ni :adj)
            if(ni.size() > 2)
                return 2;
        return 1;

    }
    Boolean isCyclicUtil(int v, Boolean visited[],
                         int parent, ArrayList<ArrayList<Integer>> adj)
    {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v, adj))
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }

    Boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {

        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int u = 0; u < V; u++)
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1, adj))
                    return true;
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ar[] = new int[m];
        int ar2[] = new int[m];
        for(int i= 0;i<m;i++)
            ar[i] = sc.nextInt();
        for(int j = 0 ;j<m;j++)
            ar2[j] = sc.nextInt();


        System.out.println(new Nishajha().topologytype(n,m, ar, ar2));
    }


}
