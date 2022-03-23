import java.util.Scanner;

public class subIsland {
    void display(int grid[][], int m, int n)
    {
        for(int i =0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
                System.out.print(grid[i][j] +"\t");
            System.out.println();
        }
    }
//    public int countSubIslands(int[][] grid1, int[][] grid2) {
//
//        int m = grid1.length;
//        int n = grid1[0].length;
//        for(int i = 0;i<m;i++)
//            for(int j =0;j<n;j++)
//                if(grid1[i][j] == 0 && grid2[i][j] == 1 )
//                    grid2[i][j] = 0;
//
//        System.out.println("AFTER ERASING");
//        System.out.println("GRID 2");
//        display(grid2,m,n);
//
//        return countIsland(grid2, m,n);
//
//    }
//    int   countIsland(int grid[][], int m, int n)
//    {
//        int count =  0;
//        for(int i =0;i<m;i++)
//            for(int j= 0;j<n;j++)
//                if(grid[i][j] == 1)
//                {
//                    count++;
//                    dfs(i, j, m,n, grid);
//                }
//        return count;
//
//    }
//    void dfs(int i, int j, int m , int n, int grid[][])
//    {
//        if(i>=m || j>=n || i<0 || j<0 || grid[i][j] == 0)
//            return;
//
//        grid[i][j] = 0;
//
//        dfs(i+1,j, m, n, grid);
//        dfs(i-1,j, m, n, grid);
//        dfs(i,j+1, m, n, grid);
//        dfs(i,j-1, m, n, grid);
//
//        return;
//    }
public int countSubIslands(int[][] B, int[][] A) {
    int m = A.length, n = A[0].length, res = 0;
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            if (A[i][j] == 1)
                res += dfs(B, A, i, j);
    return res;
}


    private int dfs(int[][] B, int[][] A, int i, int j) {
        int m = A.length, n = A[0].length, res = 1;
        if (i < 0 || i == m || j < 0 || j == n || A[i][j] == 0) return 1;
        A[i][j] = 0;
        res &= dfs(B, A, i - 1, j);
        res &= dfs(B, A, i + 1, j);
        res &= dfs(B, A, i, j - 1);
        res &= dfs(B, A, i, j + 1);
        return res & B[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ar[][]= new int[m][n];
        int ar2[][]= new int[m][n];

        for(int i =0;i<m;i++)
            for(int j = 0;j<n;j++)
                ar[i][j] = sc.nextInt();
        new subIsland().display(ar,m,n);
        for(int i =0;i<m;i++)
            for(int j = 0;j<n;j++)
                ar2[i][j] = sc.nextInt();
        System.out.println("HERe");
        new subIsland().display(ar2, m,n);
        int ans = new subIsland().countSubIslands(ar, ar2);
        System.out.println(ans);
    }
}
//5
//        5
//        1
//        1
//        1
//        00
//        0
//        0
//        1
//        1
//        1
//        1
//        0
//        0
//        0
//        0
//        0
//        1
//        0
//        0
//        0
//        0
//        1
//        1
//        0
//        1
//        1
//        1
//        1
//        1
//        0
//        0
//        0
//        0
//        1
//        1
//        1
//        0
//        1
//        0
//        0
//
//        0
//        1
//        0
//        1
//        1
//        0
//        0
//        1
//        0
//        1
//        0