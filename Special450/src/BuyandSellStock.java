import java.util.Scanner;

public class BuyandSellStock
{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int  n = sc.nextInt();
        int a[] = new int[n];
        for(int i =0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }

        System.out.println(maxProfit(a,n));

    }
    static  int maxProfit ( int a[] ,int n )
    {
        int _min = a[0];
        int _max = 0;
        if(n==1)
            return  0;

        for(int i = 0;i<n;i++)
        {
            _min = Math.min(_min,a[i]);
            int _cost = a[i] - _min;
            if(_cost > _max)
                _max = _cost;

        }
        return  _max;
    }
}
