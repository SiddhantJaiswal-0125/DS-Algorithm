import java.util.*;

public class primePath
{
    static ArrayList<ArrayList<Integer>> adj;
    static boolean isVisited[];
    static int dist[];
    static  ArrayList<Integer> primes;
    static boolean isPrime(int n )
    {
        for(int  i =2;i*i<=n;i++)
            if(n%i==0)
                return false;
            return true;
    }
    static boolean isValid(int a , int b)
    {
        int count =0;
        while(a>0 && b>0)
        {
            if(a%10!=b%10)
                count++;
            a/=10;b/=10;
        }


        return count==1;
    }

    static  void buildGraph()
    {

        for(int i = 1000;i<10000;i++)
            if(isPrime(i))
                primes.add(i);
        for(int i = 0;i<=10000;i++)
            adj.add(i,new ArrayList<>());



        for(int i = 0; i<primes.size();i++)
        {
            for(int j = i+1;j<primes.size();j++)
            {
                int a = primes.get(i);
                int b = primes.get(j);
                if(isValid(a,b))
                {
                    adj.get(a).add(b);
                    adj.get(b).add(a);

                }
            }
        }
    }
    static  void bfs(int src )
    {
        isVisited[src] = true;
        Queue <Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            ArrayList<Integer>  temp = adj.get(cur);
            for(int child : temp)
            {
                if(!isVisited[child])
                {

                    q.add(child);
                    isVisited [ child] = true;
                    dist[child] = dist[cur]+1;
                }
            }



        }

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dist = new int[10001];
        adj = new ArrayList<>();
        isVisited = new boolean[10001];
        primes = new ArrayList<>();
        buildGraph();

        int a = sc.nextInt();
        int b = sc.nextInt();
        Arrays.fill(dist,-1);
        bfs(a);
        if(dist[b]==-1)
            System.out.println("Impossible");
        else
            System.out.println(dist[b]);

    }
}
