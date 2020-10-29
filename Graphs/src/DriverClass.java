/*Given the adjacency list of a bidirectional graph.
 Your task is to print the adjacency list for each vertex.*/

//given undirected graph
import java.util.ArrayList;
import java.util.Scanner;

public class DriverClass
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


            new Adjacency().printGraph(list,noV);

        }
    }



}





//User function Template for Java

/*
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v' vertices
                                      and edges between them
v: represent number of vertices in a graph
*/
class Adjacency
{
    static void printGraph(ArrayList<ArrayList<Integer>> adj, int V)
    {
        // add your code here
        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> temp = adj.get(i);
            System.out.print(i);
            for(int j=0;j<temp.size();j++){
                System.out.print("-> "+temp.get(j));
            }
            System.out.println();
        }


    }
}