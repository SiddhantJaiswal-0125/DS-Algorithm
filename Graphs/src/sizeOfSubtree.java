import java.util.ArrayList;
import java.util.Scanner;

/*Here we  have to create a sizeOfSubtree array which will store the size of subtree from each node*/
public class sizeOfSubtree
{
    static ArrayList <ArrayList<Integer>> adj;
    static boolean isVisited[];
    static int subSize[];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        adj = new ArrayList<>();
        int noV = sc.nextInt();

        int noE = sc.nextInt();
        for(int i = 0;i<noV+1;i++)
            adj.add(i,new ArrayList<>());
        isVisited = new boolean[noV+1];
        subSize = new int[noV+1];

        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b =sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfs(1);
        for(int i = 1;i<noV+1;i++)
            System.out.println("Size of Subtree "+i+" is "+subSize[i]);

    }
    static  int dfs(int node)
    {
        isVisited[node] = true;
        int curSize = 1;
        ArrayList <Integer> temp = adj.get(node);
        for(int child : temp)
        {
            if(!isVisited[child])
            {
                curSize +=dfs(child);
            }

        }
        subSize[node] = curSize;
        return  curSize;
    }
}
