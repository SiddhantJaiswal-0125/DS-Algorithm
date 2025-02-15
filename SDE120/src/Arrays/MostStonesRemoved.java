package Arrays;

import java.util.*;

public class MostStonesRemoved {

    public int removeStones(int[][] stones) {


        ArrayList<ArrayList<Integer>>  graph    = new ArrayList<>();
        int size = stones.length;

        for(int i=0;i<size; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i< size; i++)
            for (int j = i+1; j< size; j++)
                if(stones[i][0] == stones[j][0] || stones[i][1] ==  stones[j][1])
                {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }

        int total = 0;

        boolean vis[] = new boolean[size];
        for(int i =0 ;i <size; i++)
        {
            if(vis[i]== false)
            {
                int cnt = traverse(graph, i, vis);
                total +=cnt;
                total--;
            }
        }

        return  total;
    }

    int traverse(ArrayList<ArrayList<Integer>> graph, int src, boolean vis[])
    {
        if(vis[src])
            return 0;

        int cnt = 1;
        vis[src]= true;
        for(int i : graph.get(src))
        {
            cnt+=traverse(graph, i, vis);
        }

        return  cnt;
    }

    public int removeStones1(int[][] stones) {

        HashMap<Integer, HashSet<String>> mapX = new HashMap<>();
        HashMap<Integer, HashSet<String>>  mapY = new HashMap<>();

        for(int []ar: stones)
        {
            int x = ar[0], y = ar[1];
            HashSet<String> tempX, tempY;
            if(mapX.containsKey(x))
            {
                tempX = mapX.get(x);
            }
            else
            {
                tempX = new HashSet<>();
            }

            tempX.add(""+x+""+y);

            if(mapY.containsKey(y))
            {
                tempY = mapY.get(y);
            }
            else
            {
                tempY = new HashSet<>();
            }

            tempY.add(""+x+""+y);

            mapX.put(x, tempX);
            mapY.put(y,tempY);
         }

//        System.out.printf("");


        int cnt = 0;

        for(int ar[] : stones)
        {
            int x = ar[0], y = ar[1];

            HashSet<String> tempX, tempY;
            if ((mapX.containsKey(x) && mapX.get(x).size() > 1 ) || (mapY.containsKey(y) && mapY.get(y).size() > 1))
            {

//                System.out.println("HERE");
                cnt++;
                tempX = mapX.get(x);
                tempX.remove(""+x+""+y);
                tempY = mapY.get(y);
                tempY.remove(""+x+""+y);

                mapX.put(x, tempX);
                mapY.put(y, tempY);
            }

        }


        return  cnt;




    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[][] = new int[n][2];
        for(int i =0; i<n; i++)
        {
            ar[i][0] = sc.nextInt();
            ar[i][1] = sc.nextInt();
        }

        int ans = new MostStonesRemoved().removeStones(ar);
        System.out.println(ans);
    }
}


//6
//        0
//        1
//        1
//        2
//        1
//        3
//        3
//        3
//        2
//        3
//        0
//        2
