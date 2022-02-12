import java.io.*;
import java.util.*;

public class floodfill {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "",n,m);
    }

    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String ast, int n, int m) {

        if(sr>=n||sr<0)
            return;
        if(sc>=m || sc<0)
            return;
        if(maze[sr][sc]==1)
            return;
        if(maze[sr][sc]==-1)
            return;

        int a = maze[sr][sc];
        maze[sr][sc] = -1;

        if(sr==n-1&& sc==m-1)
        {   System.out.println(ast);

            return;
        }

        floodfill(maze, sr+1, sc, ast+"d",n,m);
        floodfill(maze, sr-1, sc, ast+"t",n,m);
        floodfill(maze, sr, sc+1, ast+"r",n,m);
        floodfill(maze, sr, sc-1, ast+"l",n,m);

        maze[sr][sc] = a;




    }
}
