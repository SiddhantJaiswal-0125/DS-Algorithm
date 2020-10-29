//BFS Traversal is for given directed graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFStraversal
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
           res = new Traversal().bfs(list,noV);
            for(int i = 0;i<res.size();i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();


        }
    }



}
class Traversal {
    static ArrayList <Integer> ans ;
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        // add your code here
        ans = new ArrayList<>();
        boolean isvisited[] = new boolean[N+1];
        for(int i = 0;i<N;i++)
        {
            if(!isvisited[i])
            {
                //   BFS(g,i,isVisited);
                Queue <Integer> q = new LinkedList<>();
                isvisited[i] = true;
                q.add(i);
                while (!q.isEmpty())
                {
                    int u = q.poll();
                    ans.add(u);
                    for(int v:g.get(u))
                    {
                        if(!isvisited[v])
                        {
                            isvisited[v] = true;
                            q.add(v);
                        }
                    }
                }

            }
        }
        return ans;
    }


}
