public class sieve {
    static void sieve(int n )
    {
        boolean isPrime[] = new boolean [n+1];
        for (int i = 2; i * i <= n; i++)
            if (!isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = true;



        //DISPLAY them
        for(int i = 2;i<=n;i++)
            if(!isPrime[i])
                System.out.print(i+" ");

        System.out.println();


    }

    public static void main(String[] args) {
        sieve(10);

    }

}
