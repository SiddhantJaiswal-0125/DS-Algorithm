package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class RatInAMaze {
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        int dirX [] = new int[] {-1, 1, 0, 0 };
        int dirY[] = new int [] {0, 0, -1, 1};
        char dir[] = new char[]{'U', 'D', 'L', 'R'};
        ArrayList<String>  result = new ArrayList<>();
        boolean vis[][] = new  boolean[mat.size()][mat.size()];

        traversal(0, 0, mat, vis, result, dirX, dirY, dir, "",mat.size());

        return result;

    }

    public void traversal(int row, int col,
                          ArrayList<ArrayList<Integer>> mat, boolean vis[][],
                          ArrayList<String> result,
                          int dirX[], int []dirY, char []dir,
                          String asf, int size)


    {
        if(row==size-1 && col == size-1)
        {
            if(mat.get(row).get(col) == 0)
                return;
            result.add(new String(asf));
            return;
        }

        //OutOfBound Check done
        if(row >= size || col >= size || row <0 || col < 0)
            return;

        if(vis[row][col] == false && mat.get(row).get(col) == 1 )
        {
            vis[row][col] = true;
            int i;
            for(i = 0; i<4;i++)
            {
                traversal(row+dirX[i], col+dirY[i],
                        mat,vis,
                        result,
                        dirX, dirY, dir,
                        asf+""+dir[i], size);
            }


            vis[row][col]= false;

        }

    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        for(int i = 0 ;i<n;i++)
        {
            mat.add(new ArrayList<>());
            for(int j = 0;j<n;j++)
                mat.get(i).add(scn.nextInt());


        }


        System.out.println(mat);


        System.out.println("ANS");
        System.out.println(new RatInAMaze().findPath(mat));
    }
}



//4
//        1
//        0
//        0
//        0
//        1
//        1
//        0
//        1
//        1
//        1
//        0
//        0
//        0
//        1
//        1
//        1
