import java.util.Scanner;

public class Jumps
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            long x = sc.nextLong();
          if(  ifsum(x))
          {
//              System.out.println("here");
              System.out.println(find(x));

          }
          else
          {
            int p =1;
            int y=0;
            int ans = 0;
            while(y<x) {
                ans++;
                y += p;
                p++;
            }
            if((y-x)==1)
                System.out.println(ans+1);
            else
                System.out.println(ans);
          }
        }

    }
    static  int find(long n)
    {
        return (int) (-1+(Math.sqrt(1+(8*n))))/2;
    }
    static boolean ifsum(long s)
    {

            long l = 1, r = (s / 2) + 1;

            // Apply Binary search
            while (l <= r) {

                // Find mid
                long mid = (l + r) / 2;

                // find sum of 1 to mid natural
                // numbers using formula
                long sum = mid * (mid + 1) / 2;

                // If sum is equal to n
                // return mid
                if (sum == s)
                    return true;

                    // If greater than n
                    // do r = mid-1
                else if (sum > s)
                    r = mid - 1;

                    // else do l = mid + 1
                else
                    l = mid + 1;
            }

            // If not possible, return -1
            return false;
        }

    }


