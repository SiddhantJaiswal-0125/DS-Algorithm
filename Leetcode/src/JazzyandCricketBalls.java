import java.util.Scanner;

class CandidateCode
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ar[] = new long[n];
        for(int i= 0;i<n;i++)
        {
            ar[i]  = sc.nextLong();
        }
        long ans = solve(n,ar);
        System.out.println(ans);
    }
    static long solve(int n , long ar[])
    {
        long res = 0l;

        for(long i : ar){

         long a  = find(i);
         res+=a;
        }
        return res;
    }

    static  long find(long n)
    {


        if(n==1)
            return 1;

        if(n%2==0)
        {
            long k =  n/2;


            if(k==1)
                return  3;

            else
            {
                long a1 = find(k);
                return  Math.max(a1*2, 3*k) + 1;
            }
        }
        else
        {
            //odd

            if(isPrime(n))
            {
                return 1 + n ;
            }
            else
            {
                long a =  fiPrimeMultiple(n);



            long k = n/a;
                long countforA = find(a);
            long countfork = find(k);


            return (long) Math.max((countforA*k), (countfork*a)) + 1;

            }
            }


    }
    static  long fiPrimeMultiple(long n)
    {
        for(long i  =n-1;i>=1;i--)
        {
            if(n%i==0)
                return  i;
        }
        return  n;

    }

    static  boolean  isPrime(long n)
    {
        for(long i = 2;i<=Math.sqrt(n);i++)
            if(n%i==0)
                return  false;


        return true;

    }
}

