import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class nisha
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for(int i = 0;i<m;i++)
            matrix.add(new ArrayList<>());
        int n = sc.nextInt();

        for(int i  =0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                int k = sc.nextInt();
                matrix.get(i).add(k);
            }
        }
        System.out.println("DONE");
        System.out.println(biggestNeighbourSize(matrix));
    }


        public static  int biggestNeighbourSize(List<List<Integer>> matrix)
        {

            int mat[][] = new int[matrix.size()][matrix.get(0).size()];
            for(int i  =0;i<mat.length;i++)
                for(int j = 0; j<matrix.get(i).size();j++)
                    mat[i][j] = matrix.get(i).get(j);

            return  maxNeighbour(mat);

        }
    public static int maxNeighbour(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
        return max_area;
    }

    public static int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }
}
