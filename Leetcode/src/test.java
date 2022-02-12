import java.util.Scanner;

class test
{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int  n = sc.nextInt();
         int k = sc.nextInt();


         int ar[]= new int[n];
         int presum[] = new int[n];
         for(int i = 0;i<n;i++)
         {
             ar[i] = i+1;
             if(i==0)
                 presum[i] = 0;
             else
             {
                 presum[i] = presum[i-1]+ar[i];

             }
         }
    }
}