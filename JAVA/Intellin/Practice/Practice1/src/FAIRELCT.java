import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
class FAIRELCT
{
    static  boolean check = true;
    public static void main(String[] args) throws  IOException
    {
        FastReader sc = new FastReader();

        int test = sc.nextInt();
        while(test-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            long A = 0l;
            long B =0l;
            for(int i = 0;i<n;i++){
                a[i] = sc.nextInt();
                A+=a[i];
            }

            for(int i = 0;i<m;i++){
                b[i] = sc.nextInt();
                B+=b[i];
            }
            long res = get(a,b,A,B,n,m);

            if(check)
                System.out.println(-1);
            else
                System.out.println(res  );

        }
    }
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
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

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
    static long get(int a[],int b[],long sumA,long sumB,int n ,int m)
    {
        check = true;
        Arrays.sort(a);
        Arrays.sort(b);
        int i =0;
        int swap = 0;
        int j = m-1;
        while(i<n &&m>=0&& sumA<=sumB)
        {
            sumA-=a[i];
            sumA+=b[j];
            sumB-=b[j];
            sumB+=a[i];
            i++;
            j--;
            swap++;
        }
        if(sumA>sumB)
            check = false;

        return swap;











    }
}