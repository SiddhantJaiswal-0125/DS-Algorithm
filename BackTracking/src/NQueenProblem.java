import java.util.Scanner;

public class NQueenProblem
{
    static  int board[][] ;
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Board :");
        int n = sc.nextInt();
        board = new int[n+1][n+1];
        placeNqueen(n);


    }
   static  void placeNqueen ( int n )
   {
       nQueenHelper(n,0);
   }
   static void nQueenHelper(int n, int row)
   {
//       Base case
       if(row == n)
       {

//           We reach the final Answer
//           Print the Board
//           return
           System.out.println("Start here ");
           for(int i = 0;i<n;i++)
           {

               for(int j= 0 ;j<n;j++)
               {
                   System.out.print(board[i][j]+" ");
               }
               System.out.println();
           }


           System.out.println("End HERE");
           System.out.println();
           System.out.println();

           return;
       }
//       place at all possible position and move to smaller input
       for(int j = 0;j<n;j++)
       {
           if (isPossible(n, row, j))
           {
               board[row][j] = 1;
               nQueenHelper(n, row + 1);
               board[row][j] = 0;
           }
       }
       return;

   }

   static boolean isPossible(int n,int row, int col)
   {
//       Same column
       for(int i =row-1;i>=0;i--)
       {
           if(board[i][col]==1)
               return false;
       }
//upper left column
       for(int i =row -1 ,j=col-1;i>=0&&j>=0;i--,j--)
       {
           if(board[i][j]==1)
               return false;
       }
// upper right column
       for(int i =row-1,j=col+1;i>=0&&j<n;i--,j++)
       {
           if(board[i][j]==1)
               return false;
       }

//       if satisfied all previous then we are ready to put
       return true;
   }





}
