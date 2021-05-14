import java.util.ArrayList;
import java.util.Scanner;

public class RatInaMaze
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Maze");
        int n = sc.nextInt();
        int maze[][] = new int[n][n];
        for(int i =0;i<n;i++)
        {
            for(int  j =0;j<n;j++)
                maze[i][j] = sc.nextInt();

        }

        ArrayList<String>  ans = findPath(maze,n);
        for(String s:ans)
            System.out.println(s);

    }
    public static ArrayList<String> findPath(int[][] m, int n)
    {
        // Your code here
        ArrayList<String > res = new ArrayList<>();

        int sol[][] = new int[n][n];
        helper(m, sol,n,0,0,"", res);

        return res;
    }

    static  void helper(int maze[][] , int sol[][], int n , int x, int y, String res, ArrayList<String> ans)
    {
        if(x==n-1 && y == n-1)
        {
            sol[x][y] = 1;
            ans.add(res);

            return;
        }
        if(x>=n || y>=n || x<0 || y<0|| maze[x][y] == 0 || sol[x][y] == 1)
            return;

        sol[x][y] = 1;
        helper(maze, sol, n, x-1,y,res+"U",ans );
        helper(maze, sol, n, x+1,y,res+"D",ans );

        helper(maze, sol, n, x,y-1,res+"L",ans );

        helper(maze, sol, n, x,y+1,res+"R",ans );

        sol[x][y] = 0;
        if(res.length()>0)
            res = res.substring(0, res.length() - 1);


    }
}
