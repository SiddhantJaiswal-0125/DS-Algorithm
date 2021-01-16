import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CountBinarySubstrings
{
    public static void main(String[] args) {
         Scanner  sc = new Scanner(System.in);
         int test = sc.nextInt();
         while(test-->0)
         {
             String s = sc.next();
             int ans = get( s );
             System.out.println(ans);

         }
    }
    static  int get (String s )
    {
            int n = s.length();


            int count0 = 0, count1 =0;

            int total = 0;
        ArrayList<Integer> ar = new ArrayList<>();

            for(int i =0;i<n;i++)
            {
                char c = s.charAt(i);
                if(c=='0')
                {
                    count0++;


                    if(count1>0)
                    {
                        ar.add(count1  );
                        count1=0;
                    }



                }
                else
                {
                    count1++;
                    if(count0>0)
                    {
                        ar.add(count0);
                        count0 = 0;

                    }

                }

            }
            if(count0>0)
                ar.add(count0);
            else
                ar.add(count1);
            for(int  i = 0; i<ar.size()-1;i++)
            {
                total+=Math.min(ar.get(i),ar.get(i+1));

            }


            return  total;
    }
}
