//
//import java.util.*;
//
//class LAS
//{
//public static void main(String [] args[])
//{
//	Scanner sc = new Scanner(System.in);
//	int n = sc.nextInt();
//	int ar[] = new int[n];
//	for(int i =0;i<n;i++)
//	ar[i] = sc.nextInt();
//
//	int ans = solve(ar, n);
//	System.out.println(ans);
//
//
//
//}
//static int solve(int ar[], int n)
//{
//	int max = -1;
//	for(int i = 0;i<n;i++)
//	{
//
//		for(int j =  i+1;j<n;j++)
//		{
//			int k = j;
//			int diff = ar[j] - ar[i];
//			int curr = 1;
//
//			int l = i;
//			int r = j;
//
//
//			while(r<n)
//			{
//				if(ar[r] - ar[l] == diff)
//				{
////					count++;
//
//
//
//
//
//					}
//
//				r++;
//
//
//
//			}
//
//
//		}
//
//
//	}
//
//
//
//}
//
//}