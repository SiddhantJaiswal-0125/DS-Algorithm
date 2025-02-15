package Graph;

import java.util.*;
public class Rottenoranges {
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] = new int[m][n];

        for(int i=0 ;i<m; i++)
            for(int j =0 ;j <n; j++)
                mat[i][j] = sc.nextInt();
        int ans = s.orangesRotting(mat);

        System.out.println("ANS IS "+ans);
    }
}
class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
        // Code here
        Queue<Pair> bfsQ = new ArrayDeque<>();
        int m = mat.length;
        int n = mat[0].length;
        int dis[][] = new int[m][n];
        for(int i =0; i< m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(mat[i][j] == 2)
                    bfsQ.add(new Pair(i, j,0));
                if(mat[i][j] == 1)
                    dis[i][j] = Integer.MAX_VALUE;
            }
        }


        HashSet<String> set = new HashSet<>();

        while(bfsQ.size() > 0)
        {
            Pair peek= bfsQ.remove();
            if(set.contains("-"+peek.sr+":"+peek.sc+"-")==false)
                traverse(mat, dis, bfsQ, peek, m, n, set);
        }


//        printArr(dis);
        int ans = 0;
        for(int i =0; i<m;i++)
        {
            for(int j =0; j< n;j++)
            {
                if(dis[i][j] ==  Integer.MAX_VALUE)
                    return  -1;

                ans = Math.max(ans, dis[i][j]);
            }
        }

        return ans;


    }
    void printArr(int ar[][])
    {
        int m=ar.length;
        int n = ar[0].length;
        for(int i =0; i<m ;i++)
        {
            for(int j = 0; j < n; j++)
                System.out.print(ar[i][j]+"  ");
            System.out.println();
        }
    }

    void traverse(int mat[][], int dis[][], Queue<Pair> bfsQ, Pair p,  int m, int n, HashSet<String> set)
    {


        int sr = p.sr;

        int sc = p.sc;

        if(sr >= m || sc >= n || sr < 0 || sc < 0  )
            return;

        if(mat[sr][sc] == 2 && p.dis > 0)
            return;

        set.add(new String("-"+sr+":"+sc+"-"));



        if(mat[sr][sc] == 0 )
        {
            dis[sr][sc] = -1;
            return ;
        }

        int dirX[]=  new int[]{-1,1 , 0, 0};
        int dirY[]=  new int[]{0, 0, -1, 1};

        dis[sr][sc] = p.dis;

        for(int i =0 ;i<4;i++)
        {
            bfsQ.add(new Pair(sr+dirX[i], sc+dirY[i], p.dis+1));
        }








    }
}


class Pair
{
    int sr, sc, dis;
    Pair(int a, int b, int d)
    {
        sr =a;
        sc =b;
        dis = d;
    }
}