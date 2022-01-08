import java.util.Scanner;

public class NeighborGrid
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int  m = sc.nextInt();
            int a[][] = new int[n][m];
            for(int i =0 ;i<n;i++)
            {
                for(int j = 0;j<m;j++)
                {
                    a[i][j] = sc.nextInt();
                    if(a[i][j]==0)
                        a[i][j] = 1;

                }
            }
            if(!solve(a,n,m))
            {
                System.out.println("NO");
            }



        }
    }
    static  boolean solve(int [][]a,int n ,int m)
    {

        //first corner cells
        int ans[][] = new int[n][m];

        if(a[0][0]>2) {
            return false;
        }else if(a[0][m-1]>2)
        {   return false;}
        else if(a[n-1][0]>2) {
            return false;
        }else if(a[n-1][m-1]>2) {
            return false;
        }else
        {
            //row = 0;
            for(int j=1;j<m-1;j++)
            {
                ans[0][j] = 3;

                if(a[0][j]>3)
                    return  false;
            }

            //for last row
            for(int j=1;j<m-1;j++)
            {
                ans [n-1][j] = 3;

                if(a[n-1][j]>3)
                    return  false;
            }
            //for first column
            for(int i=1;i<n-1;i++)
            {
                ans [i][0] = 3;
                if(a[i][0]>3)
                    return  false;
            }


            //last column
            for(int i=1;i<n-1;i++)
            {
                ans [i][m-1] = 3;
                if(a[i][m-1]>3)
                    return  false;
            }
            for(int  i =1;i<n-1;i++)
            {
                for(int j = 1;j<m-1;j++)
                {
                    ans[i][j] = 4;
                    if(a[i][j]>4)
                        return  false;
                }

            }

        }

        ans[0][0] = 2;
        ans[0][m-1] = 2;
        ans[n-1][0] = 2;
        ans[n-1][m-1] = 2;
        System.out.println("YES");
        print(ans,n,m);
    return  true;
    }


    static  void print(int a[][],int n ,int m )
    {

        for(int i =0 ;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                System.out.print(a[i][j] +" ");

            }
            System.out.println();
        }
    }
}
