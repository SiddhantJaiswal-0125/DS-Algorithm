import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

class andOr
{
    public static void main(String[] args)  throws  IOException
    {
        FastReader sc = new FastReader();
        int test = sc.nextInt();
        while(test-->0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[] = new int[n];
            int b[] = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();

            }
            Stack <Integer> st = new Stack<>();
            HashSet<Integer>hs = new HashSet<>();
            st.add(0);
            hs.add(0);
            while(!st.empty())
            {int x=st.pop();
                for(int i=0;i<n;i++)
                {
                    int c=a[i];
                    boolean check = hs.contains((x|c));
                    if(!check)
                    {
                        hs.add(x|c);
                        st.push(x|c);
                    }
                }
                for(int i=0;i<m;i++){
                    int c=b[i];
                    boolean check = hs.contains((x&c));
                    if(!check){
                        hs.add(x&c);
                        st.push(x&c);
                    }}}
            System.out.println(hs.size());
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
}

