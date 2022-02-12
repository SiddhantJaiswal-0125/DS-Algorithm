import java.util.*;

public class CourseSchedule
{
    public  static  boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int i =0;i<prerequisites.length;i++)
        {


            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }
        boolean vis[] = new boolean[numCourses+1];

        for(int i =0;i<numCourses;i++)
        {
            if(!vis[i])
            {
                boolean rec[] = new boolean[numCourses+1];
                if(isCyclicUtil(i, vis, rec, adj ))
                    return  true;
            }
        }

return  false;
    }
    private  static boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack, ArrayList<ArrayList<Integer>> adj)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack,adj))
                return true;

        recStack[i] = false;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[m][2];
        for(int i=0;i<m;i++)
        {
            for(int j =0;j<2;j++)
                mat[i][j] = sc.nextInt();

        }

        System.out.println(canFinish(n,mat));
    }
}
