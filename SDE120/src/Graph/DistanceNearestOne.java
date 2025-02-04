package Graph;

import java.util.Scanner;

public class DistanceNearestOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][]grid = new int[m][n];
        for(int i = 0 ; i < m ; i++)
            for(int j =0; j < n; j++)
                grid[i][j] = sc.nextInt();


        int ans[][] = new DistanceNearestOne().nearest(grid);
        for(int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(ans[i][j]+"  ");
            System.out.println();
        }

    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here

        int m = grid.length;
        int n = grid[0].length;

        int [][]dis = new int[m][n];

        for(int i = 0 ; i < m ; i++)
            for(int j =0; j < n; j++)
                dis[i][j] = m + n + m + n;

        for(int i = 0 ; i < m ; i++)
            for(int j =0; j < n; j++) {
                boolean vis[][] = new boolean[m][n];
                if (grid[i][j] == 1)
                    travelkro(grid, dis, i, j, m, n, 0,vis);
            }


        return dis;

    }

    void travelkro(int [][]grid, int [][]dis, int sr, int sc, int m, int n, int d, boolean vis[][])
    {

        if(sr >= m || sr <0 || sc >=n || sc < 0 )
            return;
        if(vis[sr][sc])return;

        vis[sr][sc] = true;

        dis[sr][sc] = Math.min(dis[sr][sc], d);

        travelkro(grid, dis, sr+1, sc, m, n, d+1,vis);

        travelkro(grid, dis, sr-1, sc, m, n, d+1, vis);

        travelkro(grid, dis, sr, sc+1, m, n, d+1,vis);

        travelkro(grid, dis, sr, sc-1, m, n, d+1,vis);
        return;
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