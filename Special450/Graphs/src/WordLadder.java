
import java.util.*;
public class WordLadder {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter Start word ");
        String start = sc.next();
        System.out.println("Enter end Word");
        String end = sc.next();
        System.out.println("enter the list");
        List<String>  wordlist = new ArrayList< String>();
        for(int i = 0;i<n;i++) {
         String s = sc.next();
            wordlist.add(s);
        }

        ladderLength(start,end,wordlist);


    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

            ArrayList<ArrayList<Integer>>  adj = new ArrayList<>();
            int n = wordList.size();

//            adj.add(new ArrayList<>());
            String []  list = new String[n+1];
            list[0] = beginWord;
            int index = -1;
            for(int i = 1;i<=n;i++) {
                list[i] = wordList.get(i - 1);
                if(wordList.get(i-1).equalsIgnoreCase( endWord))
                    index=i;
            }
            for(int i = 0;i<=n;i++ )
                adj.add(new ArrayList<>());

            buildGraph(adj, list);
            int dis[] = new int[n+5];
            boolean isVis[] =  new boolean[n+5];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(0);

            while(!q.isEmpty())
            {
                int cur = q.poll();
                for(int child : adj.get(cur))
                {
                    if(!isVis[child])
                    {
                        isVis[child]  = true;
                        q.add(child);
                        dis[child] = dis[cur]+1;
                    }
                }
            }

if(index!=-1)
        System.out.println(dis[index]+1);
            else
    System.out.println("WORD is NOT PRESENT");


        return 0;
    }


    static  void buildGraph(ArrayList<ArrayList<Integer>> adj ,
                            String [] list)
    {
        for(int i = 0;i<list.length;i++)
        {
            for(int j = i+1;j<list.length;j++)
                if(check(list[i],list[j]))
                    adj.get(i).add(j);


        }
    }
    static   boolean check (String a, String b)
    {
        int count = 0;
        int i =0, j = 0;
        while(i<a.length() && j <b.length())
        {
            if(a.charAt(i)!=b.charAt(j))
                count++;
            i++;
            j++;

        }
        count+=Math.abs(a.length()-b.length());
        return  count==1;


    }
}
