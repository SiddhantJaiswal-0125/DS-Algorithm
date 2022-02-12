package Microsoft;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class NextSmallestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int ar[] = new int[n];
        for(int i=0;i<n;i++)
            ar[i] = sc.nextInt();
        Vector<Integer> ans = new  NextSmallestPalindrome().generateNextPalindrome(ar, n);
        for(Integer i : ans)
            System.out.print(i+"\t");
        System.out.println();

    }
    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        Vector<Integer> vi = new Vector<>();

        if(greatest(num))
        {
            n++;
                vi.add(1);
                for(int i = 1;i<n-1;i++)
                {
                 vi.add(0);
                }
                vi.add(1);



            return  vi;

        }

        else
        {
        if(n%2==0)
        {
            //even
            int i  =0, j = n-1;
            boolean isgreater = false;
            while(i<=j){
                if(num[i]>num[j])
                    isgreater = true;
                else if(num[i]<num[j] )
                    isgreater = false;
                num[j] = num[i];

                i++;
                j--;
            }


            if(isgreater==false)
            {
            int mid = n/2;

                mid--;

                while (mid >= 0) {
                    if (num[mid] == 9) {
                        num[mid] = 0;
                        mid--;
                    } else {
                        num[mid] = num[mid] + 1;
                        break;
                    }
                }

            i =0;
            j = n-1;
            while(i<j)
            {
                num[j] = num[i];
                i++;
                j--;
            }
            }
            for(i =0;i<n;i++)
                vi.add(num[i]);





        }
        else
        {
            //odd
            int i  =0, j = n-1;
            boolean isgreater = false;
            while(i<j){
                if(num[i]>num[j])
                    isgreater = true;
                else if(num[i]<num[j] )
                    isgreater = false;
                num[j] = num[i];

                i++;
                j--;
            }


            if(isgreater==false)
            {
            int mid = n/2;
            while(mid>=0)
            {
                if(num[mid]==9)
                {
                    num[mid] = 0;
                    mid--;
                }
                else
                {
                    num[mid] = num[mid]+1;
                    break;
                }
            }

            i  =0;
            j = n-1;
            while(i<j)
            {
                num[j] = num[i];
                i++;
                j--;
            }
            }
            for(i =0;i<n;i++)
                vi.add(num[i]);
        }

        return vi;
    }
    }
    boolean greatest(int num[])
    {
        for(int i:num)
            if(i!=9)
                return  false;


            return  true;
    }

}
