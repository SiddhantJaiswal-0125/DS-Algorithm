import java.util.Arrays;
import java.util.Scanner;

public class PalindromesColoring {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int freq[] = new int[26];
            for (int i = 0; i < n; i++)
                freq[s.charAt(i) - 'a']++;

            if(n/k == 1)
                System.out.println(1);
            else
                solve2(n,k, freq);

        }
    }
    static  void solve2(int n, int k , int freq[] )
    {
        int even = 0,odd = 0;
        for(int i  =0;i<26;i++)
        {
            if(freq[i]%2==1)
                odd++;
            even += (freq[i]/2);

        }

        long min = 0;
        min = even /k;
        min = min*2;
        odd += (even %k) *2;


        if(odd>=k)
            min++;
        System.out.println(min);

    }

    static  void solve1(int k, int n, int freq[])
    {
        boolean odd[] = new boolean[k];
        int table[] = new int[k];
        int oddInd= 0;
        int in = 0;
        for(int i = 25;i>=0;i--)
        {
            int val = freq[i];
            int div = val/(2*k);
            val-= (div *2)*k;

            if(div>0)
            {
                for(int j = 0;j<k;j++)
                {
                    table[j] += (div*2);
                }
            }
            while(val>=2)
            {
                table[in] += 2;
                val-=2;
                in++;
                if(in==k)
                    in =0;


            }
            if(val==1)
            {
                int minInd = -1;
                int min = Integer.MAX_VALUE;
                for(int ind = 0;ind<k;ind++)
                {
                    if(min>table[ind] && odd[ind]== false)
                    {
                        minInd = ind;
                        min = table[ind];
                    }
                    if(minInd!=-1){
                        table[minInd]++;
                        odd[minInd] = true;}
                }

            }



        }


        int min = Integer.MAX_VALUE;
        for(int i:table) {
            System.out.print(i + "\t");
            min = Math.min(i,min);
        }System.out.println();
        System.out.println("MIN IN "+min);







    }
}
