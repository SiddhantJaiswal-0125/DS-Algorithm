import java.util.Arrays;
import java.util.Scanner;

public class MorningJogging {




	public static void main (String[] args) throws java.lang.Exception
	{
		//CODE BY SIDDHANT JAISWAL
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int tt = 0;tt<t;tt++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long brr [] = new long[n*m];
			int k = 0;
			long arr[][] = new long[n][m];

			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					long tmp = sc.nextLong();
					arr[i][j] = tmp;
					brr[k] = tmp;
					k++;
				}
			}
			boolean visited[][] = new boolean[101][101];

			Arrays.sort(brr);
			for(k = 0;k<m;k++) {
				outer: for(int i = 0;i<n;i++) {
					for(int j = 0;j<m;j++) {
						if(arr[i][j] == brr[k] && visited[i][j] == false) {
							long temp = arr[i][j];
							arr[i][j] = arr[i][k];
							arr[i][k] = temp;
							visited[i][k] = true;
							break outer;
						}
					}
				}
			}

			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}


	}


}