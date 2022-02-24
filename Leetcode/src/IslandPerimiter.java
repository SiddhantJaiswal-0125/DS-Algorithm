import java.util.Scanner;

public class IslandPerimiter {
   static class Solution {
       public int islandPerimeter(int[][] grid) {
           int islands = 0, neighbours = 0;

           for (int i = 0; i < grid.length; i++) {
               for (int j = 0; j < grid[i].length; j++) {
                   if (grid[i][j] == 1) {
                       islands++; // count islands
                       if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                       if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                   }
               }
           }

           return islands * 4 - neighbours * 2;
       }
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] = new int[m][n];
        for(int i =0;i<m;i++)
            for(int j = 0;j<n;j++)
                mat[i][j] = sc.nextInt();
        int ans = new Solution().islandPerimeter(mat);
        System.out.println(ans);
    }
}
