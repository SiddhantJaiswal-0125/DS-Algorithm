import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
 class wipl2
{
    public static void main(String[] args) throws IOException
    {
        Reader sc = new Reader();
        int test = sc.nextInt();
        while (test-->0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long h[] = new long[n];
            long sum = 0l;
            for(int i =0;i<n;i++)
            {
                h[i] = sc.nextLong();
                sum+=h[i];
            }

            if(sum<(2*k)) {
//                System.out.println("HERE");
                System.out.println(-1);
            }
            else
                {
                long mikeCount = 0l;
                Arrays.sort(h);
                int ind = n-1;
                long total = 0l;
//                    System.out.println("DISPLAY");
//                    for(long i:h)
//                        System.out.print(i+" ");
//                    System.out.println();
//                    System.out.println();

               while(mikeCount<k && ind >=0)
               {
                   if(h[ind] <k-mikeCount)
                   {
//                       System.out.println("ENTER FOR "+h[ind]);
                       mikeCount+=h[ind];
                       h[ind] = -1;
                       ind--;
                       total++;
                   }
                   else
                   {
                       long min = Long.MIN_VALUE;
                       long sub =  0;
                       int _index = 0;
                       long val =0;
                       for(int i = ind ;i>=0;i--)
                       {
                           sub = k - mikeCount -h[i];
                           if(sub>0)
                               break;
                           else
                           {
                               if(sub>min)
                               {
                                   min = sub;
                                   val = h[i];
                                   _index = i;
                               }                           }

                       }
                       h[_index] = -1;
                       mikeCount+=val;
                       total++;
                   }




               }
               long tracyCount = 0l;

               for(int i =n-1;i>=0&&tracyCount<k;i--)
               {
                   if(h[i]!=-1)
                   {
                       tracyCount+=h[i];
                       total++;
                   }
               }
//                    System.out.println("TRACYCOUNT "+tracyCount);
//                    System.out.println("MIKECOUNT "+mikeCount);
               if(tracyCount>=k && mikeCount>=k)
                   System.out.println(total);
               else
                   System.out.println(-1);



        }
        }

    }
}




//if(h[ind] <k-mikeCount)
//        {
//        mikeCount+=h[ind];
//        h[ind] = -1;
//        ind--;
//        }
//        else
//        {
//        int min = Integer.MAX_VALUE;
//        int _index = 0;
//        for(int i = ind ;i>=0;i--)
//        {
//        long sub =k- mikeCount-h[i];
//
//        }
//        }

     class Reader {
         final private int BUFFER_SIZE = 1 << 16;
         private DataInputStream din;
         private byte[] buffer;
         private int bufferPointer, bytesRead;

         public Reader() {
             din = new DataInputStream(System.in);
             buffer = new byte[BUFFER_SIZE];
             bufferPointer = bytesRead = 0;
         }

         public Reader(String file_name) throws IOException {
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
             } while ((c = read()) >= '0' &&c <= '9');
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
             while ((c = read()) >= '0' &&c <= '9');
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
             while ((c = read()) >= '0' &&c <= '9');
             if (c == '.')
             {
                 while ((c = read()) >= '0' &&c <= '9')
                 {
                     ret += (c - '0') /(div *= 10);
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
