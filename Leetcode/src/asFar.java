import java.util.*;

public class asFar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int mat[][]= new int[n][n];
        for(int i =0; i<n;i++)
            for(int j = 0;j<n;j++)
                mat[i][j] = sc.nextInt();
        int ans = new Solution().maxDistance(mat);
        System.out.println(ans);
    }

   static class Solution {
//       void display(int m[][], int n)
//       {
//           for(int i =0; i<n;i++) {
//               for (int j = 0; j < n; j++)
//                   System.out.print(m[i][j]+"\t");
//               System.out.println();
//           }
//
//       }
        public int maxDistance(int[][] grid) {
            int size = grid.length;
            cell temp;
            int dp[][]=  new int [size][size];
            Queue<cell> q = new ArrayDeque<>();


            for(int i = 0; i<size; i++)
                for(int j =0; j<size; j++)
                    if(grid[i][j] == 1) {
                        q.add(new cell(i, j, 0));
                    }




            boolean vis[][] = new boolean[size][size];
            while(q.isEmpty() == false)
            {
                temp = q.remove();
                int i = temp.x;
                int j = temp.y;
            if(vis[i][j])
                continue;

            vis[i][j] = true;
//                if( grid[i][j] != 1 && dp[i][j] == 0)
                if(grid[i][j] == 1)
                {

                    temp.dist = 0;
                    dp[i][j]= temp.dist;
                    if(isValid(i, j+1,size))
                        q.add(new cell(i, j+1, temp.dist+1));

                    if(isValid(i, j-1,size))
                        q.add(new cell(i, j-1, temp.dist+1));

                    if(isValid(i+1, j,size))
                        q.add(new cell(i+1, j, temp.dist+1));

                    if(isValid(i-1, j,size))
                        q.add(new cell(i-1, j, temp.dist+1));

                }
                else{
                if(dp[i][j] == 0)
                {
                    dp[i][j]= temp.dist;

                    if(isValid(i, j+1,size))
                        q.add(new cell(i, j+1, temp.dist+1));

                    if(isValid(i, j-1,size))
                        q.add(new cell(i, j-1, temp.dist+1));

                    if(isValid(i+1, j,size))
                        q.add(new cell(i+1, j, temp.dist+1));

                    if(isValid(i-1, j,size))
                        q.add(new cell(i-1, j, temp.dist+1));

                }
                }

            }

            int max = -1;
            for(int i = 0; i<size; i++)
                for(int j =0; j<size; j++)
                    max = Math.max(dp[i][j], max);
            return max == 0 ? -1:max;



        }

        boolean isValid(int i , int j, int size)
        {
            if(i<0 || i>=size || j<0 || j>=size)
                return false;
            return true;
        }
        static class cell
        {
            int x, y, dist;
            cell(int a, int b, int c)
            {
                x = a;
                y = b;
                dist = c;
            }
        }



//     void bfs(int dp[][], int i , int j, int size, int dist)
//     {
//         if(i>=size || j>=size || i<0 || j<0)
//             return;
//         if(dp[i][j] = 0)
//             return;

//         // dp[i][j] = Math.min()

//     }

    }
}
