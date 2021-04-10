import java.util.Scanner;

public class Minimumcosttofillgivenweightinabag {
    static int dp[][];
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int  n  = sc.nextInt();
      int a[] = new int [n];
    //   for(int i : a)
    //   i = sc.nextInt();
   
      for(int i =0;i<n;i++)
      a[i] = sc.nextInt();
      int w = sc.nextInt();
    // display(a);


    int ans = solve(a, n, w);
    
    System.out.println(ans);


      sc.close();
  } 

  static void display(int a[])
  {
      for(int i : a)
      System.out.print(i+" ");
      System.out.println();
  }
  static int solve(int a[], int n , int w)
  {
      int dp[] = new int [w+1];
      for (int i = 1; i <= w; i++)
        dp[i] = Integer.MAX_VALUE;
    for (int i = 1; i <= w; i++) {
        for (int j = 0; j < n; j++) {
            if (a[j] != -1 && (j + 1) <= i && dp[i - (j + 1)] != Integer.MAX_VALUE && dp[i - (j + 1)] + a[j] < dp[i]) {
                dp[i] = dp[i - (j + 1)] + a[j];
            }
        }
    }

    if (dp[w] == Integer.MAX_VALUE)
        return -1;

    return dp[w];
}
}