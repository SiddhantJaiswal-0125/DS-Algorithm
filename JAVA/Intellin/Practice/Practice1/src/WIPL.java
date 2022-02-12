
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class WIPL
{
    static FastReader sc = new FastReader();
    public static void main(String[] args) throws IOException {

        int test = sc.nextInt();
        while (test -- > 0) {
            answer();


        }
    }
static  void answer() throws IOException
{
    int size = sc.nextInt();
    int k = sc.nextInt();
    int height[] = new int[size];
    for (int i = 0; i < size; i++) {
        height[i] = sc.nextInt();
    }

    if (size == 1) {
        System.out.println(-1);
    }
    else {
        Arrays.sort(height);
        int result = result(height,k,size);
        System.out.println(result);
    }

}
    public static int result(int arr[], int k, int n)
    {
        LinkedHashSet<Integer> s1 = new LinkedHashSet<>();

        s1.add(arr[n - 1]);
        long sum = arr[n - 1];
        int result = -1;
        for (int i = n - 2; i >= 0; i--) {
            LinkedHashSet<Integer> s2 = new LinkedHashSet<>();
            sum += arr[i];
            Iterator it = s1.iterator();
            while (it.hasNext()) {
                int p = (int) (it.next());
                s2.add(p);
                s2.add(arr[i]);
                s2.add(p + arr[i]);
                if (arr[i] >= k && (sum - arr[i] >= k)) {
                    result = n - i;
                    break;
                } else if ((p + arr[i] >= k) && (sum - p - arr[i]) >= k) {
                    result = n - i;
                    break;

                }

            }
            if (result != -1) {
                break;
            }
            s1 = s2;
        }
        return result;
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