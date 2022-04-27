import java.util.*;
public class Nearestexit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        char mat[][]=  new char[m][n];
        for(int i =0;i<m;i++) {
            String st = sc.next();
            for (int j = 0; j < n; j++)

                mat[i][j]= st.charAt(j);

        }
      int ent[]= new int[2];
      ent[0]= sc.nextInt();
      ent[1]= sc.nextInt();
      int ans = new Solution().nearestExit(mat, ent);

        System.out.println(ans);
    }
    static class Solution {

        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length;
            int n = maze[0].length;
            int dX[] = new int[]{1,-1,0,0};
            int dY[] = new int[]{0,0,-1,1};
            Queue<int[]> q = new ArrayDeque<>();
            q.add(entrance);
            int dist = 0;
            while(q.size() > 0)
            {
                int size = q.size();
                dist++;
                while(size-->0)
                {
                    int ar[] = q.remove();

                    if(maze[ar[0]][ar[1]] == '+')
                        continue;

                    //VISITED;
                    maze[ar[0]][ar[1]] = '+';

                    for(int i =0;i<4;i++)
                    {
                        int x = ar[0] + dX[i];
                        int y = ar[1] + dY[i];

                        if(isValid(x,y,maze, m, n))
                        {
                            if(x == 0 || x == m-1 || y ==0 || y == n-1)
                                return dist;
                            q.add(new int[]{x,y});
                        }
                    }


                }
            }
            return -1;

        }

        private  boolean isValid(int i, int j, char maze[][], int m , int n )
        {
            if(i<0 || j< 0 || i>=m||j>=n || maze[i][j] == '+')
                return false;
            return true;

        }
    }
    static class pair implements Comparable<pair>
    {
        int ind, val;
        public int compareTo(pair o)
        {
            return o.val - this.val;
        }
    }

}
