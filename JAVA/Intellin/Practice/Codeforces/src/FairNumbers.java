import java.util.Scanner;

public class FairNumbers
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0)
        {
            long n = sc.nextLong();
            long _superFair  = 2520;
            if(n>_superFair){

                long p = ((n-1)/_superFair)+1;
                _superFair = p * _superFair;

            }

//            System.out.println("Super fair "+_superFair);
            for(long i = n;i<=_superFair;i++)
            {
                if(isFair(i)) {
                    System.out.println(i);
                break;
                }
            }



        }
    }
    static  boolean isFair(long n )
    {
        long _copy = n;
        while(_copy>0)
        {
            long k = _copy%10;
            _copy/=10;
            if(k!=0&& n%k!=0)
                return  false;

        }



        return true;
    }

}
