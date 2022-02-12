import java.util.*;


public class chapter1 {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i = 1;
		while (i <= t) {
			int n = sc.nextInt();
			String s = sc.next();
			if(s.charAt(0)=='X')
			{
				//START WITH left

				int ans = solve(s,n,-1);


				print(i, ans);
			}
			else if(s.charAt(0)=='O')
			{

				//start with right
				int ans = solve(s,n,1);

				print(i, ans);

			}
			else
			{
				//check for both
				int left = solve(s, n, -1);
				int right = solve(s, n, 1);
				int ans = left>right?right:left;
				print(i, ans);

			}
			i++;





		}
	}

	static int solve(String s, int size, int hand)
	{
		int count = 0;
		for(int i =0;i<size;i++)
		{
			char c = s.charAt(i);
			if(c=='X')
			{
				if(hand!=-1)
				{
					hand = -1;
					count++;
				}

			}
			else if(c=='O')
			{

				if(hand!=1)
				{
					hand = 1;
					count++;
				}

			}
		}
		return count;
	}

	static void print(int ca, int ans)
	{
		System.out.println("Case #"+ca+": "+ans);
	}

}