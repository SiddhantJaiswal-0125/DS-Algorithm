package Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ShortestBridge {

    int dirX[] = new int[]{1,-1, 0, 0};
    int dirY[] = new int[]{0, 0, -1, 1};
    void marking(int srX, int srY, int grid[][], boolean marker[][],int size)
    {
        if(srX >= size || srY >= size ||srX < 0 || srY < 0)
            return;
        if(marker[srX][srY])
            return;
        if(grid[srX][srY] == 0)
            return;

        marker[srX][srY] =true;
        for(int i =0;i<4;i++)
            marking(srX+dirX[i], srY+dirY[i], grid, marker, size);

        return;
    }

    void printar(boolean ar[][])
    {
        int n = ar.length;
        for(int i =0;i<n;i++)
        {
            for(int j =0 ;j<n;j++)
                System.out.print(ar[i][j]+"\t");
            System.out.println();
        }
    }
    void printar(int ar[][])
    {
        int n = ar.length;
        for(int i =0;i<n;i++)
        {
            for(int j =0 ;j<n;j++)
                System.out.print(ar[i][j]+"\t");
            System.out.println();
        }
    }
    int min;
    public int shortestBridge(int[][] grid) {

        int n = grid.length;
        min = Integer.MAX_VALUE;
//        System.out.println("ARRAY Print");
//        printar(grid);
        boolean marker[][] = new boolean[n][n];
        boolean marked = true;
        for(int i =0;i<n  && marked;i++)
        {
            for(int j =0;j<n && marked;j++)
            {
                if(grid[i][j]==1)
                {
                    marking(i, j, grid, marker, n);
                    marked = false;
                    break;
                }
            }
        }

//        System.out.println("PRINTING MARKER ");
//        System.out.println();
//        printar(marker);




//        int dis[][] = new int[n][n];
//
//        for(int i=0;i<n;i++)
//            for(int j =0;j<n;j++)
//                dis[i][j] = Integer.MAX_VALUE;

        boolean vis[][] = new boolean[n][n];
        for(int i=0;i<n;i++)
            for(int j =0;j<n;j++)
            {
                if(marker[i][j] == false  && grid[i][j] == 1 )
                {
                    vis= new boolean[n][n];
//                    System.out.println("-----------------------------------------------TRAVEL STARTED for i "+i+" \t j "+j);
                    bfs(i, j, marker, grid,n, vis);
                }
            }
        return min;
    }

    void bfs(int x, int y, boolean marker[][], int grid[][], int size, boolean vis[][])
    {
        Queue<BfsEle> queue= new ArrayDeque<>();
        queue.add(new BfsEle(x, y, 0, -1, -1));

        while (queue.size() > 0)
        {
            BfsEle e = queue.poll();
//            System.out.println(" ELEMENT POPED  "+e);

            if(e.i >= size || e.i<0 || e.j >=size || e.j <0)
                continue;



//            if(vis[e.i][e.j])
//                return;
//
//            vis[e.i][e.j]= true;


//            System.out.println(" after filteration ELEMENT POPED  "+e);
//            if(grid[e.i][e.j] == 0)
//                continue;

            if(grid[e.i][e.j] == 1 && marker[e.i][e.j])
            {
//                System.out.println("WE GOT SOME "+e);
                min = Math.min(min, e.dis-1);
                continue;
            }
            else {

//                System.out.println("ADDING ELEMENT FOR "+e+" q.size() "+ queue.size());
                for(int i =0;i<4;i++)
                {

                    if (
                            (e.i+dirX[i] != e.lX || e.j+dirY[i] != e.lY )
                            &&
                            (e.i+dirX[i] < size && e.j+dirY[i] <  size && e.i+dirX[i] >= 0 && e.j+dirY[i] >= 0 )
                            && ( grid[e.i+dirX[i]][e.j+dirY[i]] != 1 || marker[e.i+dirX[i]][e.j+dirY[i]] )
                                    &&
                            vis[e.i+dirX[i]][e.j+dirY[i]] ==false)
                                        {
                                            System.out.println(e);

                                            vis[e.i+dirX[i]][e.j+dirY[i]] = true;

                                            System.out.println("ADDING ELEMENT "+(e.i+dirX[i])+" \t"+ (e.j+dirY[i]));
                                            queue.add(new BfsEle(e.i+dirX[i], e.j+dirY[i], e.dis+1, e.i, e.j ));

                                        }

//                    if ( (e.i+dirX[i] != e.lX || e.j+dirY[i] != e.lY ) &&
//                            (e.i+dirX[i] < size && e.j+dirY[i] <  size &&e.i+dirX[i] >= 0 && e.j+dirY[i] >= 0  ) && vis[e.i+dirX[i]][e.j+dirY[i]] ==false)
//
//                    {
//                        System.out.println(e);
//
//                        vis[e.i+dirX[i]][e.j+dirY[i]] = true;
//
//                        System.out.println("ADDING ELEMENT "+(e.i+dirX[i])+" \t"+ (e.j+dirY[i]));
//                        queue.add(new BfsEle(e.i+dirX[i], e.j+dirY[i], e.dis+1, e.i, e.j ));
//
//                    }

                }
            }




        }

    }

    static  class BfsEle
    {
        int i, j, dis, lX, lY;
        BfsEle(int i, int j, int dis, int lx, int ly)
        {
            this.i = i;
            this.j = j;
            this.dis = dis;
            this.lX = lx;
            this.lY = ly;
        }

        @Override
        public String toString() {
            return "BfsEle{" +
                    "i=" + i +
                    ", j=" + j +
                    ", dis=" + dis +
                    ", lX=" + lX +
                    ", lY=" + lY +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[][]=  new int[n][n];
        for(int i=0;i<n;i++)
            for(int j =0;j<n;j++)
                ar[i][j] = sc.nextInt();


        int ans = new ShortestBridge().shortestBridge(ar);
        System.out.println("ANS "+ans);
    }
}


//5
//        1
//        1
//        1
//        1
//        1
//        1
//        0
//        0
//        0
//        1
//        1
//        0
//        1
//        0
//        1
//        1
//        0
//        0
//        0
//        1
//        1
//        1
//        1
//        1
//        1











//6
//        0
//        1
//        0
//        0
//        0
//        0
//        0
//        1
//        1
//        1
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        0
//        1
//        1
//        0
//        0
//        0
//        0

