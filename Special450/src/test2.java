import java.util.Scanner;

public class test2 {
    static void printMaxSubSquare(int a[][], int r,int c)
    {
        int i,j;
        int max, p, q;
        int temp[][] = new int[r][c];
        for(i = 0; i < r; i++)
            temp[i][0] = a[i][0];
        for(j = 0; j < c; j++)
            temp[0][j] = a[0][j];
        for(i = 1; i < r; i++)
        {
            for(j = 1; j < c; j++)
            {
                if(a[i][j] == 1)
                    temp[i][j] = Math.min(temp[i][j-1],
                            Math.min(temp[i-1][j], temp[i-1][j-1])) + 1;
                else
                    temp[i][j] = 0;
            }
        }

        max = temp[0][0]; p = 0; q = 0;
        for(i = 0; i < r; i++)
        {
            for(j = 0; j < c; j++)
            {
                if(max < temp[i][j])
                {
                    max = temp[i][j];
                    p = i;
                    q = j;
                }
            }
        }

        System.out.println("ANSWER ");
        for(i = p; i > p - max; i--)
        {
            for(j = q; j > q- max; j--)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the Size od the matrix :");

        int  n = sc.nextInt();
        int m = sc.nextInt();
        int a[][]= new int[m][n];
        for(int i = 0;i<m;i++)
            for(int j = 0;j<n;j++)
                a[i][j] = sc.nextInt();


            //for print the matriix for try

        for(int i = 0;i<m;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }

        printMaxSubSquare(a,m,n);
    }

}

