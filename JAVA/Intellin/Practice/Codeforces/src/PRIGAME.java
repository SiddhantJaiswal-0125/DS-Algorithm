import javax.management.ValueExp;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

 class PRIGAME
{
    static  int MAX_SIZE = 1000000;
    static  long primecount[] = new long[MAX_SIZE+2];
    static Vector<Boolean>isprime = new Vector<>(MAX_SIZE);
    static Vector<Integer>prime = new Vector<>(MAX_SIZE);
    static Vector<Integer>SPF = new Vector<>(MAX_SIZE);

    // method generate all prime number less then N in O(n)
    static void manipulated_seive(int N)
    {
        // 0 and 1 are not prime
        isprime.set(0, false);
        isprime.set(1, false);

        // Fill rest of the entries
        for (int i=2; i<N ; i++)
        {
            // If isPrime[i] == True then i is
            // prime number
            if (isprime.get(i))
            {
                prime.add(i);
                SPF.set(i,i);
            }

            for (int j=0; j < prime.size() && i*prime.get(j) < N && prime.get(j) <= SPF.get(i); j++)
            {
                isprime.set(i*prime.get(j),false);

                // put smallest prime factor of i*prime[j]
                SPF.set(i*prime.get(j),prime.get(j)) ;
            }
        }

//        for(int i = 2;i<MAX_SIZE;i++)
//        {
//
//        }1
        long c =0;
        for(int q= 2;q<MAX_SIZE;q++)
        {
//            if (prime[i])
            if(isprime.get(q))
                c++;

            primecount[q] = c;
//            System.out.println("FOR I = > "+q+ " primcount is : "+primecount[q]);
        }
        primecount[MAX_SIZE] = c;

    }
    public static void main(String[] args) throws  IOException
    {
        Reader sc = new Reader();
        int N = 13 ; // Must be less than MAX_SIZE

        // initializing isprime and spf
        for (int i = 0; i < MAX_SIZE; i++){
            isprime.add(true);
            SPF.add(2);
        }


        manipulated_seive(N);
        int test = sc.nextInt();

        while(test-->0)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(primecount[x]<=y)
                System.out.println("Chef");
            else
                System.out.println("Divyam");
        }


    }
       static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}








     class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

