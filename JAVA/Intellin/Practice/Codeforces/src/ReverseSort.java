import java.util.Scanner;

class ReverseSort
{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int p = 1;
        while(p<=t)
        {

            int n = sc.nextInt();
            int l [] = new int[n];
            for(int i =0;i<n;i++)
                l[i] = sc.nextInt();
            int ans = 0;


            for(int i = 0 ;i<n;i++)
            {
                int minInd = findmin(l,n,i);
                ans += cost(i, minInd);
                rev(l,i,minInd,n);
            }

            System.out.println("Case #"+(p)+": "+(ans-1));

            p++;
        }

    }

    static  void rev(int l[], int i, int j , int n)
    {
        if(i>=j)
            return;
        while(i<j )
        {
            int temp = l[i];
            l[i] = l[j];
            l[j]  = temp;
            i++;
            j--;

        }



    }

    static  int findmin(int l[], int n, int i )
    {
        int minele = l[i], ind = i;
        for(int j = i;j<n;j++ )
        {
            if(minele>l[j] )
            {
                minele = l[j];
                ind = j;
            }

        }
        return ind;
    }
    static  int cost(int i , int j )
    {
        return j-i+1;
    }


}
