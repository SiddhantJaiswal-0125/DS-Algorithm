import java.util.*;
public class WordLadder {
    boolean lastWordExits(String word, List<String> list)
    {
        for(int i =0;i<list.size();i++)
            if(word.equalsIgnoreCase(list.get(i)))
                return true;
        return false;
    }
    ArrayList<ArrayList<Integer>> ar;
    void buildGraph(List<String > list)
    {
        ar = new ArrayList<>();
        int size = list.size();
        HashMap<String, Integer> ht = new HashMap<>();

        for(int i = 0;i< list.size();i++)
            ht.put(list.get(i),i);

        for(int i =0;i<size;i++)
        {
            ar.add(new ArrayList<>());
            for(int j = 0;j<size;j++)
            {
                if(i==j)
                    continue;
                if(isPoss(list.get(i), list.get(j)))
                {
                    ar.get(i).add(j);
                }
            }
        }
        System.out.println(ar);

    }
    boolean isPoss(String a, String b)
    {
        boolean onlyOne = true;
        if(a.length()!=b.length())
            return  false;
        for(int i =0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                if(onlyOne)
                    onlyOne = false;
                else
                    return  false;
            }
        }
        return  true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(lastWordExits(endWord, wordList) == false)
            return 0;

        buildGraph(wordList);

        Queue<String> q = new ArrayDeque<>();

        for(int i =0;i<wordList.size();i++)
        {
            if(isPoss(wordList.get(i), beginWord))
                q.add(wordList.get(i));
        }

        HashSet<String> hs = new HashSet<>();

        int dis =0;
        while(q.size()>0)
        {
            int size = q.size();
            dis++;
            for(int i =0;i<size;i++)
            {
                String out = q.remove();
                if(out.equalsIgnoreCase(endWord))
                    return  dis+1;

                if(hs.contains(out))
                    continue;
                else
                {
                    hs.add(out);
                    for(int j =0;j<wordList.size();j++)
                    {
                        if(hs.contains(wordList.get(j)) == false && isPoss(wordList.get(j), out))
                            q.add(wordList.get(j));
                    }
                }



            }
        }



        return  0;
    }

    int solve(List<String>  res, String beg, String end)
    {
        Set<String> set = new HashSet<>();
        boolean present = false;
        for(String in: res)
        {
            set.add(in);
            if(end.equalsIgnoreCase(in))
                present = true;
        }
        if(present ==false)
            return  0;

        Queue<String>  q = new ArrayDeque<>();
        q.add(beg);
        int dep = 0;
        while(q.isEmpty() == false)
        {
            int size = q.size();
            dep++;
            for(int i =0;i<size;i++)
            {
                String rem = q.remove();

                for(int j =0; j<rem.length();j++)
                {
                    char ch[] = rem.toCharArray();
                    for(char c = 'a';c<='z';c++)
                    {
                        ch[j] = c;
                        String temp = new String(ch);
                        if(rem.equalsIgnoreCase(temp))
                            continue;
                        if(end.equalsIgnoreCase(temp))
                            return  dep+1;
                        if(set.contains(temp))
                        {
                            q.add(temp);
                            set.remove(temp);
                        }

                    }

                }

            }
        }

        return  dep+1;


    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String beginWord = sc.next();
         String endWord = sc.next();
         int len = sc.nextInt();
         List<String> list = new ArrayList<>();
         for(int i = 0;i<len;i++)
             list.add(sc.next());

         int ans = new WordLadder().ladderLength(beginWord, endWord, list);
        System.out.println(ans);
//        System.out.println(list);
    }
}
