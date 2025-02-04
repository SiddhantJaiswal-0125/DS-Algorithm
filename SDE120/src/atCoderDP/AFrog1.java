package atCoderDP;


import java.util.*;
 class AFrog1  {
     public static void main(String[] args) {
         Scanner sc =  new Scanner(System.in);
         int n = sc.nextInt();
         int ar[] = new int[n];
         for(int i=0;i<n;i++)
             ar[i] = sc.nextInt();
         int last = Math.abs(ar[0]-ar[1]);
         int secondlast = 0;


         for(int i =2;i<n;i++)
         {
             int ab1 = last + Math.abs(ar[i] - ar[i-1]);
             int ab2 = secondlast + Math.abs(ar[i]- ar[i-2]);
            secondlast = last;

            last = Math.min(ab1, ab2);


         }

         System.out.println(last);

     }
}
