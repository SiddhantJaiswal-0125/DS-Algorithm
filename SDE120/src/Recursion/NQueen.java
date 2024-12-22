package Recursion;

import java.util.*;

class NQueen{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(new NQueen().solveNQueens(n));
    }
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        boolean qPlace[][] = new boolean[n][n];
        NQueenTraversal(n, ans, qPlace, 0);
        return  ans;
     }

     static void NQueenTraversal(int n, List<List<String>> ans, boolean [][] qplace, int row)
     {
         if(row == n)
         {
             //adding it into final list

             List<String> asf = new ArrayList<>();


             for(int i = 0;i<n;i++)
             {
                 StringBuilder temp = new StringBuilder();


                 for(int j = 0; j<n;j++)
                     temp.append(qplace[i][j]? "Q":".");
                 asf.add(temp.toString());
             }

             ans.add(asf);


             return;
         }
         for(int i =0; i<n; i++)
         {
            if(isSafePlaceforQueen(qplace, row, i, n))
            {
                //vaild place add it and backtrack it.
                qplace[row][i] = true;
                NQueenTraversal(n, ans, qplace, row+1);
                qplace[row][i] = false;
            }

         }


     }

     static boolean isSafePlaceforQueen(boolean qplace[][], int row, int col, int n)
     {
         int i;
         for(i = row - 1; i >=0; i--)
             if(qplace[i][col])
                 return false;

         int j;
         for(j = col-1; j>=0 ;j--)
             if(qplace[row][j])
                 return false;


         for(i = row-1, j=col-1; i>=0 && j>=0; i--, j-- )
             if(qplace[i][j])
                 return  false;
         for(i = row-1, j=col+1; i>=0 && j<n; i--, j++)
             if(qplace[i][j])
                 return  false;



         return true;
     }



//    static void solve(int n, boolean board[][],
//                      int row, ArrayList<ArrayList<Integer>> res,
//                      ArrayList<Integer> temp)
//    {
//
//        if(row==n)
//        {
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//        else
//        {
//            for(int i  =0;i<n;i++)
//            {
//                if(isSafe(board, row, i))
//                {
//                    temp.add(i);
//                    board[row][i] = true;
//                    solve(n, board, row+1,res, temp);
//                    board[row][i] = false;
//                    temp.remove(temp.size()-1);
//                }
//            }
//
//        }
//
//
//
//    }
//    static boolean isSafe(boolean mat[][], int row, int col)
//    {
//        int n = mat.length;
//        for(int i = row-1;i>=0;i--)
//        {
//            if(mat[i][col])
//                return false;
//
//        }
//        for(int i = col-1;i>=0;i--)
//        {
//            if(mat[row][i])
//                return false;
//        }
//        for(int i = row-1, j = col-1;i>=0&& j>=0;i--,j--)
//            if(mat[i][j])
//                return false;
//        for(int i = row-1, j = col+1;i>=0&& j<n;i--,j++)
//            if(mat[i][j])
//                return false;
//
//
//
//
//        return true;
//    }

}