package Arrays;

import java.util.*;

public class PascalTriangle
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
//        System.out.println(new PascalTriangle().generate(numRows));

        System.out.println(solve(numRows));

    }

    public static List<List<Integer>>  solve(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> ans = new ArrayList<>();


        int mat[][] = new int[numRows][numRows];
        mat[0][0] = 1;

        List<Integer> ad = new ArrayList<>();
        ad.add(1);

        for(int i = 1;i<numRows;i++)
        {
            ans.add(ad);
            ad = new ArrayList<>();
            for(int j =0;j<i+1;j++)
            {
                if(j==0)
                {
                    mat[i][j]= 1;

                }
                else if(j==i)
                  mat[i][j] = 1;
                else
                {
                    mat[i][j] = mat[i-1][j]+mat[i-1][j-1];

                }
                ad.add(mat[i][j]);
            }
        }
        ans.add(ad);



        return ans;
    }
}
