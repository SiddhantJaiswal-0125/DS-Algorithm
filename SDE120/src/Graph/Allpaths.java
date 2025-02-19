package Graph;


import java.util.*;
public class Allpaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);

        traverse(ans, temp, graph, 0);

        return ans;
    }

    void traverse(List<List<Integer>> ans,  List<Integer> temp  , int[][] graph, int src)
    {

        System.out.println("FOR SRC "+src);
        if(src == graph.length -1)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i =0 ; i<graph[src].length ; i++)
        {
            temp.add(graph[src][i]);
            traverse(ans,temp, graph, graph[src][i]);
            temp.remove(temp.size()-1);
        }
        return;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int g[][] = new int[n][];

        for(int i =0 ; i <n;i++)
        {
            int k = sc.nextInt();
            int temp[] = new int[k];
            for(int j =0 ; j< k;j++)
            {
                temp[j] = sc.nextInt();
            }

            g[i] = temp;
        }

        List<List<Integer>> ans = new Allpaths().allPathsSourceTarget(g);
        System.out.println("ANS "+ans);

    }


}

