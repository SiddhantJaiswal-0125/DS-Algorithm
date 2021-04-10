
// import java.util.Hashtable;
// import java.util.Scanner;

// public class Longestalternatingsubsequence
// {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int a[] = new int [n];
//         for(int i =0 ;i<n;i++)
//         a[i] = sc.nextInt();

//         int ans = AlternatingaMaxLength(a);
//         System.out.println(ans);

        
        
        
//         sc.close();

//     }

//     public static  int AlternatingaMaxLength(int[] a)
//     {
//         // code here
//         int n = a.length;
//         int dp[][] = new int[n][2];
//         for(int i =0;i<n;i++)
//             dp[i][0] = dp[i][1] = 1;
        
//             int res = 1;
//          for(int i = 1 ;i<n;i++)
//          {
//              for(int j = 0 ;j<n;j++)
//              {
//                 if(a[i]>a[j] && dp[i][0] < dp[j][1] +1 )
//                 dp[i][0] = dp[j][1] +1 ;
//                 if(a[i] < a[j] && dp[i][1] < dp[j][0] +1 )
//                 dp[i][1] = dp[j][0] +1 ;


//                 res = max(res, dp[i][0], dp[i][1]);


//              }
//          }   

    
//     return res;
//     }
//     static int max(int a, int b, int c)
//     {
//         return Math.max(a, Math.max(c, b));
//     }
//     public int[] twoSum(int[] a, int k) 
//     {
//         // Hashtable
//     //    Hashtable <Integer, Integer > ht = new Hashtable<>();
//        Hashtable  <Integer, Integer> ht = new Hashtable<>();
//         int n = a.length;
//         int p[] = new int[2];
//        for(int i = 0;i<n;i++) 
//        {
//            int  q = k - a[i] ;
//            if(ht.contains(q))
//            {
               
               
//            }
//        }
        
//     }
    
// }
