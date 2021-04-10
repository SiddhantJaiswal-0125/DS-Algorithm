//GREAT PUZZLE QUESTION ASKED IN AMAZON

package GFG30Days;
/* Number of minimum picks to get 'k' pairs of socks from a drawer */


import java.util.Scanner;

/*A drawer contains socks of n different colours. The number of socks available of ith colour is given by a[i] where a is an array of
n elements. Tony wants to take k pairs of socks out of the drawer. However, he cannot see the colour of the sock that he is picking.
You have to tell what is the minimum number of socks Tony has to pick in one attempt from the drawer such that he can be absolutely
sure, without seeing their colours, that he will have at least k matching pairs.
*/
public class Day4
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int k = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++)
            a[i] = sc.nextInt();
        int ans = solve(a,n,k);
        System.out.println(ans);
    }
static int solve(int a[],int n, int k)
{


    int pairs =0;
    int optimal = 0;
    int ans =0;

    for(int  i =0;i<n;i++)
    {
        pairs+=(a[i]/2);


        if(a[i]%2==0)
            optimal+=(a[i]-2)/2;
        else
            optimal += (a[i]-1)/2;



    }
    if(pairs<k)
        return  -1;
    if(k<=optimal)
        ans = 2*(k-1)+(n+1);
    else
        ans = 2*optimal+(k-optimal)+n;

    return ans ;





}


}
