import java.util.Scanner;

public class anu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ar[] []=  new int[m][n];
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++)
                ar[i][j] = sc.nextInt();


        int ans = new anu1().numEnclaves(ar);
        System.out.println(ans);
    }
    public int numEnclaves(int[][] grid) {
        fillEdges(grid);


        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++)
                if(grid[i][j] == 1)
                    count++;
        return count;

    }
    void fillEdges(int [][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        for(int i =0; i<m;i++)
            if(grid[i][0] == 1)
                dfs(grid,i,0, m,n);

        for(int i =0; i<m;i++)
            if(grid[i][n-1] == 1)
                dfs(grid,i,n-1, m,n);

        for(int i =0; i<n;i++)
            if(grid[0][i] == 1)
                dfs(grid,0,i, m,n);

        for(int i =0; i<n;i++)
            if(grid[m-1][i] == 1)
                dfs(grid,m-1,i, m,n);
    }


    void dfs(int grid[][], int i , int j, int m, int n)
    {
        if(i>=m || j>=n || i<0 || j<0)
            return;
        if(grid[i][j] == 0)
            return;

        grid[i][j] =0;
        dfs(grid, i+1,j,m,n);
        dfs(grid, i-1,j,m,n);
        dfs(grid, i,j+1,m,n);
        dfs(grid, i,j-1,m,n);

    }

}
