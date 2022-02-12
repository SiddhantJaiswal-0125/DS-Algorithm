package StackQueue;

import java.util.*;
public class LargestRectange {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = "";
        int size = s.length();

        for(int i  =0;i<size;i++)
        {
            int c= s.charAt(i) - '0';
            ans= ans + (char)('a'+c);


        }
        System.out.println(new String(ans));





    }
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int nsl[] = _nsl(heights, size);
        int nsr[] = _nsr(heights, size);
        int rect[] = new int[size];
        int max = 0 ;
        for(int i =0;i<size;i++)
        {
            int left = nsl[i];
            int right = nsr[i];
            if(right <0)
                right = size;
            rect[i] = ((right -  left) -1 ) * heights[i];
            max = Math.max(max, rect[i]);
        }


        return max;



    }
    int[] _nsr(int h[], int size)
    {
        Stack <Integer> st = new Stack<>();
        int ans[] = new int[size];
        for(int i =size-1;i>=0;i--)
        {
            while(st.isEmpty()==false)
            {
                int pop = st.peek();
                if(h[pop]>=h[i])
                    st.pop();
                else
                {
                    ans[i] = pop;
                    break;
                }

            }

            if(st.isEmpty())
                ans[i] = -1;
            st.push(i);

        }
        return ans;
    }
    int [] _nsl(int h[], int size)
    {
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[size];
        for(int i =0;i<size;i++)
        {
            while(st.isEmpty()==false)
            {
                int pop = st.peek();
                if(h[pop]>=h[i])
                    st.pop();
                else
                {
                    ans[i] = pop;
                    break;
                }

            }

            if(st.isEmpty())
                ans[i] = -1;

            st.push(i);

        }

        return ans;
    }
}
