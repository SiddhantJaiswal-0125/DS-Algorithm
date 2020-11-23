import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SSSPusingBFS
{
    static ArrayList<ArrayList<Integer>> adj ;
    static boolean isVisited[];
    static  int dis[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noV = sc.nextInt();
        int noE = sc.nextInt();
        adj = new ArrayList<ArrayList<Integer>>();
        dis= new int[noV+1];
        isVisited = new boolean[noV+1];
        for(int i = 0; i<=noV;i++)
            adj.add(i,new ArrayList<>());
        for(int i = 0;i<noE;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        bfs(1);
        System.out.println("length of all the nodes form 1 is :");
        for(int  i = 1;i<=noV;i++)
            System.out.println("Distance of Vertex "+i+" is : "+dis[i]  );
    }

//    this bfs fuction is a iyteravtive fuunction

    static  void bfs(int src)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        isVisited[src] = true;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            ArrayList <Integer> temp = adj.get(cur);
            for(int child : temp)
            {
                if(!isVisited[child])
                {
                    isVisited[child] = true;
                    q.add(child);
                    dis[child] = dis[cur]+1;

                }

            }
        }

    }

}
