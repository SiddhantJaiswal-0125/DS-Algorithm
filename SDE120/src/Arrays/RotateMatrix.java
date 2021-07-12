package Arrays;

import java.util.Scanner;

public class RotateMatrix
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j = 0;j<n;j++)
                mat[i][j] = sc.nextInt();

        System.out.println("NORMAL"
        );
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }


        new RotateMatrix().rotate(mat);
        System.out.println("FINAL");
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(mat[i][j]+"\t");
            System.out.println();
        }


    }
    public void rotate(int[][] matrix) {
        //1step get the transpose matrix;
        int n = matrix.length;

        for(int i=0;i<n;i++)
        {
            for (int j =i;j<n;j++)
            {
                int temp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }

            }

        //2nd step reverse each row
        for(int i =0;i<n;i++)
        {
            int j = 0;
            int k = n-1;
            while(j<k)
            {
                int temp= matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;

            }

        }




    }
}
