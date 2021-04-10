package GFG30Days;

import java.util.Scanner;

public class DAY5
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int  n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int a[][]= new int[n][m];
        for(int i  = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                a[i][j] = sc.nextInt();




        int ans = solve(a,n,m,k);
//        System.out.println("ans");
        System.out.println(ans);
    }
static int solve(int a[][], int n , int m, int k)
{
//    System.out.println("k "+k);
   int count = 0;
   int dir = 0;
   int top = 0;
   int left = 0;
   int down = n-1;
   int right = m-1;
   while(top<=down && left <= right)
   {
       if(dir ==0)
       {
           for(int i = left;i<=right;i++) {
//               print(a[top][i]);
               count++;
               if(count==k)
                   return a[top][i];

           }
           top++;

       }
      else if(dir ==1)
       {
           for(int i =top;i<=down;i++) {
//               print(a[i][right]);
               count++;
               if(count==k)
                   return a[i][right];

           }

           right--;

       }
    else   if(dir ==2)
       {
           for(int i =right;i>=left;i--) {
//               print(a[down][i]);
               count++;
               if(count==k)
                   return a[down][i];

           }

          down--;

       }
       else   if(dir ==3)
       {
           for(int i =down;i>=top;i--) {
//               print(a[i][left]);
               count++;
               if(count==k)
                   return a[i][left];

           }

           left++;

       }
   dir =  (dir+1)%4;
   }


  return  -1;

}
static void print (int i){
    System.out.print(i+" ");
}
}
