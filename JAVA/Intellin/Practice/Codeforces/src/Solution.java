import java.util.*;

class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int ar[] = new int[size];
        for(int i = 0;i<size;i++)
        {
            ar[i] = sc.nextInt();

        }

        int ans = new Solution().trap(ar);
        System.out.println(ans);
    }


    public int trap(int[] height) {
        int size = height.length;
        int ngl[] = ngl(height);
        int ngr[] = ngr(height);
        int water[]  = new int[size];
        for(int i =0;i<size;i++)
        {
            if(ngl[i]==-1 || ngr[i]==-1)
            {
                water[i] = 0;
                continue;
            }
            else
            {
                int k =  Math.min(height[ngl[i]],height[ngr[i]]);

                water[i] = k - height[i];

            }

        }
        int total = 0;
        for(int i:water)
            total+=i;

        return total;





    }


    public static  int[] ngl(int h[])
    {
        int size = h.length;

        int ar[] = new int[size];

        Stack<pair> st = new Stack<pair>();


        for(int i = 0;i<size;i++)
        {
            if(st.isEmpty())
            {

                st.push(new pair(i, h[i]));
                ar[i] = -1;
            }
            else
            {
                while(st.isEmpty()==false && st.peek().h <=h[i])
                    st.pop();

                if(st.isEmpty()==true)
                {
                    st.push(new pair(i, h[i]));
                    ar[i] = -1;
                }
                else
                    ar[i] = st.peek().i;

            }






        }



        return ar;


    }
    public static int[] ngr(int h[])
    {
        int size = h.length;

        int ar[] = new int[size];

        Stack <pair> st = new Stack<pair>();


        for(int i = size-1;i>=0;i--)
        {



            if(st.isEmpty())
            {

                st.push(new pair(i, h[i]));
                ar[i] = -1;
            }
            else
            {
                while(st.isEmpty()==false && st.peek().h <=h[i])
                    st.pop();

                if(st.isEmpty()==true)
                {
                    st.push(new pair(i, h[i]));
                    ar[i] = -1;
                }
                else
                    ar[i] = st.peek().i;

            }




        }



        return ar;


    }

    static class pair{
        int h, i ;
        pair(int ind, int hei)
        {
            this.h = hei;
            this.i = ind;
        }
    }
}