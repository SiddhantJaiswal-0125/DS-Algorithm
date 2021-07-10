package Arrays;

import java.util.*;

public class SETZEROMATRIX
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j =0;j<n;j++)
                mat[i][j] = sc.nextInt();

            setZeroes(mat);


    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rows [] = new boolean[m];
        boolean column[] = new boolean[n];
        for(int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(rows[i]==false)
                    {
                        rows[i] = true;
                    }
                    if(column[j]==false)
                        column[j] = true;

                }

            }
        }

//        System.out.println("ROWS");
//
//        for(boolean b:rows)
//            System.out.print(b+"\t");
//        System.out.println();
//        System.out.println("COLUMNS");
//        for(boolean b:column)
//            System.out.print(b+"\t");
//        System.out.println();
//



        for(int i =0;i<m;i++)
        {
            if(rows[i])
            {
                for(int j =0;j<n;j++)
                    matrix[i][j] = 0;
            }
        }
        for(int j =0;j<n;j++)
        {
            if(column[j])
            {
                for(int i =0;i<m;i++)
                    matrix[i][j] = 0;
            }
        }




//        for(int i=0;i<m;i++){
//            for(int j =0;j<n;j++)
//                System.out.print(matrix[i][j]+"\t");
//            System.out.println();
    }
    }

