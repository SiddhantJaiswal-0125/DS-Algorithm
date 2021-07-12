package Arrays;

import java.util.Scanner;

public class SearchIn2dmatrix
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mat[][] = new int[m][n];
        for(int i= 0;i<m;i++)
            for(int j = 0;j<n;j++)
                mat[i][j] = sc.nextInt();
            int tar = sc.nextInt();


        System.out.println(new SearchIn2dmatrix().searchMatrix(mat,tar));

        System.out.println(new SearchIn2dmatrix().approch2(mat, tar));

    }
    public boolean searchMatrix(int[][] matrix, int target) {

        int  m = matrix.length;


        boolean  b =false;
        for(int i = 0; i<m;i++)
        {
            if(matrix[i].length>0)
            {
                if(matrix[i][0]>target)
                    return  false;
                else if(matrix[i][0]==target)
                    return true;
               b = find(i, matrix, target);
               if(b)
                   return  true;
            }
        }


        return false;
    }
    boolean find(int i , int matrix[][], int tar)
    {
        int low  = 0, high  = matrix[i].length-1;
        int mid;
        while (low<=high)
        {
            mid =  (low+high)/2;
            if(matrix[i][mid]==tar)
                return true;
            if(matrix[i][mid]>tar)
                high = mid -1;
            else
                 low = mid+1;

        }



        return false;
    }




    boolean approch2(int matrix[][], int target)
    {

       return search(matrix, 0,matrix[0].length - 1, target );


//        return  false;
    }


    boolean search(int mat[][], int i , int j , int tar)
    {
        if(i<0 ||j<0 || i> mat.length||j>mat[i].length)
            return  false;
        if(mat[i][j]==tar)
            return  true;
        if(mat[i][j]<tar)
        return  search(mat,i+1, j,tar);
        else
            return  search(mat, i,j-1, tar);







    }
}
