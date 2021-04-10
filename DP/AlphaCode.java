public class AlphaCode{

    public static void main(String[] args) {
        int ar[] = {2,3,1,4};
        int ans1 = numCodes(ar,4);
        System.out.println(ans1);

        int ans3 = numCodesIterative(ar,4);
        System.out.println(ans3);
        int temp[]  = new int[5];
        int ans2 = numCodes2(ar,4,temp);
        System.out.println(ans2);

      

    }
    static int numCodes(int ar[], int size)
    {
        if(size==0 || size ==1)
        return 1;
        int out = numCodes(ar, size-1);
        if(ar[size-2]*10 + ar[size-1] <=26)
            out+=numCodes(ar, size-2);
        return out;    
    }

    static int numCodes2(int ar[] , int size , int t[])
    {
        if(size==0 || size ==1)
        return 1;

        if(t[size]>0)
        return t[size];
        int out = numCodes2(ar, size-1, t);
        if(ar[size-2]*10 + ar[size-1] <= 26)
            out+=numCodes2(ar, size-2,t);
        
        t[size]  = out;
        return out;    
    }


    static int numCodesIterative ( int a[] , int size)
    {
        int dp[]  = new int[size+1];
        dp[0] = 1;
        dp[1] = 1;
        // System.out.println("PRINTING DP");
        for(int  i =2;i<=size;i++)
        {
            dp[i] = dp[i-1];
            if(((a[i-2]*10) + a[i-1])<=26)
            dp[i]  += dp[i-2];
            // System.out.println("dp["+i+"] = "+dp[i]);
      
    }
    return dp[size];
    }
}
