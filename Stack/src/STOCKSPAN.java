import java.util.Scanner;
import java.util.Stack;

/*The stock span problem is a financial problem where
we have a series of n daily price quotes for a stock and
we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum
number of consecutive days just before the given day,for which the price of the
stock on the current day is less than or equal to its price on the given day.*/
public class STOCKSPAN
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter prices of stocks");
            int a[] = new int[n];

        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();

        int res[] = solve(a,n);

        for(int i:res)
            System.out.print(i+" ");
        System.out.println();

    }
    static  int [] solve(int a[],int n)
    {
        Stack <Integer> index = new Stack<Integer>();
        int ans [] = new int[n];
        index.push(0);
        ans[0] = 1;
        for(int i = 1;i<n;i++)
        {
            while(!index.isEmpty() && a[index.peek()]<=a[i])
            {
                index.pop();
            }
            ans[i] = index.isEmpty()?(i+1):(i-index.peek());

            index.push(i);
        }
    return ans;

    }
}
