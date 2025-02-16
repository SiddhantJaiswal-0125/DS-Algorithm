package Graph;

import java.util.*;

public class NearestCellwith1 {
    public static void main(String[] args) {
        sol s = new sol();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] = new int[m][n];

        for(int i=0 ;i<m; i++)
            for(int j =0 ;j <n; j++)
                mat[i][j] = sc.nextInt();

        System.out.println("Input ");
        s.printArr(mat);
        int ans[][] = s.nearest(mat);
        System.out.println("ANS IS ");
        s.printArr(ans);

    }
}
class sol{
    public int[][] nearest(int[][] mat)
    {
        // Code here
        Queue<Pair> bfsQ = new ArrayDeque<>();
        int m = mat.length;
        int n = mat[0].length;
        int dis[][] = new int[m][n];
        for(int i =0; i< m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(mat[i][j] == 1)
                    bfsQ.add(new Pair(i, j,0));
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

        return dis;


    }


    void traverse(int mat[][], int dis[][], Queue<Pair> bfsQ, Pair p,  int m, int n, HashSet<String> set)
    {


        int sr = p.sr;

        int sc = p.sc;

        if(sr >= m || sc >= n || sr < 0 || sc < 0  )
            return;

        if(mat[sr][sc] == 1 && p.dis > 0)
            return;

        set.add(new String("-"+sr+":"+sc+"-"));

        int dirX[]=  new int[]{-1,1 , 0, 0};
        int dirY[]=  new int[]{0, 0, -1, 1};

        dis[sr][sc] = p.dis;

        for(int i =0 ;i<4;i++)
        {
            bfsQ.add(new Pair(sr+dirX[i], sc+dirY[i], p.dis+1));
        }
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
}



//3
//        4
//        0
//        1
//        1
//        0
//        1
//        1
//        0
//        0
//        0
//        0
//        1
//        1