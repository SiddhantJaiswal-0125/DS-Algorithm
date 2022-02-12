package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SudukoSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int  mat[][] = new int[m][m];
        for(int i =0;i<m;i++)
            for(int j =0;j<m;j++)
                mat[i][j] = sc.nextInt();
            ArrayList<String> ans = findPath(mat,m);
            if(ans.size() >0)
            {
                for(int i = 0;i<ans.size();i++)
                    System.out.print(ans.get(i)+"\t");
                System.out.println();

            }
            else
                System.out.println(-1);
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        boolean isVis[][]= new boolean[n][n];
        //FOR DOWN
        solve(m,n,0,0,res,"" ,isVis);


        Collections.sort(res);
        return res;
    }
    static void solve(int [][]m, int n, int r, int c,
                      ArrayList<String>res,String asf, boolean isVis[][])
    {
        if(r>=n || c>=n || r<0||c<0)
            return;
        if(m[r][c] == 0)
            return;

        if(r==n-1 && c==n-1)
        {
            res.add(new String(asf));
            return;
        }
        if(isVis[r][c])
            return;
        isVis[r][c] = true;
        //Down
        solve(m,n,r+1, c, res, asf+"D",isVis);
        //Left
        solve(m,n,r, c-1, res, asf+"L",isVis);
        //Rigth
        solve(m,n,r, c+1, res, asf+"R",isVis);
        //Up
        solve(m,n,r-1, c, res, asf+"U",isVis);
        isVis[r][c] = false;



        return;


    }
}

