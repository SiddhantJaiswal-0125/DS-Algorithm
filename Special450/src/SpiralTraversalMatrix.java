import java.util.Scanner;

public class SpiralTraversalMatrix
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int a[] []  = new int[n][c];
        int r1 = a.length;
        int c1 = a[0].length;


        System.out.println(r1);
        System.out.println(c);
        for(int i = 0;i<n;i++)
            for(int j= 0;j<n;j++)
                a[i][j] = sc.nextInt();

        System.out.println("NORMAL TRAVERSAL");
        for(int i = 0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }

        System.out.println("SPIRAL TRAVERSAL");
        SpiralTraversal(a,n);


    }



    static  void SpiralTraversal(int a[][], int n )
    {
        int top = 0, down = n-1,left = 0,right =n-1 , dir=0;
        while(left<=right && top <= down)
        {
            if(dir==0)
            {
                for(int i =left ; i<=right;i++)
                    System.out.print(a[top][i]+" ");
                top++;
            }
            else if(dir==1)
            {
                for(int i = top ;i<=down;i++)
                    System.out.print(a[i][right]+" ");
            right--;

            }
            else if(dir==2)
            {
                for(int i = right; i>=left;i--)
                    System.out.print(a[down][i]+" ");
            down--;

            }
            else if(dir==3)
            {
                for(int i = down ;i>=top;i--)
                    System.out.print(a[i][left]+" ");
                left++;
            }

            dir=(dir+1)%4;






        }
        System.out.println();




    }
}
