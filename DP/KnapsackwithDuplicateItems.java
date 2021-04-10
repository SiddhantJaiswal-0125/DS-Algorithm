import java.util.*;

class KnapsackwithDuplicateItems	
{
static int dp[][];
	public static void main(String [] args)
	{
	Scanner	 sc = new Scanner(System.in);
	int n = sc.nextInt();
	int w = sc.nextInt();
	int a[] = new int[n];
	int val[] = new int[n];
	for(int i = 0;i<n;i++)
	val[i]  = sc.nextInt();
	for(int i =0;i<n;i++)
	a[i] = sc.nextInt();


	dp = new int [n+1][w+1];
	for(int i=0;i<n+1;i++)
	for(int j  =0;j<w+1;j++)
	dp[i][j] = -1;
	int ans = knapSack(n, w, val,a);

	System.out.println(ans);
	

	sc.close();

	}
  static int knapSack(int n, int w, int val[], int wt[])
    {
        // code here	
		
	


	if(n<=0 || w<=0)
	return 0;



	
	if(dp[n][w]!=-1)
	return dp[n][w];
	
	dp[n][w] = max  (val[n-1]+ knapSack( n,w-wt[n-1],val,wt) ,knapSack(n-1, w, val, wt));
	return dp[n][w];

	

        
        
    
    }

static int max (int a , int b)
{
	return a>b?a:b;
}

}