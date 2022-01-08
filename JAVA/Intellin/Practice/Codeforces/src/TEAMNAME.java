import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

 class TEAMNAME
{
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0)
        {
            solve();
        }
    }
    static void solve()
    {
        int n = sc.nextInt();
        String names [] = new String [n];
        HashMap<String, ArrayList>  map = new HashMap<>();
        HashSet<String>  hs = new HashSet<String>();
        for(int  i =0;i<n;i++)
        {
            names[i]  = sc.next();
            hs.add(names[i]);

            String word = names[i].substring(1);
            if(!map.containsKey(word))
            {
                ArrayList <Character> h = new ArrayList<>();
                map.put(word, h);
            }

            ArrayList <Character> arc = map.get(word);
            arc.add(names[i].charAt(0));
            map.put(word, arc);
        }

        data pair []  = new data[map.size()];

        int index = 0;
        for (Map.Entry<String,ArrayList> entry : map.entrySet())
        {
            pair[index] = new data();
            pair[index].ar  =  entry.getValue();
            pair[index].key  = entry.getKey();
            index++;
        }

        long count = 0l;
        int size = map.size();
        long total = 0;

        for(int  i =0;i<size;i++)
        {
            count = 0;
            for(int j =i+1;j<size;j++)
            {
                count = 0;
                for (int k = 0; k < pair[i].ar.size(); k++)
                {
                    char c = pair[i].ar.get(k);
                    for (int l = 0; l < pair[j].ar.size(); l++)
                    {
                        char p = pair[j].ar.get(l);
                        if (c == p)
                            count++;
                    }

                }
                long q1 = (pair[i].ar.size() - count) * (pair[j].ar.size() - count);
                total += q1;
            }
        }
        System.out.println(2*total);
    }

    static String swap(String str, int index, char ch)
    {
        String res = str.substring(0, index)
                + ch
                + str.substring(index + 1);
        return  res;
  }


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
class data
{
    String key ;
    ArrayList<Character>  ar;

}
