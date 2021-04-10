import java.util.Scanner;
import java.util.Stack;
public class CounttheReversals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0)
        {
            String seq = sc.next();
            int ans = solve(seq);
            System.out.println(ans);
        }
    }
    static int solve(String seq)
    {

        int n = seq.length();
        if(n%2!=0)
            return  -1;


        char a[] = seq.toCharArray();
        int open =0;
        int close = 0;



        Stack<Integer> st =new Stack<Integer>();

        for(int i =0;i<n;i++)
        {
            if(a[i] == '{')
                st.push(i);
            else
            {
                if(!st.isEmpty())
                {
                    int ind = st.pop();
                    a[i] = '-';
                    a[ind] = '-';
                }
            }
        }

        for(int i =0;i<n;i++)
        {
            if(a[i] != '-')
            {
                if(a[i] == '{')
                    open++;
                else
                    close++;



            }
        }
        return  (int)(Math.ceil(open/2.0)+Math.ceil(close/2.0));




    }


}
