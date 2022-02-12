package Recursion;

import java.util.ArrayList;

public class NQueen {
}


class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean mat[][] = new boolean[n][n];
        ArrayList<Integer> temp = new ArrayList<>();

        solve(n, mat, 0,res, temp);
        return res;
    }
    static void solve(int n, boolean board[][],
                      int row, ArrayList<ArrayList<Integer>> res,
                      ArrayList<Integer> temp)
    {

        if(row==n)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        else
        {
            for(int i  =0;i<n;i++)
            {
                if(isSafe(board, row, i))
                {
                    temp.add(i);
                    board[row][i] = true;
                    solve(n, board, row+1,res, temp);
                    board[row][i] = false;
                    temp.remove(temp.size()-1);
                }
            }

        }



    }
    static boolean isSafe(boolean mat[][], int row, int col)
    {
        int n = mat.length;
        for(int i = row-1;i>=0;i--)
        {
            if(mat[i][col])
                return false;

        }
        for(int i = col-1;i>=0;i--)
        {
            if(mat[row][i])
                return false;
        }
        for(int i = row-1, j = col-1;i>=0&& j>=0;i--,j--)
            if(mat[i][j])
                return false;
        for(int i = row-1, j = col+1;i>=0&& j<n;i--,j++)
            if(mat[i][j])
                return false;




        return true;
    }

}