import java.util.ArrayList;
import java.util.Scanner;

public class BASICGRAPH
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter NO of Vertex");
        int noV = sc.nextInt();
        System.out.println("Enter No of Edges");
        int noE = sc.nextInt();
        ArrayList <ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<=noV;i++)
            adj.add(new ArrayList<>());
        for(int i =0;i<noE;i++) {
            addEdge(sc.nextInt(), sc.nextInt(),adj);
        }
        printGraph(adj);
    }
    static void addEdge(int a, int b, ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(a).add(b);
        adj.get(b).add(a);
    }
    static  void printGraph(ArrayList<ArrayList<Integer>> adj)
    {
        for(int i =0 ;i<adj.size();i++)
        {
            System.out.print(i+" : ");
            for(int j =0;j<adj.get(i).size();j++)
                System.out.print(adj.get(i).get(j)+" ");
            System.out.println();

        }
    }
}
