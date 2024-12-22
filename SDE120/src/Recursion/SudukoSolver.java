package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SudukoSolver {
//    public static void main(String[] args)
//    {
//
//        int row = 4;
//        for(int i =1 ; i<9;i++)
//        {
//            int v = 3 * (row/3) + i /3;
//            System.out.println(v);
//        }
//
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        char  board[][] = new char[m][m];
        for(int i =0;i<m;i++) {

            String ip = sc.next();
            for (int j = 0; j < m; j++)
                board[i][j] = ip.charAt(j);
        }

       for(int i = 0; i<m;i++)
       {
           for(int j = 0; j<m;j++)
               System.out.print(board[i][j] +"\t");
           System.out.println();
       }

    }

    public void solveSudoku(char[][] board) {
        solveKro(board);
        return;
    }

    boolean solveKro(char [][]  board)
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (checkKarkeBataoSahiHaiYaNahi(board, i, j, c)) {
                            board[i][j] = c;

                            if (solveKro(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    boolean checkKarkeBataoSahiHaiYaNahi(char [][]  board, int i, int j, char ch)
    {
        for(int idx=  0; idx<9;idx++)
        {
            if(board[i][idx] == ch)return false;
            if(board[idx][j] == ch) return false;


            //THIS IS THE MAIN LOGIC :: TODO:

            if(board[3 * (i/3) + idx/3] [3*(j/3)+idx%3]  == ch    )return  false;

        }

        return  true;
    }



}

